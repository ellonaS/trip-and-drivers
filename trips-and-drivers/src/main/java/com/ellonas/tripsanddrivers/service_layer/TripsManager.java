package com.ellonas.tripsanddrivers.service_layer;

import java.util.List;

import com.ellonas.tripsanddrivers.DriverReport;
import com.ellonas.tripsanddrivers.LogFilePrinter;
import com.ellonas.tripsanddrivers.LogFileReader;
import com.ellonas.tripsanddrivers.Trip;

public class TripsManager implements ITripsService {
	
	private LogFilePrinter logFilePrinter = new LogFilePrinter();
	private LogFileReader logFileReader = new LogFileReader();

	@Override
	public void addDriver(String name) {
		String log = "Driver, " + name;
		logFilePrinter.printLog(log);
		
	}

	@Override
	public void removeDriver(String name) {
		logFilePrinter.removeLog(name);
		
	}

	@Override
	public long addTrip(Trip trip) {
		// TODO Auto-generated method stub
		return 0;
		
	}

	@Override
	public void removeTrip(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DriverReport> printReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> retrieveListOfDrivers() {
		
		return logFileReader.retrieveListOfDrivers();
	}

}
