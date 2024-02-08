package org.dreambot.api.methods.container.impl.equipment;

import org.dreambot.api.misc.Formatting;
import org.dreambot.api.wrappers.items.Item;

import java.awt.*;
import java.util.Arrays;

public enum EquipmentSlot {
	AMULET(net.eternalclient.api.containers.equipment.EquipmentSlot.AMULET),
	ARROWS(net.eternalclient.api.containers.equipment.EquipmentSlot.AMMO),
	CAPE(net.eternalclient.api.containers.equipment.EquipmentSlot.CAPE),
	CHEST(net.eternalclient.api.containers.equipment.EquipmentSlot.CHEST),
	FEET(net.eternalclient.api.containers.equipment.EquipmentSlot.FEET),
	HANDS(net.eternalclient.api.containers.equipment.EquipmentSlot.HANDS),
	HAT(net.eternalclient.api.containers.equipment.EquipmentSlot.HAT),
	LEGS(net.eternalclient.api.containers.equipment.EquipmentSlot.LEGS),
	RING(net.eternalclient.api.containers.equipment.EquipmentSlot.RING),
	SHIELD(net.eternalclient.api.containers.equipment.EquipmentSlot.SHIELD),
	WEAPON(net.eternalclient.api.containers.equipment.EquipmentSlot.WEAPON);
	
	private final String name;
	private final net.eternalclient.api.containers.equipment.EquipmentSlot ec;
	
	EquipmentSlot(net.eternalclient.api.containers.equipment.EquipmentSlot ec) {
		this.name = Formatting.pascalToRegular(name());
		this.ec = ec;
	}
	
	public net.eternalclient.api.containers.equipment.EquipmentSlot toEC() {
		return ec;
	}

	public static EquipmentSlot forSlotId(int id) {
		for(EquipmentSlot slot : values()) {
			if(slot.getSlot() == id) return slot;
		}
		return null;
	}
	
	public String[] getActions() {
		net.eternalclient.api.wrappers.item.Item item = ec.getItem();
		return item != null ? item.getActions() : new String[0];
	}
	
	public int getChildWidget() {
		return ec.getWidgetInfo().getChildId();
	}
	
	public Rectangle getPosition() {
		return ec.getBounds();
	}
	
	public int getRealSlot() {
		return getSlot();
	}
	
	public int getSlot() {
		return ec.getSlotID();
	}
	
	public boolean hasAction(String action) {
		return Arrays.asList(getActions()).contains(action);
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static EquipmentSlot valueOf(net.eternalclient.api.containers.equipment.EquipmentSlot equipmentSlot) {
		for(EquipmentSlot slot : values()) {
			if(slot.ec == equipmentSlot) return slot;
		}
		return null;
	}
}
