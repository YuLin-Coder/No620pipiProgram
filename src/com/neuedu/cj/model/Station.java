package com.neuedu.cj.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.cj.model.Manager;
import com.neuedu.cj.model.Station;
import com.neuedu.cj.model.User;
import com.neuedu.cj.util.DbConnection;

public class Station {
	private Integer sId;
	private String stationCode;
	private String stationName;
	private String pinyinCode;
	private String railwayBureau;
	private String stationGrade;
	private String administrativeRegion;
	private String contactAddress;
	
	
	
	public Station() {
		super();
		// TODO 自动生成的构造函数存根
	}



	public Integer getsId() {
		return sId;
	}



	public void setsId(Integer sId) {
		this.sId = sId;
	}



	public String getStationCode() {
		return stationCode;
	}



	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}



	public String getStationName() {
		return stationName;
	}



	public void setStationName(String stationName) {
		this.stationName = stationName;
	}



	public String getPinyinCode() {
		return pinyinCode;
	}



	public void setPinyinCode(String pinyinCode) {
		this.pinyinCode = pinyinCode;
	}



	public String getRailwayBureau() {
		return railwayBureau;
	}



	public void setRailwayBureau(String railwayBureau) {
		this.railwayBureau = railwayBureau;
	}



	public String getStationGrade() {
		return stationGrade;
	}



	public void setStationGrade(String stationGrade) {
		this.stationGrade = stationGrade;
	}



	public String getAdministrativeRegion() {
		return administrativeRegion;
	}



	public void setAdministrativeRegion(String administrativeRegion) {
		this.administrativeRegion = administrativeRegion;
	}



	public String getContactAddress() {
		return contactAddress;
	}



	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

}
