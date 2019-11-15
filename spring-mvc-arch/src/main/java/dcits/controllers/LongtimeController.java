package dcits.controllers;

/**
 * Created by kongxiangwen on 5/21/18 w:21.
 */
import dcits.models.Animal;
import dcits.models.People;
import dcits.services.TaskService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class LongtimeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/*@Autowired
	People p;
	@Autowired
	Animal animal;
*/
	@Autowired
	TaskService taskService;
	private AtomicLong aLong;
	private ThreadLocal<Integer> accessNum;
	@PostConstruct
	private void init()
	{
		logger.info("inited:"+Thread.currentThread().getId());
		aLong = new AtomicLong();

	}
	@GetMapping("/longtime")
	@ResponseBody
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) throws ExecutionException, InterruptedException {
		logger.info("start:"+Thread.currentThread().getId());
		try {
			Thread.sleep(1000);
			aLong.incrementAndGet();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		new Thread(
				()->logger.info("hi")
		).start();

		new Thread() {
			public void run() {
				logger.info("hihi");
			}
		}.start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				logger.info("hihihi");
			}
		}).start();



		ExecutorService executorService = Executors.newCachedThreadPool();
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newFixedThreadPool(3);

		Future future = executorService.submit(new Runnable() {
			@Override
			public void run(){
				try {
					Thread.sleep(3000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("task1:"+Thread.currentThread().getId());
			}

			});

		future = executorService.submit(()-> {
				try {
					Thread.sleep(4000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("task11:"+Thread.currentThread().getId());


		});

		Long [] b = new Long[]{(long)3,(long)4,(long)5};
		ArrayList<Long> arr = new ArrayList<Long>();
		arr.addAll(Arrays.asList(b));
		arr.forEach(v-> {
			logger.info(""+v);
				}
		);
		Future<Integer> future2 = executorService.submit(new Callable<Integer>() {
			@Override
			public Integer call(){
				try {
					Thread.sleep(6000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				logger.info("task2:"+Thread.currentThread().getId());
				return 2;
			}

		});

		executorService.shutdown();
//trigger waiting
		logger.info("future2 value:"+future2.get().intValue());
		logger.info("finished");
		return "longtime: " + aLong.get();
	}




	@GetMapping("/callable")
	@ResponseBody
	public Callable<String> callableMethod(@RequestParam(name="name", required=false, defaultValue="World") String name) throws ExecutionException, InterruptedException {
		logger.info("start callableMethod:"+Thread.currentThread().getId());

		//result must be assigned in this thread.
		Callable ca = new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(8000);
				logger.info("in callable:"+Thread.currentThread().getId());
				return "callableMethod:"+String.valueOf(aLong.incrementAndGet());
			}
		};

		logger.info("end callableMethod:"+Thread.currentThread().getId());
		return ca;

	}






	@GetMapping("/deferredResult")
	@ResponseBody
	public DeferredResult<String> deferredResultMethod(@RequestParam(name="name", required=false, defaultValue="World") String name) throws ExecutionException, InterruptedException {
		logger.info("start deferedResultMethod:"+Thread.currentThread().getId());


		DeferredResult<String> deferredResult = new DeferredResult<>();
		//CompletableFuture.supplyAsync(taskService::runTask)
		//		.whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

		taskService.SetDeferredResult(deferredResult);

		ExecutorService executorService = Executors.newCachedThreadPool();

		//result is assigned in another user control thread
		executorService.submit(
				()->{
					taskService.runTask();
				}
		);
		logger.info("end deferedResultMethod:"+Thread.currentThread().getId());
		return deferredResult;

	}







	@GetMapping("/longtime2")
	@ResponseBody
	public String greeting2(@RequestParam(name="name", required=false, defaultValue="World") String name) throws ExecutionException, InterruptedException {
		logger.info("longtime2:"+Thread.currentThread().getId());
		try {
			Thread.sleep(8000);
			aLong.incrementAndGet();
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}


		return "longtime2: " + aLong.get();
	}

}
