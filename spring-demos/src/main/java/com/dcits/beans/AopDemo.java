package com.dcits.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by kongxiangwen on 11/6/18 w:45.
 */

public class AopDemo {

	private final static Logger LOGGER = LoggerFactory.getLogger(AopDemo.class);

	private String name = "aop";
	private int age = 55;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
