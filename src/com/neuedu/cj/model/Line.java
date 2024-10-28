package com.neuedu.cj.model;

import java.util.Date;

public class Line {
	private Integer lineNumber;
	private String trafficCode;
	private String stationName;
	private Date departureTime;
	private Date arrivalTime;
	private String mileage;
	private String residenceTime;
	private String spendTime;
	private String stationCode;
	
	
	public Line() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Integer getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getTrafficCode() {
		return trafficCode;
	}
	public void setTrafficCode(String trafficCode) {
		this.trafficCode = trafficCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getResidenceTime() {
		return residenceTime;
	}
	public void setResidenceTime(String residenceTime) {
		this.residenceTime = residenceTime;
	}
	public String getSpendTime() {
		return spendTime;
	}
	public void setSpendTime(String spendTime) {
		this.spendTime = spendTime;
	}
	public String getStationCode() {
		return stationCode;
	}
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	
	

}
