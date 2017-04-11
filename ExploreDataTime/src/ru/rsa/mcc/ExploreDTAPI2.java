package ru.rsa.mcc;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ExploreDTAPI2 {
	
	public static void main(String[] args) {
		/*
		 * For example my flight (British Airways 117, LHR-JFK) departures from London on the 10.02.2017 in 8:30 local time
		 * and arrives in New York on the same date in 11:10 local time.
		 * I would like to know how many time does my journey take to get there?
		 */
		ZoneId london = ZoneId.of("Europe/London");
		ZoneId new_york = ZoneId.of("America/New_York");
		
		LocalDate feb10 = LocalDate.of(2017, Month.FEBRUARY, 10);
		LocalTime morning = LocalTime.parse("08:30");
		
		ZonedDateTime flightDeparture = ZonedDateTime.of(feb10, morning, london);
		System.out.println(flightDeparture); // 2017-02-10T08:30Z[Europe/London]

		ZonedDateTime flightArrive = ZonedDateTime.of(feb10, LocalTime.of(11, 10), new_york);
		
		Duration flightLength = Duration.between(flightDeparture, flightArrive);
		System.out.println(flightLength);
		
		System.out.println("It will take " + 
							LocalTime.MIDNIGHT.plus(flightLength).format(DateTimeFormatter.ofPattern("HH:mm")) 
							+ " to get there!"); // It will take 07:40 to get there!
	}
}
