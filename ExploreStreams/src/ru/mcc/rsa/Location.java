package ru.mcc.rsa;

public class Location {
	private City city;
	private String region;

	public Location() {

	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
