package ru.rsa.mcc;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class ExploreDTAPI3 {
	
	public static void main(String[] args) {
		/*
		 * A Duration measures an amount of time using time-based values (seconds, nanoseconds). 
		 * A Period uses date-based values (years, months, days).
		 * Duration practically stores the time in the nanoseconds.
		 * Duration is most suitable when we measure machine based timings where as Period
		 * is most suitable when we want to know the human readable time representation.
		 * Let's calculate how much you have been living since the last doomsday.
		 */
		
		LocalDate lastDoomsDay = LocalDate.of(2012, Month.DECEMBER, 21);
		
		LocalDate nowDate = LocalDate.now();
		
		
		Period timeSinceLastDoomsDate = Period.between(lastDoomsDay, nowDate);
		System.out.println(timeSinceLastDoomsDate);
		
		System.out.printf("Congratulations! You survived DOOMSDAY 2012 for %s years, %s months and %s days", 
				timeSinceLastDoomsDate.getYears(),
				timeSinceLastDoomsDate.getMonths(),
				timeSinceLastDoomsDate.getDays());
	}

}
