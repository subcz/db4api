package org.dreambot.api.wrappers.items;

import org.dreambot.api.interfaces.Identifiable;
import org.dreambot.api.interfaces.Locatable;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.Entity;

import java.awt.*;

public class GroundItem extends Entity implements Identifiable, Locatable {
	private final net.eternalclient.api.wrappers.interactives.GroundItem groundItem;
	
	public GroundItem(net.eternalclient.api.wrappers.interactives.GroundItem groundItem) {
		super(groundItem);
		
		this.groundItem = groundItem;
	}
	
	public net.eternalclient.api.wrappers.interactives.GroundItem toEC() {
		return groundItem;
	}
	
	public boolean equals(net.eternalclient.api.wrappers.interactives.GroundItem groundItem) {
		return this.groundItem.equals(groundItem);
	}
	
	public boolean equals(GroundItem groundItem) {
		return equals(groundItem.groundItem);
	}
	
	public String[] getActions() {
		return groundItem.getActions();
	}
	
	public int getAmount() {
		return groundItem.getAmount();
	}
	
	public Rectangle getBoundingBox() {
		return groundItem.getClickBox().getBounds();
	}
	
	public int getGridX() {
		return groundItem.getGridX();
	}
	
	public int getGridY() {
		return groundItem.getGridY();
	}
	
	public int getGridZ() {
		return groundItem.getPlane();
	}
	
	public int getHeight() {
		return groundItem.getHeight();
	}
	
	public int getID() {
		return groundItem.getID();
	}
	
	public Item getItem() {
		return new Item(groundItem.getItem());
	}
	
	public String getName() {
		return groundItem.getName();
	}
	
	public int getPlane() {
		return groundItem.getPlane();
	}
	
	public Tile getTile() {
		return new Tile(groundItem.getTile());
	}
	
	public int getX() {
		return groundItem.getX();
	}
	
	public int getY() {
		return groundItem.getY();
	}
	
	public int getZ() {
		return groundItem.getPlane();
	}
	
	public boolean hasAction(String... actions) {
		return groundItem.hasAction(actions);
	}
	
	public int hashCode() {
		return groundItem.hashCode();
	}
	
	@Override
	public String toString() {
		return groundItem.toString();
	}
}
