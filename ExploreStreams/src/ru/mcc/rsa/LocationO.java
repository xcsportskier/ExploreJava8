package ru.mcc.rsa;

import java.util.Optional;

public class LocationO {
	private Optional<City> city;
	private String region;
	
	public LocationO() {
		city = Optional.empty(); 
	}

	public Optional<City> getCity() {
		return city;
	}

	public void setCity(Optional<City> city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
