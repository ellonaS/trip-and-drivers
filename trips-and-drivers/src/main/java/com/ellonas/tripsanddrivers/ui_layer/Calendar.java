package com.ellonas.tripsanddrivers.ui_layer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Calendar {

	public LocalDateTime stringToLocalDateTime(String dateTime) {
		LocalDateTime localDateTime;
		DateTimeFormatter formatter;
		try {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
			localDateTime = LocalDateTime.parse(dateTime, formatter);
		} catch (Exception e) {
			formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
			localDateTime = LocalDateTime.parse(dateTime, formatter);
		}
		return localDateTime;
	}

	public long calculateHoursBetweenDates(LocalDateTime startTime, LocalDateTime endTime) {
		long hours = ChronoUnit.HOURS.between(startTime, endTime);
		return hours;

	}

}
