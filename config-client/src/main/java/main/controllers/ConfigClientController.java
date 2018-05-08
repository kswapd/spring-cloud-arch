package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.environment.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kongxiangwen on 5/8/18 w:19.
 */

@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${sang}")
	String sang;
	//@Autowired
	//Environment env;

	@RequestMapping("/sang")
	public String sang() {
		return this.sang;
	}
	@RequestMapping("/sang2")
	public String sang2() {

		return "sang2";//env.getProperty("sang", "未定义");
	}
}
