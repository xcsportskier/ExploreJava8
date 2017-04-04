package ru.mcc.rsa;

import java.util.Optional;

public class Optional3 {
	public static void main(String[] args) {
		/*
		 * A typical pattern is to return a default value if you determine that the result of an operation is null.
		 */
		EventO eventO = new EventO();
		LocationO locO = new LocationO();
		City city = new City();
		
		city.setName("New York");
		
		locO.setCity(Optional.of(city));
		locO.setRegion("Great New York Area");
		eventO.setLoc(Optional.of(locO));
		
		// assign existing value or create new once
		LocationO loc = eventO.getLoc().orElse(new LocationO());
		
		System.out.println(loc.getRegion());
	}
}
