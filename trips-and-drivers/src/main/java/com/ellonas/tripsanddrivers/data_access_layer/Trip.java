package com.ellonas.tripsanddrivers.data_access_layer;

import java.time.LocalDateTime;

public class Trip {
	
	private long id;
	private String driversName;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private long miles;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDriversName() {
		return driversName;
	}
	public void setDriversName(String driversName) {
		this.driversName = driversName;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public long getMiles() {
		return miles;
	}
	public void setMiles(long miles) {
		this.miles = miles;
	}
	

}
