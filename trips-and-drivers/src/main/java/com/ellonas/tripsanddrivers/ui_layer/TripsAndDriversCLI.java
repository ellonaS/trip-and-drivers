package com.ellonas.tripsanddrivers.ui_layer;

import java.util.List;

import com.ellonas.tripsanddrivers.Trip;
import com.ellonas.tripsanddrivers.service_layer.ITripsService;
import com.ellonas.tripsanddrivers.service_layer.TripsManager;

public class TripsAndDriversCLI {

	private Menu menu; // create an instance of menu class to run console menu
	private ITripsService tripsManager = new TripsManager();

	public TripsAndDriversCLI(Menu menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		TripsAndDriversCLI cli = new TripsAndDriversCLI(menu);
		cli.run();
	}

	public void run() {
		while (true) {
			// display the main menu

			String choice = menu.printMainMenu();
			evaluateChoice(choice);

		}
	}

	private void evaluateChoice(String choice) {
		if (choice.equals("1")) {
			tripsManager.addDriver(menu.printAddDriverMenu());
		}

		else if (choice.equals("2")) {
			displayRemoveDriverMenu();

		} else if (choice.equals("3")) {
			displayAddTripMenu();

		} else if (choice.equals("4")) {
			displayRemoveTripMenu();

		} else if (choice.equals("5")) {
			menu.printReport(tripsManager.getReport());

		} else if (choice.equals("6")) {
			// Quits the program
			System.out.println("Thank you!");
			System.exit(1);
		} else {
			menu.invalidEntry();
		}
	}

	private void displayRemoveDriverMenu() {
		List<String> drivers = tripsManager.retrieveListOfDrivers();
		String choice = menu.printRemoveDriverMenu(drivers);
		tripsManager.removeDriver(choice);
	}

	private void displayAddTripMenu() {
		Trip trip = menu.printAddTripMenu();
		if (trip != null) {
			Trip addedTrip = tripsManager.addTrip(trip);
			System.out.println("Trip log created for trip id " + addedTrip.getId());
		}
	}
	private void displayRemoveTripMenu() {
		String choice = menu.printRemoveTripMenu();
		tripsManager.removeDriver(choice);
	}

}
