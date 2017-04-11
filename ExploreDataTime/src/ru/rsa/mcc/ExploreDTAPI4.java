package ru.rsa.mcc;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class ExploreDTAPI4 {
	public static void main(String[] args) {
		/*
		 * The ChronoUnit defines the units used to measure time. 
		 * The ChronoUnit.between method is useful when you want to measure an amount of time in 
		 * a single unit of time only, such as days or seconds.
		 * Let's calculate how much you have been living since the last doomsday in years, days and hours.
		 */
		
		LocalDateTime lastDoomsDay = LocalDateTime.of(2012, Month.DECEMBER, 21, 0, 0, 0);
		LocalDateTime nowDate = LocalDateTime.now();
		
		long yearsSinceLastDoomsDate = ChronoUnit.YEARS.between(lastDoomsDay, nowDate);
		long daysSinceLastDoomsDate = ChronoUnit.DAYS.between(lastDoomsDay, nowDate);
		long hoursSinceLastDoomsDate = ChronoUnit.HOURS.between(lastDoomsDay, nowDate);

		
		System.out.printf("Congratulations! You survived DOOMSDAY 2012 for %d years, or, the same, %d days, or, the same, %d hours.",
				yearsSinceLastDoomsDate,
				daysSinceLastDoomsDate,
				hoursSinceLastDoomsDate
				);
	}
}
