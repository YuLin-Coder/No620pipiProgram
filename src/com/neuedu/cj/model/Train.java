package com.neuedu.cj.model;

import java.util.Date;

public class Train {
	private Integer tId;
	private String traffic;
	private String departureStation;
	private String terminalStation;
	private Date startingTime;
	private Date endTime;
	private String duration;
	private String mileage;
	private String noSeat;
	private String vehicleType;
	private String trainType;
	
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getTraffic() {
		return traffic;
	}
	public void setTraffic(String traffic) {
		this.traffic = traffic;
	}
	public String getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}
	public String getTerminalStation() {
		return terminalStation;
	}
	public void setTerminalStation(String terminalStation) {
		this.terminalStation = terminalStation;
	}
	public Date getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getNoSeat() {
		return noSeat;
	}
	public void setNoSeat(String noSeat) {
		this.noSeat = noSeat;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getTrainType() {
		return trainType;
	}
	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}
	

	

}
