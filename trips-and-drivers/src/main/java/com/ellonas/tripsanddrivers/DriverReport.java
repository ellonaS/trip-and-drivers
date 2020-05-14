package com.ellonas.tripsanddrivers;

public class DriverReport {

	private String name;
	private long totalMiles;
	private long averageSpeed;
	private long totalDrivingTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getTotalMiles() {
		return totalMiles;
	}

	public void setTotalMiles(long totalMiles) {
		this.totalMiles = totalMiles;
	}

	public long getAverageSpeed() {
		return this.averageSpeed;
	}

	public long getTotalDrivingTime() {
		return totalDrivingTime;
	}

	public void setTotalDrivingTime(long totalDrivingTime) {
		this.totalDrivingTime = totalDrivingTime;
	}

	public void setAverageSpeed(long averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

}
