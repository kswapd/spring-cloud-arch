package com.dcits.beans;

/**
 * Created by kongxiangwen on 11/20/18 w:47.
 */
public class DaoDemo {
	long id;
	int num;
	String info;
	float size;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "DaoDemo{" +
				"id=" + id +
				", num=" + num +
				", info='" + info + '\'' +
				", size=" + size +
				'}';
	}
}
