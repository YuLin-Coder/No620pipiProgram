package com.neuedu.cj.model;
import java.util.Date;
public class Link {
	private  Integer lId;
	private  String LineNumber;
	private  String TrafficCode;
	private  String StationName;
	private  Date DepartureTime;
	private  Date ArrivalTime;
	private  String Mileage;
	private  Integer ResidenceTime;
	private  String SpendTime;
	private  Integer StationCode;
	public Link(Integer lId, String lineNumber, String trafficCode, String stationName, Date departureTime,
			Date arrivalTime, String mileage, Integer residenceTime, String spendTime, Integer stationCode) {
		super();
		this.lId = lId;
		LineNumber = lineNumber;
		TrafficCode = trafficCode;
		StationName = stationName;
		DepartureTime = departureTime;
		ArrivalTime = arrivalTime;
		Mileage = mileage;
		ResidenceTime = residenceTime;
		SpendTime = spendTime;
		StationCode = stationCode;
	}
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getlId() {
		return lId;
	}
	public void setlId(Integer lId) {
		this.lId = lId;
	}
	public String getLineNumber() {
		return LineNumber;
	}
	public void setLineNumber(String lineNumber) {
		LineNumber = lineNumber;
	}
	public String getTrafficCode() {
		return TrafficCode;
	}
	public void setTrafficCode(String trafficCode) {
		TrafficCode = trafficCode;
	}
	public String getStationName() {
		return StationName;
	}
	public void setStationName(String stationName) {
		StationName = stationName;
	}
	public Date getDepartureTime() {
		return DepartureTime;
	}
	public void setDepartureTime(Date departureTime) {
		DepartureTime = departureTime;
	}
	public Date getArrivalTime() {
		return ArrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		ArrivalTime = arrivalTime;
	}
	public String getMileage() {
		return Mileage;
	}
	public void setMileage(String mileage) {
		Mileage = mileage;
	}
	public Integer getResidenceTime() {
		return ResidenceTime;
	}
	public void setResidenceTime(Integer residenceTime) {
		ResidenceTime = residenceTime;
	}
	public String getSpendTime() {
		return SpendTime;
	}
	public void setSpendTime(String spendTime) {
		SpendTime = spendTime;
	}
	public Integer getStationCode() {
		return StationCode;
	}
	public void setStationCode(Integer stationCode) {
		StationCode = stationCode;
	}
	

}
