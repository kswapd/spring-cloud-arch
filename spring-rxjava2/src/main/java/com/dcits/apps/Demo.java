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
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */

public class Demo {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);
	private static String reactResult = "";

	public static void main(final String[] args) {

		// testRecursiveAction();

		testReactive();
		// testOptional();
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

	public static void testOptional() {
		String a = "ok";
		String n = null;
		// String c = Optional.ofNullable(n).get();
		Optional<String> d = Optional.ofNullable(n);
		// Optional.
		// System.out.println(n.toLowerCase());

		// System.out.println(d.get().toLowerCase());
		// d.ifPresent(m -> System.out.println(m));

		Optional<String> re = Optional.ofNullable(n).flatMap(s -> Optional.ofNullable(s))
				// .flatMap(s -> s.toLowerCase());
				.map(s -> s.toLowerCase());
		re.ifPresent(m -> System.out.println(m));

		// boolean is2017 = d.filter(y -> y.equals("ok")).isPresent();
		// System.out.println(is2017);

		/*
		 * List<String> companyNames = Arrays.asList( "paypal", "oracle", "",
		 * "microsoft", "", "apple"); Optional<List<String>> listOptional =
		 * Optional.of(companyNames);
		 */
		// listOptional.map(a->a.size());

	}

	public static void testReactive() {

		Observable<String> observable = Observable.just("Hello");
		observable.subscribe(s -> {

			String result = s;
			System.out.println(result);
		});

		String[] letters = { "a", "b", "c", "d", "e", "f", "g" };
		Observable<String> observable2 = Observable.fromArray(letters);

		// String result;
		observable2.subscribe(i -> {
			String result = null;
			result = i;
			System.out.println(result);
		}, // OnNext
				Throwable::printStackTrace, // OnError
				() -> {
					String result = null;
					result = "_Completed";
					System.out.println(result);
				} // OnCompleted
		);

		observable2.map(String::toUpperCase).map(r -> r).subscribe(letter -> {
			System.out.println(letter);
			reactResult += letter;
			System.out.println(reactResult);
		});



		LOGGER.info("Current thread is : " + Thread.currentThread().getName());
		Observable.create(new ObservableOnSubscribe<Integer>() { // 第一步：初始化Observable
			@Override
			public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
				LOGGER.info("Observable thread is : " + Thread.currentThread().getName());
				LOGGER.info("Observable emit 1");
				e.onNext(1);
				LOGGER.info("Observable emit 2");
				e.onNext(2);
				LOGGER.info("Observable emit 3");
				e.onNext(3);
				e.onComplete();
				LOGGER.info("Observable emit 4");
				e.onNext(4);
			}
		})
		.subscribeOn(Schedulers.newThread())
		.observeOn(Schedulers.newThread())
		
		.doOnNext(new Consumer<Integer>() {
			@Override
			public void accept(@NonNull Integer v) throws Exception {
				LOGGER.info("Consumer 1 value:{},Current thread is {}", v, Thread.currentThread().getName());
			}
		})
		.map(s -> s+100)
		//.map(new Function())
		.map(new Function<Integer, Integer>(){
			@Override
			public Integer apply(Integer integer) throws Exception {
				return integer*10;
			}
		})
		.observeOn(Schedulers.newThread())
		.doOnNext(new Consumer<Integer>() {
			@Override
			public void accept(@NonNull Integer v) throws Exception {
				LOGGER.info("Consumer 2 value:{},Current thread is {}", v, Thread.currentThread().getName());
			}
		})
		
		.observeOn(Schedulers.newThread())
		.subscribe(new Observer<Integer>() { // 第三步：订阅

			// 第二步：初始化Observer
			private int i;
			private Disposable mDisposable;

			@Override
			public void onSubscribe(@NonNull Disposable d) {
				mDisposable = d;
				LOGGER.info("Observer onSubscribe");
			}

			@Override
			public void onNext(@NonNull Integer v) {
				LOGGER.info("Observer value:{},Current thread is {}", v, Thread.currentThread().getName());
				i++;
				if (i == 2) {
					// 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
					//mDisposable.dispose();
				}
			}

			@Override
			public void onError(@NonNull Throwable e) {
				LOGGER.info("onError : value : " + e.getMessage() + "\n");
			}

			@Override
			public void onComplete() {
				LOGGER.info("onComplete");
			}
		});
		/*.subscribe(new Consumer <Integer> () {
			@Override
			public void accept(Integer v) throws Exception {
				LOGGER.info("Observer value:{},Current thread is {}", v, Thread.currentThread().getName());

			}
		});*/
	
/*

		Observable observable55 = Observable.create(new ObservableOnSubscribe<Integer>() {
			@Override
			public void subscribe(ObservableEmitter<Integer> e) throws Exception {
				LOGGER.info("=========================currentThread name: " + Thread.currentThread().getName());
				e.onNext(1);
				e.onNext(2);
				e.onNext(3);
				e.onComplete();
			}
		});
		
		Observer observer55 = new Observer<Integer>() {
			@Override
			public void onSubscribe(Disposable d) {
				LOGGER.info("======================onSubscribe");
			}
		
			@Override
			public void onNext(Integer integer) {
				LOGGER.info("======================onNext " + integer);
			}
		
			@Override
			public void onError(Throwable e) {
				LOGGER.info("======================onError");
			}
		
			@Override
			public void onComplete() {
				LOGGER.info("======================onComplete");
			}
		};
		
		observable55.subscribe(observer55);
	
*/

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}


	


}

