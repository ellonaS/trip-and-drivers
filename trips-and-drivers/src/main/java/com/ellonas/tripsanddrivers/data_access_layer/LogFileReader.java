package com.ellonas.tripsanddrivers.data_access_layer;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.ellonas.tripsanddrivers.Calendar;

public class LogFileReader {

	private LogFilePrinter logPrinter = new LogFilePrinter();
	private File logFile = logPrinter.getLogFile();

	public List<String> retrieveListOfDrivers() {

		return getListOfStringsAtCertainIndex("Driver, ", 1);
	}

	public long retrieveLastTripIdUsed() {
		List<String> tripIdsInStringFormat = getListOfStringsAtCertainIndex("Trip, ", 1);
		if (tripIdsInStringFormat.size() > 0) {
			String lastTripId = tripIdsInStringFormat.get(tripIdsInStringFormat.size() - 1);
			return Long.parseLong(lastTripId);
		}
		return 0;

	}

	private List<String> getListOfStringsAtCertainIndex(String keyword, int index) {
		List<String> strings = new ArrayList<>();
		try {
			Scanner scanner = new Scanner(logFile);
			while (scanner.hasNext()) {
				String currentLine = scanner.nextLine();
				if (currentLine.contains(keyword)) {
					String[] line = currentLine.split(", ");
					// out of bounds handling
					if (line.length >= index) {
						strings.add(line[index]); // adding item at index 1,
						// because it should contain either name of the Driver
						// or trip id
					}

				}
			}
			scanner.close();

		} catch (FileNotFoundException e) {
			// TODO
		}
		return strings;
	}

	public List<DriverReport> retrieveListOfDriverReports() {

		List<DriverReport> reports = new ArrayList<>();
		List<String> drivers = retrieveListOfDrivers();

		for (String name : drivers) {

			DriverReport report = buildReport(name);
			if (report != null) {
				reports.add(report);
			}

		}
		// Sort the output by miles driven, most to least
		Collections.sort(reports);

		return reports;
	}

	private long calculateTotalHours(List<String> start, List<String> end) {
		long hours = 0;
		Calendar calendar = new Calendar();
		for (int i = 0; i < start.size(); i++) {
			try {
				LocalDateTime startTime = calendar.stringToLocalDateTime(start.get(i));
				LocalDateTime endTime = calendar.stringToLocalDateTime(end.get(i));
				hours += calendar.calculateHoursBetweenDates(startTime, endTime);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return hours;
	}

	private long calculateTotalMiles(List<String> miles) {
		long totalMiles = 0;
		for (String mile : miles) {
			totalMiles += Long.parseLong(mile);
		}
		return totalMiles;
	}

	private DriverReport buildReport(String name) {

		DriverReport report = new DriverReport();

		report.setName(name);
		report.setTotalMiles(calculateTotalMiles(getListOfStringsAtCertainIndex(name, 5)));

		List<String> start = getListOfStringsAtCertainIndex(name, 3);
		List<String> end = getListOfStringsAtCertainIndex(name, 4);

		report.setTotalDrivingTime(calculateTotalHours(start, end));

		try {

			long speed = report.getTotalMiles() / report.getTotalDrivingTime();
			report.setAverageSpeed(speed);

			if (speed > 5 && speed < 100) {
				return report;

			}
		} catch (Exception e) {
			// ignore
		}

		return null;
	}
}
