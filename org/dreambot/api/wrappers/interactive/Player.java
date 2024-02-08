package org.dreambot.api.wrappers.interactive;

import net.eternalclient.api.wrappers.item.Item;
import org.checkerframework.checker.units.qual.A;
import org.dreambot.api.interfaces.Identifiable;
import org.dreambot.api.interfaces.Locatable;
import org.dreambot.api.misc.Hashing;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Player extends Character implements Identifiable, Locatable {
	private final net.eternalclient.api.wrappers.interactives.Player player;
	
	public Player(net.eternalclient.api.wrappers.interactives.Player player) {
		super(player);
		
		this.player = player;
	}
	
	public net.eternalclient.api.wrappers.interactives.Player toEC() {
		return player;
	}
	
	public boolean equals(net.eternalclient.api.wrappers.interactives.Player player) {
		return this.player.equals(player);
	}
	
	public boolean equals(Player player) {
		return equals(player.player);
	}
	
	public String[] getActions() {
		return player.getActions();
	}
	
	public Rectangle getBoundingBox() {
		return player.getClickBox().getBounds();
	}
	
	public java.util.List<Item> getEquipment() {
		ArrayList<Item> equipment = new ArrayList<>();
		for(int id : player.getEquipmentIDs()) {
			equipment.add(new Item(id, 1));
		}
		return equipment;
	}
	
	public int getID() {
		return player.getID();
	}
	
	public int getIndex() {
		return player.getIndex();
	}
	
	public int getLevel() {
		return player.getCombatLevel();
	}
	
	public String getName() {
		return player.getName();
	}
	
	public boolean hasAction(String... actions) {
		return player.hasAction(actions);
	}
	
	public String hashed() {
		return Hashing.hashed(player.getName());
	}
	
	public String hashed(String prepend, String append) {
		return prepend + hashed() + append;
	}
	
	public boolean isSkulled() {
		return player.isSkulled();
	}
	
	@Override
	public String toString() {
		return player.toString();
	}
}
