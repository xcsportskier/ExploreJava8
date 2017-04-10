package ru.rsa.mcc;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

class DateTimeInterval {
	long years;
	long months;
	long days;
	long hours;
	long minutes;
	long seconds;

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

	static DateTimeInterval between(LocalDateTime from, LocalDateTime to) {
		return new DateTimeInterval(from, to);
	}

	public String toString() {
		return "The difference is " + years + " years, " + months + " months, " + days + " days, " + hours + " hours, "
				+ minutes + " minutes, " + seconds + " seconds, " + millis + " millis";
	}

	public long getYears() {
		return years;
	}

	public void setYears(long years) {
		this.years = years;
	}

	public long getMonths() {
		return months;
	}

	public void setMonths(long months) {
		this.months = months;
	}

	public long getDays() {
		return days;
	}

	public void setDays(long days) {
		this.days = days;
	}

	public long getHours() {
		return hours;
	}

	public void setHours(long hours) {
		this.hours = hours;
	}

	public long getMinutes() {
		return minutes;
	}

	public void setMinutes(long minutes) {
		this.minutes = minutes;
	}

	public long getSeconds() {
		return seconds;
	}

	public void setSeconds(long seconds) {
		this.seconds = seconds;
	}

	public long getMillis() {
		return millis;
	}

	public void setMillis(long millis) {
		this.millis = millis;
	}

	long millis;
}
