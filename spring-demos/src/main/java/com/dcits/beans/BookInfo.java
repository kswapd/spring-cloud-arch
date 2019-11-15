package com.dcits.beans;

import java.io.Serializable;

/**
 * Created by kongxiangwen on 11/7/18 w:45.
 */
public class BookInfo  implements Serializable{
	private String title;
	private float price;
	private String id;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BookInfo(String title, float price, String id) {
		this.title = title;
		this.price = price;
		this.id = id;
	}
}
