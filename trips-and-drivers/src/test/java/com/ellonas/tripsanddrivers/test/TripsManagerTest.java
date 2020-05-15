package com.ellonas.tripsanddrivers.test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ellonas.tripsanddrivers.Trip;
import com.ellonas.tripsanddrivers.service_layer.ITripsService;
import com.ellonas.tripsanddrivers.service_layer.TripsManager;



public class TripsManagerTest {
	
	private ITripsService tripsManager = new TripsManager();
	private String driverName;
	private Trip testTrip;
	
	@Before
	public void setup() {
		driverName = "Test7";
		testTrip = new Trip();
		testTrip.setDriversName(driverName);
		testTrip.setStartTime(LocalDateTime.now());
		testTrip.setEndTime(LocalDateTime.now().plusHours(10));
		testTrip.setMiles(600);
	}
	@Test
	public void addDriverTest() {
		tripsManager.addDriver("Test");
		tripsManager.addDriver("Test1");
		
	}
	@Test
	public void removeLogTest() {
		tripsManager.removeDriver("Test1");
	}
	
	@Test
	public void retrieveListOfDriversTest() {
		tripsManager.addDriver(driverName);
		List <String> drivers = tripsManager.retrieveListOfDrivers();
		String actual = drivers.get(drivers.size() - 1); //getting the last item in the list
		assertEquals(driverName, actual);
 	}
	
	@Test
	public void addTripTest() {
		tripsManager.addTrip(testTrip);
	}
	

}
