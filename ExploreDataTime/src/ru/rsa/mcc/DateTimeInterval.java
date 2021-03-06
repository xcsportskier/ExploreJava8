package ru.rsa.mcc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * A helper class to calculate a difference between two dates.
 *
 * @author Myzika Alex xcsportskier@gmail.com
 * @version 1.0
 *
 */
public class DateTimeInterval {

	private long years;
	private long months;
	private long days;
	private long hours;
	private long minutes;
	private long seconds;
	private long millis;

	private DateTimeInterval(LocalDateTime from, LocalDateTime to) {

		LocalDateTime fromTemp = LocalDateTime.from(from);
		years = fromTemp.until(to, ChronoUnit.YEARS);
		fromTemp = fromTemp.plusYears(years);

		months = fromTemp.until(to, ChronoUnit.MONTHS);
		fromTemp = fromTemp.plusMonths(months);

		days = fromTemp.until(to, ChronoUnit.DAYS);
		fromTemp = fromTemp.plusDays(days);

		hours = fromTemp.until(to, ChronoUnit.HOURS);
		fromTemp = fromTemp.plusHours(hours);

		minutes = fromTemp.until(to, ChronoUnit.MINUTES);
		fromTemp = fromTemp.plusMinutes(minutes);

		seconds = fromTemp.until(to, ChronoUnit.SECONDS);
		fromTemp = fromTemp.plusSeconds(seconds);

		millis = fromTemp.until(to, ChronoUnit.MILLIS);
	}

	/**
	 * The method calculate a difference between from and to dates
	 * and expresses it in years, months, days, hours, 
	 * minutes, seconds and milliseconds
	 * 
	 * @param from	a start date
	 * @param to	a finish date
	 * @return		an object of DataTimeInterval.
	 * 				Use getters to retrieve certain portion of interval 
	 * 				like years or hours.
	 * @see			java.time.LocalDateTime
	 */
	public static DateTimeInterval between(LocalDateTime from, LocalDateTime to) {
		return new DateTimeInterval(from, to);
	}

	public String toString() {
		return  String.format("The difference is %d years, %d months, %d days, %d hours, %d minutes, %d seconds, %d millis", 
				years,
				months,
				days,
				hours,
				minutes,
				seconds,
				millis);
	}

	public long getYears() {
		return years;
	}

	public long getMonths() {
		return months;
	}

	public long getDays() {
		return days;
	}

	public long getHours() {
		return hours;
	}

	public long getMinutes() {
		return minutes;
	}

	public long getSeconds() {
		return seconds;
	}

	public long getMillis() {
		return millis;
	}

}
