package com.neuedu.cj.model;

public class Manager {

	private String mid;
	private String mname;
	private String mpass;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public Manager(String mid, String mname, String mpass) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
	}
	
}
