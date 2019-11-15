package com.dcits.cache;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */

import com.dcits.exceptions.CacheException;
import com.dcits.utils.ConsistencyCacheUtils;
import com.dcits.utils.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import redis.clients.jedis.Jedis;


/**
 * 封装 存储 中间数据-Object
 * @author tangxlf
 * @date   2014-12-25
 *
 */
public class CacheUtils implements Cache {

	private static final Logger logger = LoggerFactory
			.getLogger(CacheUtils.class);

	/**
	 * 为了区分跟具体业务的key的冲突，引入平台级的key前缀
	 */
	private static final String KEY_PREFIX = "UTILS_";

	//private RedisTemplate redisTemplate = null;

	private String name = "default";

	private byte[] setKey;

	private int period = 1000;


	Jedis jedis = new Jedis("10.88.2.109", 6379);

	public CacheUtils() {
		this.setName(name);
	}

	public CacheUtils(String name) {
		this.setName(name);
	}

	/*public RedisCache(String name, int period) {
		this.setName(name);

	}*/

	public void setName(String name) {
		if (logger.isInfoEnabled()) {
			logger.info("Create a name for the '" + name + "' of RedisCache.");
		}
		this.name = name;
		this.setKey = SerializationUtils.serialize(KEY_PREFIX + getName());
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public Object getNativeCache() {
		return null;
	}

	@Override
	public ValueWrapper get(Object key) {
		ValueWrapper wrapper = null;

		byte[] bKey = getByteKey(key);
		try {
			Object objRet = SerializationUtils.deserializeObj(
					jedis.get(bKey));
			wrapper = wrapValue(objRet);
		} catch (Throwable t) {
			throw new CacheException(t.getMessage(), t);
		}

		if (logger.isInfoEnabled()) {
			if (wrapper == null) {
				logger.info("Get the value from the cache[key= " + key
						+ ", not hit].");
			} else {
				logger.info("Get the value from the cache[key= " + key
						+ ", hit].");
				if (logger.isDebugEnabled()) {
					logger.debug("value is [" + wrapper.get().toString() + "]");
				}
			}
		}
		return wrapper;
	}

	@Override
	public void put(Object key, Object value) {
		if (value == null) {
			return;
		}

		if (logger.isInfoEnabled()) {
			logger.info("Setting value into cache[key = " + key + "].");
		}
		if (logger.isDebugEnabled()) {
			logger.debug("value is [" + value.toString() + "]");
		}
		// 采用相对原生的调用，避免多次的resource的get和return
		byte[] bKey = getByteKey(key);
		try {
			//XXX 硬编码的方式实现，考虑更好的机制
			//if (TransactionAwareCacheDecorator.CACHE_UPDATE_HOLDER.equals(value))
			{
				jedis.set(bKey, SerializationUtils.serializeObj(value));
				return;
			}

			// set本身的K/V
			/*redisTemplate.setnx(bKey, SerializationUtils.serializeObj(value));
			if (this.period != ITempCache.FOREVER_EXPIRE) {
				redisTemplate.expire(bKey, this.period);
			}

			// set缓存集合与K的关系
			redisTemplate.sadd(this.setKey, bKey);*/
		} catch (Throwable t) {
			throw new CacheException(t.getMessage(), t);
		}
	}



	@Override
	public void evict(Object key) {
		if (logger.isInfoEnabled()) {
			logger.info("Delete value from cache[key = " + key + "].");
		}
		// 采用相对原生的调用，避免多次的resource的get和return
		byte[] bKey = getByteKey(key);
		try {
			// set缓存集合与K的关系
			//jedis.sremove(this.setKey, bKey);

			// set本身的K/V
			jedis.del(bKey);
			String str1 = "return redis.call('get','kkk')";
			Object o = jedis.eval(str1);
			logger.info("----"+o.toString());
		} catch (Throwable t) {
			throw new CacheException(t.getMessage(), t);
		}
	}

	@Override
	public void clear() {

		/*try {
			Set<byte[]> keys = redisTemplate.smembers(this.setKey);
			if (logger.isInfoEnabled()) {
				StringBuilder sb = new StringBuilder();
				sb.append("clear cache:").append(name).append(". keys[");
				for (byte[] key : keys) {
					sb.append(SerializationUtils.deserialize(key)).append(",");
				}
				sb.append("]");
				logger.info(sb.toString());
			}
			for (byte[] key : keys) {
				redisTemplate.sremove(setKey, key);
				redisTemplate.del(key); // 不存在的key会被忽略
			}
//			redisTemplate.del(this.setKey);
		} catch (Throwable t) {
			throw new CacheException(t.getMessage(), t);
		}*/
	}

	/**
	 * 保证业务key为byte[]类型，并添加前缀支持。
	 *
	 * @param key
	 * @return
	 */
	private byte[] getByteKey(Object key) {
		if (key instanceof String) {
			return SerializationUtils.serialize(KEY_PREFIX + name + "_" + (String) key);
		} else {
			byte[] bKey = SerializationUtils.serializeObj(key);
			return byteMerger(setKey, bKey);
		}
	}

	private byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	protected ValueWrapper wrapValue(Object value) {
		return value == null ? null : new SimpleValueWrapper(value);
	}

	/*protected RedisTemplate getRedisTemplate() {
		return redisTemplate;
	}

	public void setRedisTemplate(RedisTemplate redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
*/
	/*@Override
	public void afterPropertiesSet() throws Exception {
		if (redisTemplate == null) {
			redisTemplate = SpringApplicationContext.getContext().getBean(RedisTemplate.class);
		}
	}*/


	/**
	 * 适配 Spring 4.x 版本
	 */
	public <T> T get(Object key, Class<T> type) {
		ValueWrapper wrapper = get(key);
		return wrapper == null ? null : type.cast(wrapper.get());
	}






	/**
	 * 适配 Spring 4.x 版本
	 */
	public ValueWrapper putIfAbsent(Object key, Object value) {
		if (logger.isInfoEnabled()) {
			logger.info("Setting value into cache[key = " + key + "] if absent");
		}
		byte[] bKey = getByteKey(key);
		try {
			Object oldValue = SerializationUtils.deserializeObj(jedis.get(bKey));
			ValueWrapper oldValueWrapper = wrapValue(oldValue);
			// set本身的K/V
			if (value != null && jedis.setnx(bKey, SerializationUtils.serializeObj(value))!=0) {
				/*if (this.period != ITempCache.FOREVER_EXPIRE) {
					redisTemplate.expire(bKey, this.period);
				}
				// set缓存集合与K的关系
				redisTemplate.sadd(this.setKey, bKey);*/
				return null;
			}

			return oldValueWrapper;
		} catch (Throwable t) {
			throw new CacheException(t.getMessage(), t);
		}
	}

	private static final String EVICT_SCRIPT_FILE = "redis-cache/Evict.lua";
	private static final String GET_SCRIPT_FILE = "ConsistentGet.lua";
	private static final String PUT_SCRIPT_FILE = "ConsistentPut.lua";
	private static final String PREPARE_EVICT_SCRIPT_FILE = "redis-cache/ConsistentPrepareEvict.lua";
	private static final String RELEASE_EVICT_SCRIPT_FILE = "redis-cache/ConsistentReleaseEvict.lua";

	private static final byte[] GET;
	private static final byte[] PUT;
	/*private static final byte[] EVICT;
	private static final byte[] PREPARE_EVICT;
	private static final byte[] RELEASE_EVICT;*/
	static {
		GET = ConsistencyCacheUtils.loadRedisScript(GET_SCRIPT_FILE);
		PUT = ConsistencyCacheUtils.loadRedisScript(PUT_SCRIPT_FILE);
		/*EVICT = ConsistencyCacheUtils.loadRedisScript(EVICT_SCRIPT_FILE);
		PREPARE_EVICT = ConsistencyCacheUtils.loadRedisScript(PREPARE_EVICT_SCRIPT_FILE);
		RELEASE_EVICT = ConsistencyCacheUtils.loadRedisScript(RELEASE_EVICT_SCRIPT_FILE);*/
	}
	public void testScript()
	{
		String key1 = "key1";
		String key2 = "key2";
		byte[] bKey1 = getByteKey(key1);
		byte[] bKey2 = getByteKey(key2);

		byte []v1 = SerializationUtils.serializeObj("kxw333");

		jedis.eval(PUT, 1, bKey1, v1);
		Object obj = jedis.eval(GET,2, bKey1, bKey2);
		Object objRet = SerializationUtils.deserializeObj((byte [])obj);
		logger.info("obj:"+objRet.toString());

		String snames="192.168.2.54:2181,192.168.2.219:2181,192.168.2.247:2181;";
		String[] shardArray = snames.split(";");
		logger.info(""+shardArray.length);

	}

}

