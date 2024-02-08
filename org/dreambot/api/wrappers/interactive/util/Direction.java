package org.dreambot.api.wrappers.interactive.util;

import net.eternalclient.api.wrappers.interactives.Orientation;

import java.util.Arrays;

public enum Direction {
	EAST("East", 6, Orientation.EAST, Orientation.SOUTH_EAST),
	NORTH("North", 4, Orientation.NORTH, Orientation.NORTH_EAST),
	SOUTH("South", 0, Orientation.SOUTH, Orientation.SOUTH_WEST),
	WEST("West", 2, Orientation.WEST, Orientation.NORTH_WEST),
	NULL("Null", -1, Orientation.NONE);
	
	private final String name;
	private final int id;
	private final Orientation[] orientations;
	
	Direction(String name, int id, Orientation... orientations) {
		this.name = name;
		this.id = id;
		this.orientations = orientations;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static Direction valueOf(Orientation orientation) {
		for(Direction dir : values()) {
			if(Arrays.asList(dir.orientations).contains(orientation)) return dir;
		}
		return null;
	}
}
