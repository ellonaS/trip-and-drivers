package com.ellonas.tripsanddrivers.ui_layer;

import java.math.MathContext;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.ellonas.tripsanddrivers.DriverReport;
import com.ellonas.tripsanddrivers.Trip;

public class Menu {

	// Create Scanner object to capture user input and return choice
	private Scanner inputScanner = new Scanner(System.in);

	public String printMainMenu() {

		System.out.println("1. Add driver");
		System.out.println("2. Remove driver");
		System.out.println("3. Add trip");
		System.out.println("4. Remove trip");
		System.out.println("5. Print report");
		System.out.println("6. Quit");

		return inputScanner.nextLine();

	}

	public void invalidEntry() {
		System.out.println("Invalid input. Please try Again.");
	}

	public String printAddDriverMenu() {
		System.out.println("Enter new driver's name");
		return inputScanner.nextLine();
	}

	public String printRemoveDriverMenu(List<String> drivers) {
		System.out.println("Drivers in the System: ");
		for (String name : drivers) {
			System.out.println(name);
		}
		System.out.println("Who do you want to remove?");
		return inputScanner.nextLine();
	}

	public Trip printAddTripMenu() {

		Trip trip = new Trip();

		System.out.println("Please, enter driver's name: ");
		trip.setDriversName(inputScanner.nextLine());

		try {
			trip.setStartTime(promptUserToEnterDateAndTime("start"));
			trip.setEndTime(promptUserToEnterDateAndTime("end"));
			System.out.println("Please, enter miles driven:");
			trip.setMiles(Long.parseLong(inputScanner.nextLine()));
		} catch (Exception e) {
			invalidEntry();
			return null;
		}
		return trip;
	}

	private LocalDateTime promptUserToEnterDateAndTime(String startOrEnd) throws Exception {
		System.out.println("Please, enter " + startOrEnd + " date and time: (yyyy-mm-dd hh:mm)");
		String date = inputScanner.nextLine();
		Calendar calendar = new Calendar();
		return calendar.stringToLocalDateTime(date);

	}

	public String printRemoveTripMenu(List<String> drivers) {
		System.out.println("Drivers in the System: ");
		for (String name : drivers) {
			System.out.println(name);
		}
		System.out.println("Who do you want to remove?");
		return inputScanner.nextLine();
	}

	public String printRemoveTripMenu() {
		System.out.println("Enter trip id to be removed:");
		return inputScanner.nextLine();

	}

	public void printReport(List<DriverReport> reports) {
		for (DriverReport report : reports) {
			System.out.println(report.getName() + " drove " + report.getTotalMiles() + " miles at an average speed of "
					+ report.getAverageSpeed());
		}
	}
}
