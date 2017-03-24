package ru.mcc.rsa;

import java.util.Optional;

public class EventO {
	private Optional<LocationO> loc;
	private String description;

	public EventO() {
		loc = Optional.empty();
	}

	public Optional<LocationO> getLoc() {
		return loc;
	}

	public void setLoc(Optional<LocationO> loc) {
		this.loc = loc;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
