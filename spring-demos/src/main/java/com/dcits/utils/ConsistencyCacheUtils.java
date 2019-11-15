package com.dcits.utils;

import com.dcits.exceptions.CacheException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.ScriptingCommands;

/**
 * Created by kongxiangwen on 11/8/18 w:45.
 */
public class ConsistencyCacheUtils {
	private ConsistencyCacheUtils() {}

	public static byte[] loadRedisScript(String file) {
		try(InputStream is = ConsistencyCacheUtils.class.getClassLoader().getResourceAsStream("META-INF/lua/" + file)){
			if(is == null) {
				throw new CacheException("file not exsit");
			}
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] bytes = new byte[8192];
			int len = -1;
			while((len = is.read(bytes)) != -1) {
				bos.write(bytes, 0, len);
			}
			return bos.toByteArray();
		} catch (IOException e) {
			throw new CacheException(e);
		}
	}

	public static String calcScriptSha1(String file) {
		byte[] script = loadRedisScript(file);
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] bits = md.digest(script);
			StringBuilder sb = new StringBuilder();
			for(byte b : bits) {
				int a = b & 0xff;
				if (a < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(a));
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/*public static String getScriptSha1(String file, ScriptingCommands redis) {
		byte[] content = loadRedisScript(file);

		return redis.scriptLoad(content);
	}*/
}
