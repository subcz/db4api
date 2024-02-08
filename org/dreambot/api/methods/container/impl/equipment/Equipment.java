package org.dreambot.api.methods.container.impl.equipment;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Equipment {
	public static List<Item> all() {
		return toDBList(net.eternalclient.api.containers.equipment.Equipment.all());
	}
	
	public static List<Item> all(Filter<Item> filter) {
		return toDBList(net.eternalclient.api.containers.equipment.Equipment.all(filterToPredicate(filter)));
	}
	
	public static int capacity() {
		return net.eternalclient.api.containers.equipment.Equipment.capacity();
	}
	
	public static boolean contains(int id) {
		return contains(item -> item.getID() == id);
	}
	
	public static boolean contains(int[] ids) {
		return contains(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean contains(Integer... ids) {
		return contains(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean contains(Object o) {
		return contains(item -> item.equals(o));
	}
	
	public static boolean contains(String name) {
		return contains(item -> item.getName().equals(name));
	}
	
	public static boolean contains(String... names) {
		return contains(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean contains(Filter<Item> filter) {
		return net.eternalclient.api.containers.equipment.Equipment.contains(filterToPredicate(filter));
	}
	
	public static boolean containsAll(int... ids) {
		return net.eternalclient.api.containers.equipment.Equipment.containsAll(ids);
	}
	
	public static boolean containsAll(String names) {
		return net.eternalclient.api.containers.equipment.Equipment.containsAll(names);
	}
	
	public static boolean containsAll(Collection<?> collection) {
		for(Object o : collection) {
			if(!contains(o)) return false;
		}
		return true;
	}
	
	public static int count(int id) {
		return net.eternalclient.api.containers.equipment.Equipment.count(id);
	}
	
	public static int count(String name) {
		return net.eternalclient.api.containers.equipment.Equipment.count(name);
	}
	
	public static int count(Filter<Item> filter) {
		return net.eternalclient.api.containers.equipment.Equipment.count(filterToPredicate(filter));
	}
	
	public static int emptySlotCount() {
		int emptyCount = 0;
		for(net.eternalclient.api.containers.equipment.EquipmentSlot slot : net.eternalclient.api.containers.equipment.EquipmentSlot.values()) {
			if(net.eternalclient.api.containers.equipment.Equipment.isSlotEmpty(slot)) ++emptyCount;
		}
		return emptyCount;
	}
	
	public static boolean equip(EquipmentSlot slot, int[] ids) {
		return equip(slot, Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean equip(EquipmentSlot slot, Integer... ids) {
		return equip(slot, item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean equip(EquipmentSlot slot, String... names) {
		return equip(slot, item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean equip(EquipmentSlot slot, Filter<Item> filter) {
		return net.eternalclient.api.containers.equipment.Equipment.equip(filterToPredicate(filter));
	}
	
	public static List<Item> except(Filter<Item> filter) {
		return all(filter.negate());
	}
	
	public static int fullSlotCount() {
		return net.eternalclient.api.containers.equipment.Equipment.usedSlots();
	}
	
	public static Item get(int id) {
		return get(item -> item.getID() == id);
	}
	
	public static Item get(int[] ids) {
		return get(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static Item get(Integer... ids) {
		return get(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static Item get(String name) {
		return get(item -> item.getName().equals(name));
	}
	
	public static Item get(String... names) {
		return get(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static Item get(Filter<Item> filter) {
		net.eternalclient.api.wrappers.item.Item item = net.eternalclient.api.containers.equipment.Equipment.get(filterToPredicate(filter));
		return item != null ? new Item(item) : null;
	}
	
	public static int getIdForSlot(int slot) {
		return getIdForSlot(EquipmentSlot.forSlotId(slot));
	}
	
	public static int getIdForSlot(EquipmentSlot slot) {
		Item item = getItemInSlot(slot);
		return item != null ? item.getID() : -1;
	}
	
	public static Item getItemInSlot(int slot) {
		return getItemInSlot(Objects.requireNonNull(EquipmentSlot.forSlotId(slot)));
	}
	
	public static Item getItemInSlot(EquipmentSlot slot) {
		net.eternalclient.api.wrappers.item.Item item = net.eternalclient.api.containers.equipment.Equipment.getItemInSlot(slot.toEC());
		return item != null ? new Item(item) : null;
	}
	
	public static String getNameForSlot(int slot) {
		return getNameForSlot(EquipmentSlot.forSlotId(slot));
	}
	
	public static String getNameForSlot(EquipmentSlot slot) {
		Item item = getItemInSlot(slot);
		return item != null ? item.getName() : null;
	}
	
	public static EquipmentSlot getSlotForItem(Filter<Item> filter) {
		return EquipmentSlot.valueOf(net.eternalclient.api.containers.equipment.Equipment.getSlotForItem(filterToPredicate(filter)));
	}
	
	public static boolean interact(EquipmentSlot slot, String action) {
		return net.eternalclient.api.containers.equipment.Equipment.interact(slot.toEC(), action);
	}
	
	public static boolean isEmpty() {
		return net.eternalclient.api.containers.equipment.Equipment.isEmpty();
	}
	
	public static boolean isFull() {
		return net.eternalclient.api.containers.equipment.Equipment.isFull();
	}
	
	public static boolean isOpen() {
		return net.eternalclient.api.containers.equipment.Equipment.isEquipmentInterfaceOpen();
	}
	
	public static boolean isSlotEmpty(int slot) {
		return isSlotEmpty(Objects.requireNonNull(EquipmentSlot.forSlotId(slot)));
	}
	
	public static boolean isSlotEmpty(EquipmentSlot slot) {
		return net.eternalclient.api.containers.equipment.Equipment.isSlotEmpty(slot.toEC());
	}
	
	public static boolean isSlotFull(int slot) {
		return isSlotFull(Objects.requireNonNull(EquipmentSlot.forSlotId(slot)));
	}
	
	public static boolean isSlotFull(EquipmentSlot slot) {
		return net.eternalclient.api.containers.equipment.Equipment.isSlotFull(slot.toEC());
	}
	
	public static boolean onlyContains(int[] ids) {
		return onlyContains(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean onlyContains(Integer... ids) {
		return onlyContains(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean onlyContains(String... names) {
		return onlyContains(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean onlyContains(Filter<Item> filter) {
		return net.eternalclient.api.containers.equipment.Equipment.onlyContains(filterToPredicate(filter));
	}
	
	public static boolean open() {
		return net.eternalclient.api.containers.equipment.Equipment.open();
	}
	
	public static int size() {
		return net.eternalclient.api.containers.equipment.Equipment.getSize();
	}

	public static int slot(int id) {
		return slot(item -> item.getID() == id);
	}
	
	public static int slot(String name) {
		return slot(item -> item.getName() == name);
	}
	
	public static int slot(Filter<Item> filter) {
		net.eternalclient.api.containers.equipment.EquipmentSlot slot = net.eternalclient.api.containers.equipment.Equipment.getSlotForItem(filterToPredicate(filter));
		return slot != null ? slot.getSlotID() : -1;
	}
	
	public static boolean slotContains(int slot, int[] ids) {
		return slotContains(slot, Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean slotContains(int slot, Integer... ids) {
		return slotContains(slot, item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean slotContains(int slot, String name) {
		return slotContains(slot, item -> item.getName().equals(name));
	}
	
	public static boolean slotContains(int slot, String... names) {
		return slotContains(slot, item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean slotContains(int slot, Filter<Item> filter) {
		return slotContains(EquipmentSlot.forSlotId(slot), filter);
	}
	
	public static boolean slotContains(int slot, Item item) {
		return slotContains(slot, i -> i.equals(item));
	}
	
	public static boolean slotContains(EquipmentSlot slot, int[] ids) {
		return slotContains(slot, Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean slotContains(EquipmentSlot slot, Integer... ids) {
		return slotContains(slot, item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean slotContains(EquipmentSlot slot, String name) {
		return slotContains(slot, item -> item.getName().equals(name));
	}
	
	public static boolean slotContains(EquipmentSlot slot, String... names) {
		return slotContains(slot, item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean slotContains(EquipmentSlot slot, Filter<Item> filter) {
		Item item = getItemInSlot(slot);
		return item != null && filter.match(item);
	}
	
	public static boolean slotContains(EquipmentSlot slot, Item item) {
		return slotContains(slot, i -> i.equals(item));
	}
	
	public static boolean unequip(EquipmentSlot slot) {
		return net.eternalclient.api.containers.equipment.Equipment.unEquip(slot.toEC());
	}
	
	public static boolean unequip(Filter<Item> filter) {
		EquipmentSlot slot = getSlotForItem(filter);
		return slot == null || unequip(slot);
	}
	
	private static Predicate<net.eternalclient.api.wrappers.item.Item> filterToPredicate(Filter<Item> filter) {
		return item -> item != null && filter.match(new org.dreambot.api.wrappers.items.Item(item));
	}
	
	private static List<Item> toDBList(List<net.eternalclient.api.wrappers.item.Item> items) {
		return items.stream()
				.map(org.dreambot.api.wrappers.items.Item::new)
				.collect(Collectors.toList());
	}
}
