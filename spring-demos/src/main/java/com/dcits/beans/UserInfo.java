package com.dcits.beans;

import java.io.Serializable;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */
public class UserInfo implements Serializable{

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserInfo(String name, int age, Long id) {
		this.name = name;
		this.age = age;
		this.id = id;
	}

	private String name;
	private int age;
	private Long id;

}
