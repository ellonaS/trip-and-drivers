package com.ellonas.tripsanddrivers.ui_layer;

import java.math.MathContext;
import java.util.Scanner;

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

}
