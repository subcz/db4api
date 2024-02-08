package org.dreambot.api.methods.container.impl.bank;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Bank {
	public static List<Item> all() {
		return toDBList(net.eternalclient.api.containers.bank.Bank.all());
	}
	
	public static List<Item> all(Filter<Item> filter) {
		return toDBList(net.eternalclient.api.containers.bank.Bank.all(filterToPredicate(filter)));
	}
	
	public static int capacity() {
		return net.eternalclient.api.containers.bank.Bank.capacity();
	}
	
	public static boolean close() {
		return net.eternalclient.api.containers.bank.Bank.close();
	}
	
	public static boolean contains(int id) {
		return net.eternalclient.api.containers.bank.Bank.contains(id);
	}
	
	public static boolean contains(int[] ids) {
		return net.eternalclient.api.containers.bank.Bank.contains(ids);
	}
	
	public static boolean contains(Integer... ids) {
		return contains(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean contains(Object o) {
		return contains(item -> item.equals(o));
	}
	
	public static boolean contains(String string) {
		return net.eternalclient.api.containers.bank.Bank.contains(string);
	}
	
	public static boolean contains(String... names) {
		return net.eternalclient.api.containers.bank.Bank.contains(names);
	}
	
	public static boolean contains(Filter<Item> filter) {
		return net.eternalclient.api.containers.bank.Bank.contains(filterToPredicate(filter));
	}
	
	public static boolean containsAll(int[] ids) {
		return net.eternalclient.api.containers.bank.Bank.containsAll(ids);
	}
	
	public static boolean containsAll(Integer... ids) {
		return containsAll(Arrays.stream(ids).mapToInt(Integer::intValue).toArray());
	}
	
	public static boolean containsAll(String... names) {
		return net.eternalclient.api.containers.bank.Bank.containsAll(names);
	}
	
	public static boolean containsAll(Collection<?> collection) {
		for(Object o : collection) {
			if(!contains(o)) return false;
		}
		return true;
	}
	
	public static int count(int id) {
		return net.eternalclient.api.containers.bank.Bank.count(id);
	}
	
	public static int count(int[] ids) {
		return net.eternalclient.api.containers.bank.Bank.count(ids);
	}
	
	public static int count(Integer... ids) {
		return net.eternalclient.api.containers.bank.Bank.count(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static int count(String name) {
		return net.eternalclient.api.containers.bank.Bank.count(name);
	}
	
	public static int count(String... names) {
		return net.eternalclient.api.containers.bank.Bank.count(names);
	}
	
	public static int count(Filter<Item> filter) {
		return net.eternalclient.api.containers.bank.Bank.count(filterToPredicate(filter));
	}
	
	public static boolean deposit(int id) {
		return deposit(id, 1);
	}
	
	public static boolean deposit(int id, int amount) {
		return net.eternalclient.api.containers.bank.Bank.deposit(id, amount);
	}
	
	public static boolean deposit(String name) {
		return deposit(name, 1);
	}
	
	public static boolean deposit(String name, int amount) {
		return net.eternalclient.api.containers.bank.Bank.deposit(name, amount);
	}
	
	public static boolean deposit(Filter<Item> filter) {
		return deposit(filter, 1);
	}
	
	public static boolean deposit(Filter<Item> filter, int amount) {
		return net.eternalclient.api.containers.bank.Bank.deposit(filterToPredicate(filter), amount);
	}
	
	public static boolean deposit(Item item) {
		return deposit(item, 1);
	}
	
	public static boolean deposit(Item item, int amount) {
		return deposit(i -> i.equals(item), amount);
	}
	
	public static boolean depositAll(int id) {
		return net.eternalclient.api.containers.bank.Bank.depositAll(id);
	}
	
	public static boolean depositAll(String name) {
		return net.eternalclient.api.containers.bank.Bank.depositAll(name);
	}
	
	public static boolean depositAll(Filter<Item> filter) {
		return net.eternalclient.api.containers.bank.Bank.depositAll(filterToPredicate(filter));
	}
	
	public static boolean depositAll(Item item) {
		return depositAll(i -> i.equals(item));
	}
	
	public static boolean depositAllEquipment() {
		return net.eternalclient.api.containers.bank.Bank.depositEquipment();
	}
	
	public static boolean depositAllExcept(int[] ids) {
		return depositAllExcept(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean depositAllExcept(Integer... ids) {
		return depositAllExcept(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean depositAllExcept(Filter<Item> filter) {
		return net.eternalclient.api.containers.bank.Bank.depositAllExcept(filterToPredicate(filter));
	}
	
	public static boolean depositAllExcept(String... names) {
		return depositAllExcept(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static int emptySlotCount() {
		return net.eternalclient.api.containers.bank.Bank.freeSlots();
	}
	
	public static List<Item> except(Filter<Item> filter) {
		return toDBList(net.eternalclient.api.containers.bank.Bank.allExcept(filterToPredicate(filter)));
	}
	
	public static int fullSlotCount() {
		return net.eternalclient.api.containers.bank.Bank.usedSlots();
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
		net.eternalclient.api.wrappers.item.Item item = net.eternalclient.api.containers.bank.Bank.get(filterToPredicate(filter));
		return item != null ? new Item(item) : null;
	}
	
	public static List<Item> getBankHistoryCache() {
		return toDBList(net.eternalclient.api.containers.bank.Bank.getBankHistoryCache());
	}
	
	public static BankLocation getClosestBankLocation() {
		return BankLocation.valueOf(net.eternalclient.api.containers.bank.Bank.getClosestBank());
	}
	
	public static BankTab getCurrentBankTab() {
		return BankTab.valueOf(net.eternalclient.api.containers.bank.Bank.getCurrentBankTab());
	}
	
	public static int getCurrentTab() {
		return getCurrentBankTab().ordinal();
	}
	
	public static int getIdForSlot(int slot) {
		Item item = getItemInSlot(slot);
		return item != null ? item.getID() : -1;
	}
	
	public static Item getItemInSlot(int slot) {
		return get(item -> item.getSlot() == slot);
	}
	
	public static String getNameForSlot(int slot) {
		Item item = getItemInSlot(slot);
		return item != null ? item.getName() : null;
	}
	
	public static BankMode getRearrangeMode() {
		return BankMode.valueOf(net.eternalclient.api.containers.bank.Bank.getRearrangeMode());
	}
	
	public static int getSlot(int id) {
		return getSlot(item -> item.getID() == id);
	}
	
	public static int getSlot(String name) {
		return getSlot(item -> item.getName().equals(name));
	}
	
	public static int getSlot(Filter<Item> filter) {
		Item item = get(filter);
		return item != null ? item.getSlot() : -1;
	}
	
	public static BankMode getWithdrawMode() {
		return BankMode.valueOf(net.eternalclient.api.containers.bank.Bank.getWithdrawMode());
	}
	
	public static boolean isEmpty() {
		return net.eternalclient.api.containers.bank.Bank.isEmpty();
	}
	
	public static boolean isFull() {
		return net.eternalclient.api.containers.bank.Bank.isFull();
	}
	
	public static boolean isOpen() {
		return net.eternalclient.api.containers.bank.Bank.isOpen();
	}
	
	public static boolean isSlotEmpty(int slot) {
		return getItemInSlot(slot) == null;
	}
	
	public static boolean isSlotFull(int slot) {
		return getItemInSlot(slot) != null;
	}
	
	public static boolean onlyContains(int id) {
		return onlyContains(item -> item.getID() == id);
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
		return net.eternalclient.api.containers.bank.Bank.onlyContains(filterToPredicate(filter));
	}
	
	public static boolean open() {
		return net.eternalclient.api.containers.bank.Bank.open();
	}
	
	public static boolean setWithdrawMode(BankMode mode) {
		return net.eternalclient.api.containers.bank.Bank.setWithdrawMode(mode.toEC());
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
	
	public static boolean slotNameContains(int slot, String sub) {
		return slotContains(slot, item -> item.getName().contains(sub));
	}
	
	public static boolean withdraw(int id) {
		return withdraw(id, 1);
	}
	
	public static boolean withdraw(int id, int amount) {
		return net.eternalclient.api.containers.bank.Bank.withdraw(id, amount);
	}
	
	public static boolean withdraw(String name) {
		return withdraw(name, 1);
	}
	
	public static boolean withdraw(String name, int amount) {
		return net.eternalclient.api.containers.bank.Bank.withdraw(name, amount);
	}
	
	public static boolean withdraw(Filter<Item> filter) {
		return withdraw(filter, 1);
	}
	
	public static boolean withdraw(Filter<Item> filter, int amount) {
		return net.eternalclient.api.containers.bank.Bank.withdraw(filterToPredicate(filter), amount);
	}
	
	public static boolean withdrawAll(int id) {
		return net.eternalclient.api.containers.bank.Bank.withdrawAll(id);
	}
	
	public static boolean withdrawAll(String name) {
		return net.eternalclient.api.containers.bank.Bank.withdrawAll(name);
	}
	
	public static boolean withdrawAll(Filter<Item> filter) {
		return net.eternalclient.api.containers.bank.Bank.withdrawAll(filterToPredicate(filter));
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
