package com.dcits.apps;

import java.util.ArrayList;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */

public class Demo {
	private final static Logger LOGGER = LoggerFactory.getLogger(Demo.class);
	private static String reactResult = "";

	public static void main(final String[] args) {

		// testRecursiveAction();

		testReactor();
		// testOptional();
	}

	public static void testReactor() {

		
	
		Flux.just("Hello", "World").subscribe(System.out::println);
		Flux.range(1, 10).subscribe(System.out::println);

			Flux.generate(sink -> {
		
			sink.next("Hello");
				sink.complete();
			}).subscribe(System.out::println);

			final Random random = new Random();
			Flux.generate(ArrayList::new, (list, sink) -> {
				int value = random.nextInt(100);
				list.add(value);
				sink.next(value);
				if (list.size() == 10) {
				sink.complete();
				}
				return list;
			}).subscribe(System.out::println);

			Flux.create(sink -> {
				for (int i = 0; i < 10; i++) {
					sink.next(i*100);
				}
				sink.complete();
			}).subscribe(System.out::println);
		
			Mono.just("hi").subscribe(System.out::println);

			Flux.range(1, 10).filter(i -> i % 2 == 0).subscribe(System.out::println);
			Flux.just(1, 2)
			.concatWith(Mono.error(new IllegalStateException()))
			.onErrorReturn(0)
			.subscribe(System.out::println);

			Flux.just(1, 2)
        .concatWith(Mono.error(new IllegalArgumentException()))
        .onErrorResume(e -> {
            if (e instanceof IllegalStateException) {
                return Mono.just(0);
            } else if (e instanceof IllegalArgumentException) {
                return Mono.just(-1);
            }
            return Mono.empty();
        })
		.subscribe(System.out::println);
		

		Flux.create(sink -> {
			sink.next(Thread.currentThread().getName());
			sink.complete();
		})
		.publishOn(Schedulers.single())
		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
		.publishOn(Schedulers.elastic())
		.map(x -> String.format("[%s] %s", Thread.currentThread().getName(), x))
		.subscribeOn(Schedulers.parallel())
		.toStream()
		.forEach(System.out::println);


		Mono.just("gogo").subscribe(System.out::println);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}


	


}

