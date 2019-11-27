package com.dcits.apps;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dcits.beans.AopDemo;
import com.dcits.beans.BookInfo;
import com.dcits.beans.CacheDemo;
import com.dcits.beans.DaoDemo;
import com.dcits.beans.Hint;
import com.dcits.beans.UserInfo;
import com.dcits.beans.ZkGetMasterBean;
import com.dcits.beans.ZkLockBean;
import com.dcits.cache.CacheUtils;
import com.dcits.daos.TestDao;
import com.dcits.exceptions.GalaxyException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */

public class Demo {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

	public static void main(String[] args) {
		// testCache();
		// testAop();
		// testCacheScript();

		// testFastjson();

		// testThreadLocal();

		// testFuture();

		// testMybatis();

		// Demo d = new Demo();
		// d.testXmlParser();

		// testApplicationListener();
		// testZk();

		// testGetMaster();

		// testCrcSlot();
		// testRegex();
		// testRetBool();
		// testSplit();
		//testRecursiveTask();
		testRecursiveAction();



	}

	private static void testSplit() {
		String ip = "10.88.2.1.102,10.88.2.103:5672";
		String[] arr = ip.split(" *, *");
		for (String a : arr) {
			System.out.println(a + ":" + arr.length);
		}
	}

	private static boolean isTrue() {
		boolean a = false;
		return a;
	}

	private static void testRetBool() {
		if (isTrue()) {
			System.out.println("ttttttt------");
		} else {
			System.out.println("fffffff------");
		}

	}

	private static void testRegex() {
		String s = "A876X";
		String s2 = "\"threadNo\":\"qtp1701931646-476\"},\"rs\":{\"ret\":[{\"retCode\":\"000000\",\"retMsg\":\"000000 SDDD\"}]},\"retStatus\":\"F\"}";
		String st = "{\"sysHead\":{\"runDate\":\"20190221\",\"seqNo\":\"16\",\"serviceCode\":\"MBSD_GA\",\"tranTimestamp\":\"170450367\",\"sourceBranchNo\":\"2400\",\"reference\":\"1902210000000007\",\"messageType\":\"1000\",\"macValue\":\"\",\"company\":\"\",\"systemId\":\"\",\"filePath\":\"\",\"destBranchNo\":\"1400\",\"authUserId\":\"\",\"sourceType\":\"MT\",\"messageCode\":\"0103\",\"tranDate\":\"20170510\",\"threadNo\":\"qtp1995837782-16\"},\"rs\":{\"ret\":[{\"retCode\":\"000000\",\"retMsg\":\"000000 SUCCESS\"}]},\"retStatus\":\"S\",\"response\":{\"createTime\":\"174838112\",\"bal\":55755,\"acctName\":\"CHENTEST\",\"status\":\"A\",\"createDate\":\"20180927\"}}";

		// 把要匹配的字符串写成正则表达式，然后要提取的字符使用括号括起来
		// 在这里，我们要提取最后一个数字，正则规则就是“一个数字加上大于等于0个非数字再加上结束符”
		// Pattern pattern = Pattern.compile("(\\d)[^\\d]*$");

		Pattern pattern = Pattern.compile("\"retCode\"\\s*:\\s*\"(.*?)\\s*\",.*retMsg\"\\s*:\\s*\"(.*?)\\s*\"");
		Pattern pattern2 = Pattern.compile("\"retStatus\"\\s*:\\s*\"(.*?)\\s*\"");

		Matcher matcher = pattern2.matcher(st);
		if (matcher.find()) {
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(1));
			// System.out.println(matcher.group(2));
		}

		matcher = pattern.matcher(st);
		if (matcher.find()) {
			System.out.println(matcher.groupCount());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			// System.out.println(matcher.group(2));
		}

	}

	/*
	 * private static int getCrc(byte[] data) { int[] table = { 0x0000, 0xC0C1,
	 * 0xC181, 0x0140, 0xC301, 0x03C0, 0x0280, 0xC241, 0xC601, 0x06C0, 0x0780,
	 * 0xC741, 0x0500, 0xC5C1, 0xC481, 0x0440, 0xCC01, 0x0CC0, 0x0D80, 0xCD41,
	 * 0x0F00, 0xCFC1, 0xCE81, 0x0E40, 0x0A00, 0xCAC1, 0xCB81, 0x0B40, 0xC901,
	 * 0x09C0, 0x0880, 0xC841, 0xD801, 0x18C0, 0x1980, 0xD941, 0x1B00, 0xDBC1,
	 * 0xDA81, 0x1A40, 0x1E00, 0xDEC1, 0xDF81, 0x1F40, 0xDD01, 0x1DC0, 0x1C80,
	 * 0xDC41, 0x1400, 0xD4C1, 0xD581, 0x1540, 0xD701, 0x17C0, 0x1680, 0xD641,
	 * 0xD201, 0x12C0, 0x1380, 0xD341, 0x1100, 0xD1C1, 0xD081, 0x1040, 0xF001,
	 * 0x30C0, 0x3180, 0xF141, 0x3300, 0xF3C1, 0xF281, 0x3240, 0x3600, 0xF6C1,
	 * 0xF781, 0x3740, 0xF501, 0x35C0, 0x3480, 0xF441, 0x3C00, 0xFCC1, 0xFD81,
	 * 0x3D40, 0xFF01, 0x3FC0, 0x3E80, 0xFE41, 0xFA01, 0x3AC0, 0x3B80, 0xFB41,
	 * 0x3900, 0xF9C1, 0xF881, 0x3840, 0x2800, 0xE8C1, 0xE981, 0x2940, 0xEB01,
	 * 0x2BC0, 0x2A80, 0xEA41, 0xEE01, 0x2EC0, 0x2F80, 0xEF41, 0x2D00, 0xEDC1,
	 * 0xEC81, 0x2C40, 0xE401, 0x24C0, 0x2580, 0xE541, 0x2700, 0xE7C1, 0xE681,
	 * 0x2640, 0x2200, 0xE2C1, 0xE381, 0x2340, 0xE101, 0x21C0, 0x2080, 0xE041,
	 * 0xA001, 0x60C0, 0x6180, 0xA141, 0x6300, 0xA3C1, 0xA281, 0x6240, 0x6600,
	 * 0xA6C1, 0xA781, 0x6740, 0xA501, 0x65C0, 0x6480, 0xA441, 0x6C00, 0xACC1,
	 * 0xAD81, 0x6D40, 0xAF01, 0x6FC0, 0x6E80, 0xAE41, 0xAA01, 0x6AC0, 0x6B80,
	 * 0xAB41, 0x6900, 0xA9C1, 0xA881, 0x6840, 0x7800, 0xB8C1, 0xB981, 0x7940,
	 * 0xBB01, 0x7BC0, 0x7A80, 0xBA41, 0xBE01, 0x7EC0, 0x7F80, 0xBF41, 0x7D00,
	 * 0xBDC1, 0xBC81, 0x7C40, 0xB401, 0x74C0, 0x7580, 0xB541, 0x7700, 0xB7C1,
	 * 0xB681, 0x7640, 0x7200, 0xB2C1, 0xB381, 0x7340, 0xB101, 0x71C0, 0x7080,
	 * 0xB041, 0x5000, 0x90C1, 0x9181, 0x5140, 0x9301, 0x53C0, 0x5280, 0x9241,
	 * 0x9601, 0x56C0, 0x5780, 0x9741, 0x5500, 0x95C1, 0x9481, 0x5440, 0x9C01,
	 * 0x5CC0, 0x5D80, 0x9D41, 0x5F00, 0x9FC1, 0x9E81, 0x5E40, 0x5A00, 0x9AC1,
	 * 0x9B81, 0x5B40, 0x9901, 0x59C0, 0x5880, 0x9841, 0x8801, 0x48C0, 0x4980,
	 * 0x8941, 0x4B00, 0x8BC1, 0x8A81, 0x4A40, 0x4E00, 0x8EC1, 0x8F81, 0x4F40,
	 * 0x8D01, 0x4DC0, 0x4C80, 0x8C41, 0x4400, 0x84C1, 0x8581, 0x4540, 0x8701,
	 * 0x47C0, 0x4680, 0x8641, 0x8201, 0x42C0, 0x4380, 0x8341, 0x4100, 0x81C1,
	 * 0x8081, 0x4040, };
	 * 
	 * 
	 * byte[] bytes = data; int crc = 0x0000; for (byte b : bytes) { crc = (crc >>>
	 * 8) ^ table[(crc ^ b) & 0xff]; }
	 * 
	 * return crc&0xffff; }
	 */

	/*
	 * public static int getSlot(String key) { int s = key.indexOf("{"); if (s > -1)
	 * { int e = key.indexOf("}", s + 1); if (e > -1 && e != s + 1) { key =
	 * key.substring(s + 1, e); } } // optimization with modulo operator with power
	 * of 2 // equivalent to getCRC16(key) % 16384 return getCRC16(key) & (16384 -
	 * 1); }
	 */

	/**
	 * Create a CRC16 checksum from the bytes. implementation is from
	 * mp911de/lettuce, modified with some more optimizations
	 * 
	 * @param bytes
	 * @return CRC16 as integer value
	 * @see https://github.com/xetorthio/jedis/pull/733#issuecomment-55840331
	 */
	public static int getRedisCRC16(byte[] bytes) {
		final int LOOKUP_TABLE[] = { 0x0000, 0x1021, 0x2042, 0x3063, 0x4084, 0x50A5, 0x60C6, 0x70E7, 0x8108, 0x9129,
				0xA14A, 0xB16B, 0xC18C, 0xD1AD, 0xE1CE, 0xF1EF, 0x1231, 0x0210, 0x3273, 0x2252, 0x52B5, 0x4294, 0x72F7,
				0x62D6, 0x9339, 0x8318, 0xB37B, 0xA35A, 0xD3BD, 0xC39C, 0xF3FF, 0xE3DE, 0x2462, 0x3443, 0x0420, 0x1401,
				0x64E6, 0x74C7, 0x44A4, 0x5485, 0xA56A, 0xB54B, 0x8528, 0x9509, 0xE5EE, 0xF5CF, 0xC5AC, 0xD58D, 0x3653,
				0x2672, 0x1611, 0x0630, 0x76D7, 0x66F6, 0x5695, 0x46B4, 0xB75B, 0xA77A, 0x9719, 0x8738, 0xF7DF, 0xE7FE,
				0xD79D, 0xC7BC, 0x48C4, 0x58E5, 0x6886, 0x78A7, 0x0840, 0x1861, 0x2802, 0x3823, 0xC9CC, 0xD9ED, 0xE98E,
				0xF9AF, 0x8948, 0x9969, 0xA90A, 0xB92B, 0x5AF5, 0x4AD4, 0x7AB7, 0x6A96, 0x1A71, 0x0A50, 0x3A33, 0x2A12,
				0xDBFD, 0xCBDC, 0xFBBF, 0xEB9E, 0x9B79, 0x8B58, 0xBB3B, 0xAB1A, 0x6CA6, 0x7C87, 0x4CE4, 0x5CC5, 0x2C22,
				0x3C03, 0x0C60, 0x1C41, 0xEDAE, 0xFD8F, 0xCDEC, 0xDDCD, 0xAD2A, 0xBD0B, 0x8D68, 0x9D49, 0x7E97, 0x6EB6,
				0x5ED5, 0x4EF4, 0x3E13, 0x2E32, 0x1E51, 0x0E70, 0xFF9F, 0xEFBE, 0xDFDD, 0xCFFC, 0xBF1B, 0xAF3A, 0x9F59,
				0x8F78, 0x9188, 0x81A9, 0xB1CA, 0xA1EB, 0xD10C, 0xC12D, 0xF14E, 0xE16F, 0x1080, 0x00A1, 0x30C2, 0x20E3,
				0x5004, 0x4025, 0x7046, 0x6067, 0x83B9, 0x9398, 0xA3FB, 0xB3DA, 0xC33D, 0xD31C, 0xE37F, 0xF35E, 0x02B1,
				0x1290, 0x22F3, 0x32D2, 0x4235, 0x5214, 0x6277, 0x7256, 0xB5EA, 0xA5CB, 0x95A8, 0x8589, 0xF56E, 0xE54F,
				0xD52C, 0xC50D, 0x34E2, 0x24C3, 0x14A0, 0x0481, 0x7466, 0x6447, 0x5424, 0x4405, 0xA7DB, 0xB7FA, 0x8799,
				0x97B8, 0xE75F, 0xF77E, 0xC71D, 0xD73C, 0x26D3, 0x36F2, 0x0691, 0x16B0, 0x6657, 0x7676, 0x4615, 0x5634,
				0xD94C, 0xC96D, 0xF90E, 0xE92F, 0x99C8, 0x89E9, 0xB98A, 0xA9AB, 0x5844, 0x4865, 0x7806, 0x6827, 0x18C0,
				0x08E1, 0x3882, 0x28A3, 0xCB7D, 0xDB5C, 0xEB3F, 0xFB1E, 0x8BF9, 0x9BD8, 0xABBB, 0xBB9A, 0x4A75, 0x5A54,
				0x6A37, 0x7A16, 0x0AF1, 0x1AD0, 0x2AB3, 0x3A92, 0xFD2E, 0xED0F, 0xDD6C, 0xCD4D, 0xBDAA, 0xAD8B, 0x9DE8,
				0x8DC9, 0x7C26, 0x6C07, 0x5C64, 0x4C45, 0x3CA2, 0x2C83, 0x1CE0, 0x0CC1, 0xEF1F, 0xFF3E, 0xCF5D, 0xDF7C,
				0xAF9B, 0xBFBA, 0x8FD9, 0x9FF8, 0x6E17, 0x7E36, 0x4E55, 0x5E74, 0x2E93, 0x3EB2, 0x0ED1, 0x1EF0, };
		int crc = 0x0000;

		for (byte b : bytes) {
			crc = ((crc << 8) ^ LOOKUP_TABLE[((crc >>> 8) ^ (b & 0xFF)) & 0xFF]);
		}
		return crc & 0xFFFF;
	}

	public static void testCrcSlot() {
		byte[] barr = { 0x01 };
		int crc = getRedisCRC16("12345".getBytes());
		LOGGER.info("crc info:{},{}", crc, crc % 16384);

	}

	public static void testAop() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "app.xml", "classpath*:META-INF/spring/*.xml" });
		CacheDemo cacheDemo = appContext.getBean(CacheDemo.class);
		AopDemo aopDemo = appContext.getBean(AopDemo.class);

		while (true) {

			/*
			 * LOGGER.info("get cache:{},{}", cacheDemo.getName(),cacheDemo.getAge()); try {
			 * Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
			 */

			LOGGER.info("get aop:{},{}", aopDemo.getName(), aopDemo.getAge());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testCache() {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "app.xml", "classpath*:META-INF/spring/cache.xml" });
		CacheDemo cacheDemo = appContext.getBean(CacheDemo.class);
		int i = 0;
		while (true) {
			i++;
			UserInfo uinfo = cacheDemo.getUserInfoById(3L);
			LOGGER.info("get user cache:{},{}", uinfo.getName(), uinfo.getAge());
			// cacheDemo.setName("kxw-"+i);

			/*
			 * BookInfo binfo = cacheDemo.getBookInfoById("33");
			 * LOGGER.info("get book cache:{},{}", binfo.getTitle(),binfo.getPrice());
			 */

			if (i == 3) {

				uinfo.setName("999");
				cacheDemo.updateUserInfo(uinfo);

				/*
				 * binfo.setTitle("book999"); cacheDemo.updateBookInfoById(binfo);
				 */

			}
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			/*
			 * LOGGER.info("get aop:{},{}", aopDemo.getName(),aopDemo.getAge()); try {
			 * Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
			 */
		}
	}

	public static void testCacheScript() {
		CacheUtils cu = new CacheUtils("uu");
		cu.testScript();
	}

	public static class JsonClass {
		private String key1;

		public String getKey1() {
			return key1;
		}

		public void setKey1(String key1) {
			this.key1 = key1;
		}

		public String getKey2() {
			return key2;
		}

		public void setKey2(String key2) {
			this.key2 = key2;
		}

		private String key2;

	}

	public static void testFastjson() {
		JSONObject myJson = new JSONObject();
		myJson.put("key1", "val1");
		myJson.put("key2", "val2");

		LOGGER.info("get json:{},{}", myJson.toString(), myJson.toJSONString());
		String jstr = myJson.toJSONString();
		JsonClass jc = JSON.parseObject(jstr, JsonClass.class);

		LOGGER.info("get class:{},{}", jc.getKey1(), jc.getKey2());

	}

	static ThreadLocal<Map<String, Object>> thdData = new ThreadLocal<Map<String, Object>>() {

		@Override
		protected Map<String, Object> initialValue() {

			return new HashMap<String, Object>();

		}

	};

	

	public static void testThreadLocal()
	{
		thdData.get().put("key1", "val1");
		Stack<String> st = new Stack<String>();
		thdData.get().put("stk1", st);
		st.push("v1");
		st.push("v2");
		st.push("v3");
		Thread th  = new Thread(()->
		{
			LOGGER.info("in thread,{},{}", thdData.get().get("key1"), thdData.get().get("stk1"));

		});
		th.start();
		Stack<?> stf = (Stack<String>)thdData.get().get("stk1");
		LOGGER.info("out thread,{},{},{}, {}", thdData.get().get("key1"), stf.pop(),stf.peek(),stf.size());

		try {
			th.join();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}



	public static void testFuture()
	{
		ThreadFactory namedThreadFactory = new NamedThreadFactory("BatchSplitWorker");
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, queue, namedThreadFactory);
		List<Future<String>> allRet = new ArrayList<>();
		List<Integer> ind = new ArrayList<>();
		ind.add(1);
		ind.add(2);
		ind.add(3);
		ind.add(4);
		ind.add(5);
		int size = 5;
		/*for(int i = 0; i < size; i ++) {
			final int index = i;
			allRet.add(
					executor.submit(new Callable<String>() {
				@Override
				public String call() throws Exception {
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					LOGGER.info("callable finish,{}", index);
					return ("oo_"+index);
				}
			})
			);
		}*/


		ind.forEach(o->{
			final int index = o.intValue();
			allRet.add(
					executor.submit(()->{
							try {
								Thread.sleep(1000);
							}
							catch (InterruptedException e1) {
								e1.printStackTrace();
							}
							LOGGER.info("callable finish,{}", index);
							return ("oo_"+index);
					})
			);
		});




		LOGGER.info("main cointinue");

		allRet.forEach(o -> {
			try {
				LOGGER.info("get:{}", o.get());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch (ExecutionException e) {
				e.printStackTrace();
			}
		});

		LOGGER.info("return;");


	}


	public static void testRecursiveTask() {
		int arr[] = new int[1000];
		Random random = new Random();
		int total = 0;
		// 初始化100个数字元素
		for (int i = 0; i < arr.length; i++) {
			int temp = random.nextInt(100);
			total += (arr[i] = temp);
		}
		System.out.println("初始化时的总和=" + total);
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		Integer integer = forkJoinPool.invoke(new RecursiveTaskDemo(arr, 0, arr.length));
		System.out.println("计算出来的总和=" + integer);
		forkJoinPool.shutdown();

	}

	public static void testRecursiveAction() {

		ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		forkJoinPool.submit(new RecursiveActionDemo(0, 100));
		try {
			forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    forkJoinPool.shutdown();

	}




	public static void testMybatis()
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"db.xml"});
		TestDao testDao = appContext.getBean(TestDao.class);
		DaoDemo dd = new DaoDemo();
		dd.setId(111);
		DaoDemo info = testDao.findById(111);
		LOGGER.info("get dao:{},{}", testDao.getCount(dd),info.toString());

		List<DaoDemo> linfo = testDao.getLimit(3);
		linfo.forEach(o -> LOGGER.info(o.toString()));
	}






//-------------------------


	private static Hint parseHint(Element element) {
		 final  String HINT_SDB = "sdb";
		 final  String HINT_TS = "ts";
		Hint hint = new Hint();
		String sdbComment = element.getAttribute(HINT_SDB);
		if (sdbComment != null && sdbComment.length() > 0) {
			hint.setSdb(sdbComment);
		}
		String tsComment = element.getAttribute(HINT_TS);
		if (tsComment != null && tsComment.length() > 0) {
			hint.setTs(tsComment);
		}
		return hint;
	}

	private static List<String> parseSqlmaps(NodeList nodes) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < nodes.getLength(); i++) {
			Node node = nodes.item(i);
			if (node instanceof Element) {
				Text text = (Text) node.getFirstChild();
				list.add(text.getData().trim());
			}
		}
		return list;
	}
	public  DocumentBuilder createDocumentBuilder() throws ParserConfigurationException {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	//	new SimpleErrorHandler(logger)
		factory.setNamespaceAware(true);
		final int VALIDATION_NONE = 0;
		final int VALIDATION_DTD = 1;
		final int VALIDATION_XSD = 2;
		final String SCHEMA_LANGUAGE_ATTRIBUTE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
		final String XSD_SCHEMA_LANGUAGE = "http://www.w3.org/2001/XMLSchema";
		//EntityResolver = resolver = ClasspathEntityResolver.getInstance()

		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		//docBuilder.setErrorHandler(errorHandler);
		return docBuilder;

	}
	public  void testXmlParser()
	{
		Map<String, Hint> mapping = new HashMap<>();
		 Resource[] locations = null;
		DocumentBuilder builder = null;
		 final ResourcePatternResolver resourceResolver;
		resourceResolver = new PathMatchingResourcePatternResolver(getClass().getClassLoader());
		Logger logger = LoggerFactory.getLogger(Demo.class);

		try {
			locations = resourceResolver.getResources("classpath*:/hint/*.xml");
		}catch (IOException e){
		}

		if(locations != null) {
			try {
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				builder = factory.newDocumentBuilder();
			}
			catch (ParserConfigurationException e) {
				e.printStackTrace();
			}

			for (Resource resource : locations) {
				if (!resource.exists() || !resource.isReadable()) {
					throw new GalaxyException("can't read hint xml file:" + resource.toString());
				}
				try {

					Document doc = builder.parse(resource.getInputStream());
					Element root = doc.getDocumentElement();
					NodeList hints = root.getChildNodes();
					int size = hints.getLength();
					for (int i = 0; i < size; i++) {
						Node e = hints.item(i);
						if (e instanceof Element) {
							Hint hint = parseHint((Element) e);
							List<String> sqlmaps = parseSqlmaps(e.getChildNodes());
							for (String sqlmap : sqlmaps) {
								mapping.put(sqlmap, hint);
							}
						}
					}

				}
				catch (Exception e) {
					;
				}
			}
		}
			mapping.forEach((k,hint)->LOGGER.info("hint:{},{}", k,hint.toString()));

			String containStr = "com.dcits.galaxy";
			long count = mapping.entrySet().stream()
					.filter(x->x.getKey().contains(containStr))
					.count();
			LOGGER.info("count contains {}:{}",containStr,count);


		Map<String, Hint> containedMapping =
				mapping.entrySet().stream()
				.filter(x->x.getKey().contains(containStr))
				.collect(Collectors.toMap(x->x.getKey(), x->x.getValue()));


		containedMapping.forEach((k,hint)->LOGGER.info("collected hint:{},{}", k,hint.toString()));


	}





	//----------

	public static void testApplicationListener()
	{
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"app-annotations.xml"});
	}


	//--------------
	public static void testZk() {


		//zkClient.delete(path);
		//zkClient.createEphemeral(lockPath,lockValue);
		int size = 5;
		ThreadFactory namedThreadFactory = new NamedThreadFactory("BatchSplitWorker");
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15, 60, TimeUnit.SECONDS, queue, namedThreadFactory);

		List<Future<String>> allRet = new ArrayList<>();
		ZkLockBean zk = new ZkLockBean();
		for (int i = 0; i < size; i++) {
			final int index = i;
			allRet.add(
					executor.submit(new Callable<String>() {
						@Override
						public String call() throws Exception {

							//ZkLockBean zk = new ZkLockBean();
							boolean isLock = zk.lock();
							if (isLock) {

								LOGGER.info("callable success-------------------{}", index);
								try {
									Thread.sleep(1000);
								}
								catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								zk.unlock();
							}else{
								LOGGER.info("callable failed-------------------{}", index);
							}

							return ("oo_" + index);
						}
					})
			);




		}


		/*for (int i = 0; i < size; i++) {

			new Thread(()->{
				boolean isLock = zk.lock();
				if (isLock) {

					LOGGER.info("callable can be finish-------------------{}", Thread.currentThread().getId());
					try {
						Thread.sleep(1000);
					}
					catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					zk.unlock();
				}
			}
			).start();
		}*/




	}



	public static void testGetMaster() {


		//zkClient.delete(path);
		//zkClient.createEphemeral(lockPath,lockValue);
		int size = 5;
		ThreadFactory namedThreadFactory = new NamedThreadFactory("BatchSplitWorker");
		BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 15, 60, TimeUnit.SECONDS, queue, namedThreadFactory);

		List<Future<ZkGetMasterBean>> allRet = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			final int index = i;
			allRet.add(
					executor.submit(new Callable<ZkGetMasterBean>() {
						@Override
						public ZkGetMasterBean call() throws Exception {

							ZkGetMasterBean zk = new ZkGetMasterBean();
							boolean isLock = zk.TryMaster();
							if (isLock) {

								//LOGGER.info("callable success, master-------------------{}", index);
								/*try {
									Thread.sleep(1000);
								}
								catch (InterruptedException e1) {
									e1.printStackTrace();
								}
								zk.CancelMaster();*/
							}
							else {
								//LOGGER.info("callable failed-------------------{}", index);
							}

							return zk;
						}
					})
			);
		}

			while(true) {
				for (int j = 0; j < size; j++) {
					try {
						ZkGetMasterBean zk = allRet.get(j).get();
						if(zk.isMaster()){
							LOGGER.info("current master-------------------:{}", j);
							zk.CancelMaster();
						}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}
					catch (ExecutionException e) {
						e.printStackTrace();
					}
				}

				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}





	}


}

