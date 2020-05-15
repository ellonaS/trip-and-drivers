package com.ellonas.tripsanddrivers.service_layer;

import java.util.List;

import com.ellonas.tripsanddrivers.data_access_layer.DriverReport;
import com.ellonas.tripsanddrivers.data_access_layer.Trip;

public interface ITripsService {
	
	List <String> retrieveListOfDrivers();

	void addDriver(String name);

	void removeDriver(String name);

	Trip addTrip(Trip trip);

	void removeTrip(long id);

	List<DriverReport> getReport();
}
