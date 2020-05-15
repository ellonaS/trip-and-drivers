package com.ellonas.tripsanddrivers.service_layer;

import java.util.List;

import com.ellonas.tripsanddrivers.data_access_layer.DriverReport;
import com.ellonas.tripsanddrivers.data_access_layer.LogFilePrinter;
import com.ellonas.tripsanddrivers.data_access_layer.LogFileReader;
import com.ellonas.tripsanddrivers.data_access_layer.Trip;

public class TripsManager implements ITripsService {

	private LogFilePrinter logFilePrinter = new LogFilePrinter();
	private LogFileReader logFileReader = new LogFileReader();

	@Override
	public void addDriver(String name) {
		String log = "Driver, " + name; //adding comma for the use of contains method when removing from file
		logFilePrinter.printLog(log);

	}

	@Override
	public void removeDriver(String name) {
		logFilePrinter.removeLog(name);

	}

	@Override
	public Trip addTrip(Trip trip) {
		long tripId = logFileReader.retrieveLastTripIdUsed() + 1;
		trip.setId(tripId);
		logFilePrinter.printLog("Trip, " + trip.getId() + ", " + trip.getDriversName() + ", " + trip.getStartTime() + ", "
				+ trip.getEndTime() + ", " + trip.getMiles());
		return trip;

	}

	@Override
	public void removeTrip(long id) {
		logFilePrinter.removeLog(" " + String.valueOf(id) + ", ");
	}

	@Override
	public List<DriverReport> getReport() {
		List <DriverReport> reports = logFileReader.retrieveListOfDriverReports();
		return reports;
	}

	@Override
	public List<String> retrieveListOfDrivers() {

		return logFileReader.retrieveListOfDrivers();
	}

}
