package com.neuedu.cj.model;

import java.util.Date;

public class User {
	private Integer uId;
	private String loginName;
	private String realName;
	private String sex;
	private String provice;
	private String city;
	private String cardType;
	private String cardNumber;
	private Date birthday;
	private String lvkeType;
	private String info;
	private String ulname;
	private String ulpass;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getuId() {
		return uId;
	}
	public User(Integer uId, String loginName, String realName, String sex, String provice, String city,
			String cardType, String cardNumber, Date birthday, String lvkeType, String info, String ulname,
			String ulpass) {
		super();
		this.uId = uId;
		this.loginName = loginName;
		this.realName = realName;
		this.sex = sex;
		this.provice = provice;
		this.city = city;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.birthday = birthday;
		this.lvkeType = lvkeType;
		this.info = info;
		this.ulname = ulname;
		this.ulpass = ulpass;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProvice() {
		return provice;
	}
	public void setProvice(String provice) {
		this.provice = provice;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLvkeType() {
		return lvkeType;
	}
	public void setLvkeType(String lvkeType) {
		this.lvkeType = lvkeType;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getUlname() {
		return ulname;
	}
	public void setUlname(String ulname) {
		this.ulname = ulname;
	}
	public String getUlpass() {
		return ulpass;
	}
	public void setUlpass(String ulpass) {
		this.ulpass = ulpass;
	}

}
