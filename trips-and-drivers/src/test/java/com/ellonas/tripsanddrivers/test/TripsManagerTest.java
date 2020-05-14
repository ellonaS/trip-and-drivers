package com.ellonas.tripsanddrivers.test;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;


import com.ellonas.tripsanddrivers.service_layer.ITripsService;
import com.ellonas.tripsanddrivers.service_layer.TripsManager;



public class TripsManagerTest {
	
	private ITripsService tripsManager = new TripsManager();
	private String driverName;
	
	@Before
	public void setup() {
		driverName = "Test7";
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
	

}
