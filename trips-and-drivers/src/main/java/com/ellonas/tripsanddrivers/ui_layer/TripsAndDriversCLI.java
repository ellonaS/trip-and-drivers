package com.ellonas.tripsanddrivers.ui_layer;

public class TripsAndDriversCLI {

	private Menu menu; // create an instance of menu class to run console menu

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
			// add driver
			System.out.println("You picked 1");
		}

		else if (choice.equals("2")) {
			// remove driver
			System.out.println("You picked 2");

		} else if (choice.equals("3")) {
			// add trip
			System.out.println("You picked 3");

		} else if (choice.equals("4")) {
			// remove trip
			System.out.println("You picked 4");

		} else if (choice.equals("5")) {
			// print report
			System.out.println("You picked 5");

		} else if (choice.equals("6")) {
			// Quits the program
			System.out.println("Thank you!");
			System.exit(1);
		} else {
			menu.invalidEntry();
		}
	}

}
