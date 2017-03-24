package ru.mcc.rsa;

import java.util.Optional;

public class Optional1 {

	public static void main(String[] args) {
		/*
		 * Java 8 introduces a new class called Optional. Inspired by functional
		 * programming languages, it was introduced to allow better modeling in
		 * your codebase when a value may be present or absent. Think of it as a
		 * single-value container in that it either contains a value or is empty
		 * Optional can protect you against NullPointerException. In fact
		 * Optional defines methods to force you to explicitly check the absence
		 * or presence of a value
		 */
		Event event = new Event();

		// the NullPointerException will be thrown in this block
		try {
			String cityName = event.getLoc().getCity().getName();

			System.out.println(cityName);
		} catch (NullPointerException ex) {
			System.out.println("It seems like something is null!");
		}

		/*
		 *  If we want get rid of the NullPointerException,
		 *  we should perform some checks
		 *  However, you can see that the code in the listing quickly becomes very ugly due to the nested checks.
		 */
		String cityName = null;
		if (event != null) {
			Location loc = event.getLoc();
			if (loc != null) {
				City city = loc.getCity();
				if (city != null) {
					cityName = city.getName();
				}
			}
			if (cityName == null)
				cityName = "DefaultCity";
			System.out.println(cityName);
		}
		
		/*
		 * But with optional code is quite accurate and compact
		 * 
		 * ofNullable - Returns an Optional describing the specified value, if non-null, otherwise returns an empty Optional
		 * flatMap - If a value is present, apply the provided Optional-bearing mapping function to it, return that result, 
		 * 			 otherwise return an empty Optional. 
		 * map - If a value is present, apply the provided mapping function to it, and if the result is non-null,
		 *       return an Optional describing the result. Otherwise return an empty Optional.
		 * orElse - Return the value if present, otherwise return other. Other - the value to be returned if there is no value present.
		 */
		EventO eventO = null;
		String cityNameO = Optional.ofNullable(eventO)
				.flatMap(EventO::getLoc)
				.flatMap(LocationO::getCity)
				.map(City::getName)
				.orElse("DefaultCity");
			System.out.println(cityNameO);
				
	}

}
