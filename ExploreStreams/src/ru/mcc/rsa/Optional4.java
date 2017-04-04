package ru.mcc.rsa;

import java.util.Optional;

public class Optional4 {
	public static void main(String[] args) {
		/*
		 * Often you need to call a method on an object and check some property.
		 */
		EventO eventO = new EventO();
		LocationO locO = new LocationO();
		City city = new City();
		
		city.setName("New York");
		
		locO.setCity(Optional.of(city));
		locO.setRegion("Great New York Area");
		eventO.setLoc(Optional.of(locO));
		
		boolean isNewYorkArea = eventO.getLoc().filter(loc -> loc.getRegion().contains("New York")).isPresent();
		
		System.out.println(isNewYorkArea);
	}
}
