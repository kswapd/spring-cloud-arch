package main.controllers;


import models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
public class ConsumerController {

	@Value("${server.port}")
	private String serverPort;

	private String refCache = "I'm first cache.";

	@Autowired
	RestTemplate restTemplate;
	//@HystrixCommand(fallbackMethod = "error")
	@RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
	public String helloController() {
		String serviceStr = restTemplate.getForEntity("http://HELLO-SERVICE/hello", String.class).getBody();

		return "Ribbon consumer at port:"+ serverPort + " gets info from hello-service: " + serviceStr;
	}


	@RequestMapping(value = "/ribbon-consumer-book",method = RequestMethod.GET)
	//@HystrixCommand(fallbackMethod = "errorBook")
	public Book bookController() {

		ResponseEntity<Book> bookEntity = restTemplate.getForEntity("http://HELLO-SERVICE/getbook", Book.class);
		return bookEntity.getBody();
	}

	public String error() {
		return "error by hystrix";
	}


	public Book errorBook() {
		Book errBook = new Book();
		errBook.setTitle("Err book by hystrix");
		return errBook;
	}


	@RequestMapping(value = "/getCache/{id}", method = RequestMethod.GET)
	//@CacheResult
	public String getCache(@PathVariable("id") String id){

		//HystrixRequestContext.initializeContext();
		refCache = refCache + id;
		return refCache;
	}



}