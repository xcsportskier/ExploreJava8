package ru.mcc.rsa;

import java.util.Optional;

public class Optional2 {

	public static void main(String[] args) {
		/*
		 * Another example of Optional class
		 */
		EventO eventO = new EventO();
		LocationO locO = new LocationO();
		City city = new City();
		
		city.setName("New York");
		
		locO.setCity(Optional.of(city));
		locO.setRegion("Great New York Area");
		
		eventO.setLoc(Optional.of(locO));
		

		String cityNameO = Optional.ofNullable(eventO)
				.flatMap(EventO::getLoc)
				.flatMap(LocationO::getCity)
				.map(City::getName)
				.orElse("DefaultCity");
			System.out.println(cityNameO);
				
	}
}
