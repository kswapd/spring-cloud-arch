package dcits.controllers;

/**
 * Created by kongxiangwen on 5/21/18 w:21.
 */

import dcits.daos.TestDao;
import dcits.models.Animal;
import dcits.models.DaoDemo;
import dcits.models.People;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreetingController {
	private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);
	/*@Autowired
	People p;
	@Autowired
	Animal animal;*/

	@Autowired
	TestDao testDao;


	@GetMapping("/ping")
	@ResponseBody
	public String ping() {
		return "pong";
	}


	@GetMapping("/greeting")
	@ResponseBody
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		//People p = (People) ctx.getBean("cutesource");
		//System.out.println(p.getName());
		logger.info("ooooooo");
		logger.info("asdfs mobile=13212345678,baseAcctName=kxw123,baseAcctNo=610422342343323432,pwd=12345678");
		return "greeting " + name;
	}


	@GetMapping("/greeting2")
	public String greeting2(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		//System.out.println(p.getName());
		return "greeting2";
	}

	@RequestMapping("/sb")
	@ResponseBody
	String home() {
		return "Hello Spring boot!";// + "people:"+p.getName()+"animal:"+animal.getAnimalName();
	}


	@GetMapping("/testMybatis")
	@ResponseBody
	public String testMybatis() {

		/*ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"db.xml"});
		TestDao testDao = appContext.getBean(TestDao.class);*/
		DaoDemo dd = new DaoDemo();
		dd.setId(111);
		DaoDemo info = testDao.findById(111);
		logger.info("get dao:{},{}", testDao.getCount(dd),info.toString());

		List<DaoDemo> linfo = testDao.getLimit(3);
		linfo.forEach(o -> logger.info(o.toString()));
		return "testMybatis";
	}

}
