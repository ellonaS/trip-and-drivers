package com.ellonas.tripsanddrivers.service_layer;

import java.util.List;

import com.ellonas.tripsanddrivers.DriverReport;
import com.ellonas.tripsanddrivers.Trip;

public interface ITripsService {
	
	List <String> retrieveListOfDrivers();

	void addDriver(String name);

	void removeDriver(String name);

	long addTrip(Trip trip);

	void removeTrip(long id);

	List<DriverReport> printReport();
}
