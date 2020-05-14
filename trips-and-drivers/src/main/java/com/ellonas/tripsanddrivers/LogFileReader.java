package com.ellonas.tripsanddrivers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogFileReader {
	
	private LogFilePrinter logPrinter = new LogFilePrinter();

	public List <String> retrieveListOfDrivers(){
		File logFile = logPrinter.getLogFile();
		List <String> drivers = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(logFile);
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if(currentLine.contains("Driver, ")) {
					String [] line = currentLine.split(", ");
					drivers.add(line[1]); //adding item at index 1, because it should contain name of the Driver
				}
			}
			
		}
		catch (FileNotFoundException e) {
			//TODO
		}
		return drivers;
	}
}
