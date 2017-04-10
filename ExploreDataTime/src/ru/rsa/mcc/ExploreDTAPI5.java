package ru.rsa.mcc;

import java.time.LocalDateTime;
import java.time.Month;

public class ExploreDTAPI5 {

	public static void main(String[] args) {
		/*
		 * But what if we have to calculate a difference between, say, two
		 * LocalDateTime and get whole bunch of ChronoUnits from years to millis
		 * (a whole interval expressed in years, months, days, hours, 
		 * minutes, seconds and milliseconds)? 
	     *
	     * Fucking shame, but, unfortunately, there is no
		 * specific classes or methods to do it. At least, I was not managed to
		 * find it. Here is a kind of do it by yourself task in Java.
		 * I did it, see DateTimeInterval class.
		 * Let's calculate how much you have been living since the last
		 * doomsday in years, months, days hours, minutes and seconds.
		 */

		LocalDateTime lastDoomsDay = LocalDateTime.of(2012, Month.DECEMBER, 21, 0, 0, 0);
		LocalDateTime nowDate = LocalDateTime.now();
		
		DateTimeInterval dti = DateTimeInterval.between(lastDoomsDay, nowDate);
		System.out.println(dti);
	}
}
