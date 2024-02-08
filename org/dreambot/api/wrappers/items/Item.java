package org.dreambot.api.wrappers.items;

import net.eternalclient.api.containers.Inventory;
import org.dreambot.api.interfaces.Identifiable;

public class Item implements Identifiable {
	private net.eternalclient.api.wrappers.item.Item item;
	
	public Item(int itemId, int stack, int slot) {
		this.item = new net.eternalclient.api.wrappers.item.Item(itemId, stack, slot);
	}
	
	public Item(int itemId, int stack) {
		this.item = new net.eternalclient.api.wrappers.item.Item(itemId, stack);
	}
	
	public Item(net.eternalclient.api.wrappers.item.Item item) {
		this.item = item;
	}
	
	public net.eternalclient.api.wrappers.item.Item toEC() {
		return item;
	}
	
	public boolean equals(net.eternalclient.api.wrappers.item.Item item) {
		return this.item.equals(item);
	}
	
	public boolean equals(Item item) {
		return equals(item.item);
	}
	
	public String[] getActions() {
		return item.getActions();
	}
	
	public int getAmount() {
		return item.getAmount();
	}
	
	public int getID() {
		return item.getID();
	}
	
	public int getLowAlchValue() {
		return item.getLAPrice();
	}
	
	public String getName() {
		return item.getName();
	}
	
	public int getNotedItemID() {
		return item.getNotedItemID();
	}
	
	public int getSlot() {
		return item.getSlot();
	}
	
	public int getUnnotedItemID() {
		return item.getUnnotedItemID();
	}
	
	public int getValue() {
		return item.getValue();
	}
	
	public boolean hasAction(String... actions) {
		return item.hasAction(actions);
	}
	
	public int hashCode() {
		return item.hashCode();
	}
	
	public boolean interact() {
		return Inventory.interact(item, getActions()[0]);
	}
	
	public boolean interact(String action) {
		return Inventory.interact(item, action);
	}
	
	public boolean isMembersOnly() {
		return item.isMembers();
	}
	
	public boolean isNotable() {
		return item.getNotedItemID() != -1;
	}
	
	public boolean isNoted() {
		return item.isNoted();
	}
	
	public boolean isPlaceholder() {
		return item.isPlaceholder();
	}
	
	public boolean isStackable() {
		return item.isStackable();
	}
	
	public boolean isTradable() {
		return item.isTradable();
	}
	
	public void setAmount(int amount) {
		item = new net.eternalclient.api.wrappers.item.Item(item.getID(), amount);
	}
	
	@Override
	public String toString() {
		return item.toString();
	}
}
