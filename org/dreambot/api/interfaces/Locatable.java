package org.dreambot.api.interfaces;

import net.eternalclient.api.utilities.math.Calculations;
import net.eternalclient.api.wrappers.walking.Walking;
import org.dreambot.api.methods.map.Tile;

public interface Locatable {
	Tile getTile();
	
	default boolean canReach() {
		return getTile().toEC().canReach();
	}
	
	default boolean canReach(Tile pos) {
		return getTile().toEC().canReach(pos.toEC());
	}
	
	default double distance(Tile pos) {
		return getTile().toEC().distance(pos.toEC());
	}
	
	default int getGridX() {
		return getTile().toEC().getGridX();
	}
	
	default int getGridY() {
		return getTile().toEC().getGridY();
	}
	
	default int getX() {
		return getTile().toEC().getX();
	}
	
	default int getY() {
		return getTile().toEC().getY();
	}
	
	default int getZ() {
		return getTile().toEC().getPlane();
	}
	
//	default int walkingDistance(Tile tile) {
//		return getTile().toEC().walkingDistance(tile.toEC());
//	}
}
