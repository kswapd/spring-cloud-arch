package main.controllers;



import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */

@RestController
//@RequestMapping(value = "/aa")
public class HelloController {
	//private final Logger logger = Logger.getLogger(HelloController.class);
	@Autowired
	private DiscoveryClient client;

	@Value("${server.port}")
	private String serverPort;

	private static Logger log = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	@Cacheable
	public String index() {

		try (Entry entry = SphU.entry("HelloWorld")) {
			// Your business logic here.
			log.info("sentinel hello.");
			log.info("being called");
			return "Hello World from port:"+serverPort;
		} catch (BlockException e) {
			// Handle rejected request.
			e.printStackTrace();
			return "failed";
		}
	}

}
