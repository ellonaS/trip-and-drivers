package com.ellonas.tripsanddrivers;

public class DriverReport implements Comparable <DriverReport> {

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
		return averageSpeed;
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

	@Override
	public int compareTo(DriverReport o) {
		int compareMiles = (int) ((DriverReport) o).getTotalMiles();
		// For Descending order
		return (int) (compareMiles - this.totalMiles);
	}

}
