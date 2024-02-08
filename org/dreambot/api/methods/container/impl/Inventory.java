package org.dreambot.api.methods.container.impl;

import net.eternalclient.api.wrappers.tabs.Tab;
import net.eternalclient.api.wrappers.tabs.Tabs;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.awt.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Inventory {
	public static List<Item> all() {
		return toDBList(net.eternalclient.api.containers.Inventory.all());
	}
	
	public static List<Item> all(Filter<Item> filter) {
		return toDBList(net.eternalclient.api.containers.Inventory.all(filterToPredicate(filter)));
	}
	
	public static int capacity() {
		return net.eternalclient.api.containers.Inventory.capacity();
	}
	
	public static boolean contains(int id) {
		return net.eternalclient.api.containers.Inventory.contains(id);
	}
	
	public static boolean contains(int[] ids) {
		return net.eternalclient.api.containers.Inventory.contains(ids);
	}
	
	public static boolean contains(Integer... ids) {
		return contains(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean contains(Object o) {
		return contains(item -> item.equals(o));
	}
	
	public static boolean contains(String string) {
		return net.eternalclient.api.containers.Inventory.contains(string);
	}
	
	public static boolean contains(String... names) {
		return net.eternalclient.api.containers.Inventory.contains(names);
	}
	
	public static boolean contains(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.contains(filterToPredicate(filter));
	}
	
	public static boolean containsAll(int... ids) {
		return net.eternalclient.api.containers.Inventory.containsAll(ids);
	}
	
	public static boolean containsAll(String... names) {
		return net.eternalclient.api.containers.Inventory.containsAll(names);
	}
	
	public static boolean containsAll(Collection<?> collection) {
		for(Object o : collection) {
			if(!contains(o)) return false;
		}
		return true;
	}
	
	public static int count(int id) {
		return net.eternalclient.api.containers.Inventory.count(id);
	}
	
	public static int count(String name) {
		return net.eternalclient.api.containers.Inventory.count(name);
	}
	
	public static int count(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.count(filterToPredicate(filter));
	}
	
	public static boolean deselect() {
		return net.eternalclient.api.containers.Inventory.deselect();
	}
	
	public static boolean drop(int id) {
		return net.eternalclient.api.containers.Inventory.drop(id);
	}
	
	public static boolean drop(String name) {
		return net.eternalclient.api.containers.Inventory.drop(name);
	}
	
	public static boolean drop(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.drop(filterToPredicate(filter));
	}
	
	public static boolean dropAll() {
		return net.eternalclient.api.containers.Inventory.dropAll(item -> true);
	}
	
	public static boolean dropAll(int id) {
		return net.eternalclient.api.containers.Inventory.dropAll(id);
	}
	
	public static boolean dropAll(int[] ids) {
		return net.eternalclient.api.containers.Inventory.dropAll(ids);
	}
	
	public static boolean dropAll(Integer... ids) {
		return dropAll(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean dropAll(String name) {
		return net.eternalclient.api.containers.Inventory.dropAll(name);
	}
	
	public static boolean dropAll(String... names) {
		return net.eternalclient.api.containers.Inventory.dropAll(names);
	}
	
	public static boolean dropAll(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.dropAll(filterToPredicate(filter));
	}
	
	public static boolean dropAllExcept(int[] ids) {
		return dropAllExcept(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean dropAllExcept(Integer... ids) {
		return dropAll(item -> !Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean dropAllExcept(Filter<Item> filter) {
		return dropAll(filter.negate());
	}
	
	public static int emptySlotCount() {
		return net.eternalclient.api.containers.Inventory.freeSlots();
	}
	
	public static List<Item> except(Filter<Item> filter) {
		return all(filter.negate());
	}
	
	public static int fullSlotCount() {
		return capacity() - emptySlotCount();
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
	
	public static Item get(String... name) {
		return get(item -> Arrays.asList(name).contains(item.getName()));
	}
	
	public static Item get(Filter<Item> filter) {
		net.eternalclient.api.wrappers.item.Item item = net.eternalclient.api.containers.Inventory.get(filterToPredicate(filter));
		return item != null ? new Item(item) : null;
	}
	
//	public static String[] getActionsForSlot(int slot) {
//		Item item =  get(item -> item.getSlot())
//	}
	
	public static int getEmptySlots() {
		return emptySlotCount();
	}
	
	public static int getFirstEmptySlot() {
		for(int i = 0; i < capacity(); ++i) {
			Item item = getItemInSlot(i);
			if(item == null) return i;
		}
		return -1;
	}
	
	public static int getFirstFullSlot() {
		for(int i = 0; i < capacity(); ++i) {
			Item item = getItemInSlot(i);
			if(item != null) return i;
		}
		return -1;
	}
	
	public static int getIdForSlot(int index) {
		Item item = getItemInSlot(index);
		return item != null ? item.getID() : -1;
	}
	
	public static WidgetChild getInventoryWidget() {
		net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild = net.eternalclient.api.containers.Inventory.getInventoryWidget();
		return widgetChild != null ? new WidgetChild(widgetChild) : null;
	}
	
	public static Item getItemInSlot(int index) {
		return get(item -> item.getSlot() == index);
	}
	
	public static String getNameForSlot(int index) {
		Item item = getItemInSlot(index);
		return item != null ? item.getName() : null;
	}
	
	public static Item getRandom(int... itemIDs) {
		Integer[] idsArr = Arrays.stream(itemIDs).boxed().toArray(Integer[]::new);
		return getRandom(item -> Arrays.asList(idsArr).contains(item.getID()));
	}
	
	public static Item getRandom(String... itemNames) {
		return getRandom(item -> Arrays.asList(itemNames).contains(item.getName()));
	}
	
	public static Item getRandom(Filter<Item> filter) {
		List<Item> items = all(filter);
		Random r = new Random();
		return items.get(r.nextInt(items.size()));
	}
	
	public static int getSelectedItemId() {
		return net.eternalclient.api.containers.Inventory.getSelectedItemId();
	}
	
	public static int getSelectedItemIndex() {
		return net.eternalclient.api.containers.Inventory.getSelectedItemSlot();
	}
	
	public static String getSelectedItemName() {
		return net.eternalclient.api.containers.Inventory.getSelectedItemName();
	}
	
	public static boolean interact(int id) {
		return net.eternalclient.api.containers.Inventory.interact(id);
	}
	
	public static boolean interact(int id, String action) {
		return net.eternalclient.api.containers.Inventory.interact(id, action);
	}
	
	public static boolean interact(String name) {
		return net.eternalclient.api.containers.Inventory.interact(name);
	}
	
	public static boolean interact(String name, String action) {
		return net.eternalclient.api.containers.Inventory.interact(name, action);
	}
	
	public static boolean interact(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.interact(filterToPredicate(filter));
	}
	
	public static boolean interact(Filter<Item> filter, String action) {
		return net.eternalclient.api.containers.Inventory.interact(filterToPredicate(filter), action);
	}
	
	public static boolean interact(Item item) {
		return net.eternalclient.api.containers.Inventory.interact(item.toEC());
	}
	
	public static boolean interact(Item item, String action) {
		return net.eternalclient.api.containers.Inventory.interact(item.toString(), action);
	}
	
	public static boolean isEmpty() {
		return net.eternalclient.api.containers.Inventory.isEmpty();
	}
	
	public static boolean isFull() {
		return net.eternalclient.api.containers.Inventory.isFull();
	}
	
	public static boolean isItemSelected() {
		return net.eternalclient.api.containers.Inventory.isItemSelected();
	}
	
	public static boolean isSlotEmpty(int slot) {
		return getItemInSlot(slot) == null;
	}
	
	public static boolean isSlotFull(int slot) {
		return !isSlotEmpty(slot);
	}
	
	public static Rectangle itemBounds(Item item) {
		return slotBounds(item.getSlot());
	}
	
	public static boolean onlyContains(int[] id) {
		return net.eternalclient.api.containers.Inventory.onlyContains(id);
	}
	
	public static boolean onlyContains(Integer... id) {
		return net.eternalclient.api.containers.Inventory.onlyContains(item -> Arrays.asList(id).contains(item.getID()));
	}
	
	public static boolean onlyContains(String... names) {
		return net.eternalclient.api.containers.Inventory.onlyContains(names);
	}
	
	public static boolean onlyContains(Filter<Item> filter) {
		return net.eternalclient.api.containers.Inventory.onlyContains(filterToPredicate(filter));
	}
	
	public static boolean open() {
		return Tabs.open(Tab.INVENTORY);
	}
	
	public static int slot(int id) {
		return slot(item -> item.getID() == id);
	}
	
	public static int slot(String name) {
		return slot(item -> item.getName().equals(name));
	}
	
	public static int slot(Filter<Item> filter) {
		Item item = get(filter);
		return item != null ? item.getSlot() : -1;
	}
	
	public static Rectangle slotBounds(int slot) {
		return net.eternalclient.api.containers.Inventory.slotBounds(slot);
	}
	
	public static boolean slotContains(int slot, int[] ids) {
		return slotContains(slot, Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean slotContains(int slot, Integer... ids) {
		return slotContains(slot, item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean slotContains(int slot, String... names) {
		return slotContains(slot, item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean slotContains(int slot, Filter<Item> filter) {
		Item item = getItemInSlot(slot);
		return item != null && filter.match(item);
	}
	
	public static boolean slotContains(int slot, Item t) {
		return slotContains(slot, item -> item.equals(t));
	}
	
	public static boolean slotInteract(int slot) {
		return interact(item -> item.getSlot() == slot);
	}
	
	public static boolean slotInteract(int slot, String action) {
		return interact(item -> item.getSlot() == slot, action);
	}
	
	public static boolean slotNameContains(int slot, String sub) {
		return slotContains(slot, item -> item.getName().contains(sub));
	}
	
	public static Item[] toArray() {
		return all().toArray(Item[]::new);
	}
	
	public static boolean use(int id) {
		return interact(id, "Use");
	}
	
	public static boolean use(String name) {
		return interact(name, "Use");
	}
	
	public static boolean use(Item item) {
		return interact(item, "Use");
	}
	
	private static Predicate<net.eternalclient.api.wrappers.item.Item> filterToPredicate(Filter<Item> filter) {
		return item -> item != null && filter.match(new Item(item));
	}
	
	private static List<Item> toDBList(List<net.eternalclient.api.wrappers.item.Item> items) {
		return items.stream()
				.map(Item::new)
				.collect(Collectors.toList());
	}
}
