package ru.mcc.rsa;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Optional5 {
	public static void main(String[] args) {
		/*
		 * Another common pattern is to extract information from an object. For
		 * example, from a Event object, you might want to extract the Location
		 * object.
		 */
		EventO eventO = new EventO();
		LocationO locO = new LocationO();
		City city = new City();

		city.setName("New York");

		locO.setCity(Optional.of(city));
		locO.setRegion("Great New York Area");
		// locO = null; // NoSuchElementException at line 30 will be thrown
		eventO.setLoc(Optional.ofNullable(locO));

		/*
		 * Map function demonstration.
		 * If a value is present, apply the provided mapping function to it, and if the result is non-null,
		 * return an Optional describing the result. Otherwise return an empty Optional
		 */
		String regionName = eventO.getLoc().map(LocationO::getRegion).get();

		System.out.println(regionName);

		/*
		 * If you want to get a city
		 */
		String cityName = eventO.getLoc().get().getCity().map(City::getName).get();
		System.out.println(cityName);

		/*
		 * But anyway, all code above is wrong
		 * because if location or city is empty then NoSuchElementException will be thrown.
		 */
		//locO.setCity(Optional.ofNullable(null));
		eventO.setLoc(Optional.ofNullable(null));
		try {
			cityName = eventO.getLoc().get().getCity().map(City::getName).get();
			System.out.println(cityName);
		} catch (NoSuchElementException ex) {
			System.out.println("It seems like something is empty!");
		}
		
		/*
		 * What if we will correct a problem something like this?
		 * 
		 * cityName = Optional.ofNullable(eventO).map(EventO::getLoc).map(LocationO::getCity).map(City::getName).get();
		 * 
		 * Shit! This piece of code would not be compiled! Why?
		 * 
		 * The type of Optional.ofNullable(eventO) is Optional<EventO>, so it is perfectly correct to call the map method.
		 * However getLoc returns the object of type Optional<LocationO>. This means the result of the map operation
		 * is an object of type <Optional<Optional<LovationO>>. As a result the call of getCity is invalid because the outermost
		 * Optional contains as its value another Optional, which of course, doesn't support getCity method.
		 * So we have two Optional nested structure.
		 * What is the solution? 
		 * The Optional class supports a flatMap method. Its purpose is to apply the transformational function of value of an Optional
		 * (just like the map operation does) and then flatten the result two-level Optional into single one.
		 * Note: an explanation picture should be added into PowerPoint presentation.
		 * See also Optional6 class.
		 */
	}
}
