package com.ellonas.tripsanddrivers.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import com.ellonas.tripsanddrivers.data_access_layer.LogFilePrinter;
import com.ellonas.tripsanddrivers.data_access_layer.Trip;
import com.ellonas.tripsanddrivers.service_layer.ITripsService;
import com.ellonas.tripsanddrivers.service_layer.TripsManager;

public class TripsManagerTest {

	private LogFilePrinter logPrinter = new LogFilePrinter();
	private File logFile = logPrinter.getLogFile();
	private ITripsService tripsManager = new TripsManager();
	private String driverName;
	private Trip testTrip;
	private Trip tripAdded;
	private long id;
	

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
		tripsManager.addDriver(driverName);
		String line = "";
		try {
			Scanner scanner = new Scanner(logFile);
			
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.contains(driverName)) {
					line = currentLine;
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(line.contains(driverName));
	}

	@Test
	public void removeLogTest() {
		tripsManager.removeDriver(driverName);
		String line = "";
		try {
			Scanner scanner = new Scanner(logFile);
			
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.contains(driverName)) {
					line = currentLine;
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(line.isEmpty());
	}
		
	

	@Test
	public void retrieveListOfDriversTest() {
		tripsManager.addDriver(driverName);
		List<String> drivers = tripsManager.retrieveListOfDrivers();
		String actual = drivers.get(drivers.size() - 1); // getting the last item in the list
		assertEquals(driverName, actual);
	}

	@Test
	public void addTripTest() {
		tripAdded = tripsManager.addTrip(testTrip);
		
		String line = "";
		try {
			Scanner scanner = new Scanner(logFile);
			
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.contains(driverName) && currentLine.contains("Trip")) {
					line = currentLine;
				}
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(tripAdded.getId());
		assertTrue(line.contains(driverName));
	}

}
