package com.dcits.apps;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

import io.reactivex.Observable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */

public class Demo {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);
	private  static String reactResult = "";
	public static void main(final String[] args) {

		// testRecursiveAction();

		//testReactive();
		testOptional();
	}

	public static void testFuture() {
		final ThreadFactory namedThreadFactory = new NamedThreadFactory("BatchSplitWorker");
		final BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		final ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, queue,
				namedThreadFactory);
		final List<Future<String>> allRet = new ArrayList<>();
		final List<Integer> ind = new ArrayList<>();
		ind.add(1);
		ind.add(2);
		ind.add(3);
		ind.add(4);
		ind.add(5);
		final int size = 5;
		/*
		 * for(int i = 0; i < size; i ++) { final int index = i; allRet.add(
		 * executor.submit(new Callable<String>() {
		 * 
		 * @Override public String call() throws Exception { try { Thread.sleep(1000); }
		 * catch (InterruptedException e1) { e1.printStackTrace(); }
		 * LOGGER.info("callable finish,{}", index); return ("oo_"+index); } }) ); }
		 */

		ind.forEach(o -> {
			final int index = o.intValue();
			allRet.add(executor.submit(() -> {
				try {
					Thread.sleep(1000);
				} catch (final InterruptedException e1) {
					e1.printStackTrace();
				}
				LOGGER.info("callable finish,{}", index);
				return ("oo_" + index);
			}));
		});

		LOGGER.info("main cointinue");

		allRet.forEach(o -> {
			try {
				LOGGER.info("get:{}", o.get());
			} catch (final InterruptedException e) {
				e.printStackTrace();
			} catch (final ExecutionException e) {
				e.printStackTrace();
			}
		});

		LOGGER.info("return;");

	}

	public static void testRecursiveTask() {
		final int arr[] = new int[1000];
		final Random random = new Random();
		int total = 0;
		// 初始化100个数字元素
		for (int i = 0; i < arr.length; i++) {
			final int temp = random.nextInt(100);
			total += (arr[i] = temp);
		}
		System.out.println("初始化时的总和=" + total);
		final ForkJoinPool forkJoinPool = new ForkJoinPool();
		final Integer integer = forkJoinPool.invoke(new RecursiveTaskDemo(arr, 0, arr.length));
		System.out.println("计算出来的总和=" + integer);
		forkJoinPool.shutdown();

	}

	public static void testRecursiveAction() {

		final ForkJoinPool forkJoinPool = new ForkJoinPool(2);
		forkJoinPool.submit(new RecursiveActionDemo(0, 100));
		try {
			forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		forkJoinPool.shutdown();

	}
	public static void testOptional()
	{
		String a = "ok";
		String n = null;
		//String c = Optional.ofNullable(n).get();
		Optional<String> d = Optional.ofNullable(a);
		d.ifPresent(m -> System.out.println(m));

		boolean is2017 = d.filter(y -> y.equals("ok")).isPresent();
		//Optional.
		System.out.println(is2017);

		/*List<String> companyNames = Arrays.asList(
      "paypal", "oracle", "", "microsoft", "", "apple");
    Optional<List<String>> listOptional = Optional.of(companyNames);*/
		//listOptional.map(a->a.size());

	}
	public static void testReactive() {
		/*
		 * new SimpleReact().of(1,2,3,4,5) .then(num -> num+100)
		 * .peek(System.out::println);
		 */
		//String result = null;
		 Observable<String> observable = Observable.just("Hello");
				 observable.subscribe(s -> {
					
					 String result = s;
					 System.out.println(result);
				 });


				 String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
				 Observable<String> observable2 = Observable.fromArray(letters);
				 
				// String result;
		observable2.subscribe(
				   i -> {String result = null; result = i;System.out.println(result);},  //OnNext
				   Throwable::printStackTrace, //OnError
				   () -> {String result = null; result = "_Completed";System.out.println(result);} //OnCompleted
				 );
				 
				 observable2.map(String::toUpperCase)
				 .map(r -> r)
				 .subscribe(letter -> {System.out.println(letter);reactResult += letter;System.out.println(reactResult);});

				 
				

	}


	


}

