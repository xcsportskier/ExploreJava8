package ru.mcc.rsa;

import java.util.Optional;

public class Optional6 {
	public static void main(String[] args) {
		/*
		 * flatMap function demonstration
		 * flatMap - If a value is present, apply the provided Optional-bearing mapping function to it, return that result, 
		 * 			 otherwise return an empty Optional.
		 */
		EventO eventO = new EventO();
		LocationO locO = new LocationO();
		City city = new City();

		city.setName("New York");

		locO.setCity(Optional.of(city));
		locO.setRegion("Great New York Area");
		eventO.setLoc(Optional.ofNullable(locO));

		//locO.setCity(Optional.ofNullable(null));
		
		/*
		 * Refactoring from cityName = eventO.getLoc().get().getCity().map(City::getName).get();
		 * 
		 * The firstMap ensures that an Optional<LocationO> is returned instead of Optional<Optional<LocationO>> and
		 * second flatMap achieves the same purpose to return an Optional<City>.
		 * The third call just needs to be a map, because getName returns a string rather than an Optional object.
		 */
		
		Optional<EventO> event = Optional.ofNullable(eventO);
		String cityName = event
				            .flatMap(EventO::getLoc)
				            .flatMap(LocationO::getCity)
				            .map(City::getName).get();
		
	    System.out.println(cityName);
	    
	    // So here we can see a code we started about, see also Optional1 class.
	}
}
