package com.dcits.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by kongxiangwen on 11/21/18 w:47.
 */

public class Hint {
	private static final Logger logger = LoggerFactory.getLogger(Hint.class);
	private String sdb = null;
	private String ts = null;
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("/@");
		if (sdb != null && sdb.length()>0) {
			sb.append("sdb=").append(this.sdb).append(";");
		}
		if (ts != null && ts.length()>0) {
			sb.append("ts=").append(this.ts).append(";");
		}
		sb.append("@/");
		return sb.toString();
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getSdb() {
		return sdb;
	}

	public void setSdb(String sdb) {
		this.sdb = sdb;
	}
}
