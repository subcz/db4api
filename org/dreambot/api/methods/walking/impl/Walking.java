package org.dreambot.api.methods.walking.impl;

import net.eternalclient.api.interfaces.Locatable;
import net.eternalclient.api.wrappers.walking.WalkState;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.Entity;

public class Walking {
	public static Tile getDestination() {
		Locatable dest = net.eternalclient.api.wrappers.walking.Walking.getDestination();
		return dest != null ? new Tile(dest.getX(), dest.getY(), dest.getPlane()) : null;
	}
	
	public int getDestinationDistance() {
		return (int)Math.round(net.eternalclient.api.wrappers.walking.Walking.getDestinationDistance());
	}
	
	public int getRunEnergy() {
		return net.eternalclient.api.wrappers.walking.Walking.getRunEnergy();
	}
	
	public boolean isStaminaActive() {
		return net.eternalclient.api.wrappers.walking.Walking.isStaminaActive();
	}
	
	public static boolean shouldWalk() {
		return shouldWalk(4);
	}
	
	public static boolean shouldWalk(int distance) {
		return net.eternalclient.api.wrappers.walking.Walking.shouldWalk(distance);
	}
	
	public static boolean toggleRun() {
		return net.eternalclient.api.wrappers.walking.Walking.toggleRun();
	}
	
	public static boolean walk(int x, int y) {
		return walk(new Tile(x, y));
	}
	
	public static boolean walk(int x, int y, int z) {
		return walk(new Tile(x, y, z));
	}
	
	public static boolean walk(Entity entity) {
		return walk(entity.getTile());
	}
	
	public static boolean walk(Locatable locatable) {
		return walk(locatable.getTile());
	}
	
	public static boolean walk(Tile tile) {
		return net.eternalclient.api.wrappers.walking.Walking.walk(tile.toEC()) == WalkState.SUCCESS;
	}
	
	public static boolean walkExact(Tile tile) {
		return net.eternalclient.api.wrappers.walking.Walking.walkExact(tile.toEC()) == WalkState.SUCCESS;
	}
}
