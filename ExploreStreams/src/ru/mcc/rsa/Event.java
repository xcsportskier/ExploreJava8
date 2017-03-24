package ru.mcc.rsa;

public class Event {
	private Location loc;
	private String description;
	
	public Event() {

	}

	public Event(String description, Location loc) {
		this.setDescription(description);
		this.setLoc(loc);
	}

	public Location getLoc() {
		return loc;
	}

	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
