package org.dreambot.api.methods.grandexchange;

import org.dreambot.api.Client;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GrandExchange {
	public static boolean close() {
		return net.eternalclient.api.containers.ge.GrandExchange.close();
	}
	
	public static boolean collect() {
		return net.eternalclient.api.containers.ge.GrandExchange.collect(true);
	}
	
	public static boolean collectToBank() {
		return net.eternalclient.api.containers.ge.GrandExchange.collect(false);
	}
	
	public static boolean confirm() {
		return net.eternalclient.api.containers.ge.GrandExchange.confirm();
	}
	
	public static boolean contains(int[] ids) {
		return contains(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static boolean contains(Integer... ids) {
		return contains(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static boolean contains(String... names) {
		return contains(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static boolean contains(Filter<Item> filter) {
		return !net.eternalclient.api.containers.ge.GrandExchange.getAllItems(filterToPredicate(filter)).isEmpty();
	}
	
	public static int getCurrentAmount() {
		return net.eternalclient.api.containers.ge.GrandExchange.getCurrentAmount();
	}
	
	public static Item getCurrentChosenItem() {
		int slot = net.eternalclient.api.containers.ge.GrandExchange.getCurrentSlot();
		GrandExchangeItem geItem = getItem(item -> item.getSlot() == slot);
		return geItem != null ? geItem.getItem() : null;
	}
	
	public static int getCurrentChosenItemID() {
		return net.eternalclient.api.containers.ge.GrandExchange.getCurrentChosenItemID();
	}
	
	public static int getCurrentPrice() {
		return net.eternalclient.api.containers.ge.GrandExchange.getCurrentPrice();
	}
	
	public static WidgetChild getEnterAllButton() {
		return getDBWidgetChild(net.eternalclient.api.containers.ge.GrandExchange.getEnterAllButton());
	}
	
	public static WidgetChild getEnterPriceButton() {
		return getDBWidgetChild(net.eternalclient.api.containers.ge.GrandExchange.getEnterPriceButton());
	}
	
	public static WidgetChild getEnterQuantityButton() {
		return getDBWidgetChild(net.eternalclient.api.containers.ge.GrandExchange.getEnterQuantityButton());
	}
	
	public static int getFirstOpeNSlot() {
		return net.eternalclient.api.containers.ge.GrandExchange.getFirstOpenSlot();
	}
	
	public static GrandExchangeItem getItem(int[] ids) {
		return getItem(Arrays.stream(ids).boxed().toArray(Integer[]::new));
	}
	
	public static GrandExchangeItem getItem(Integer... ids) {
		return getItem(item -> Arrays.asList(ids).contains(item.getID()));
	}
	
	public static GrandExchangeItem getItem(String... names) {
		return getItem(item -> Arrays.asList(names).contains(item.getName()));
	}
	
	public static GrandExchangeItem getItem(Filter<Item> filter) {
		List<Item> items = toDBList(net.eternalclient.api.containers.ge.GrandExchange.getAllItems(filterToPredicate(filter)));
		return !items.isEmpty() ? new GrandExchangeItem(items.get(0)) : null;
	}
	
	public static List<GrandExchangeItem> getItems() {
		return net.eternalclient.api.containers.ge.GrandExchange.getAllItems().stream()
				.map(item -> item != null ? new GrandExchangeItem(new Item(item)) : null)
				.collect(Collectors.toList());
	}
	
	public static int getOpenSlots() {
		return (Client.isMembers() ? 2 : 8) - net.eternalclient.api.containers.ge.GrandExchange.getOccupiedSlotCount();
	}
	
	public static String getSearchedItem() {
		return net.eternalclient.api.containers.ge.GrandExchange.getSearchString();
	}
	
	public static int getUsedSlots() {
		return net.eternalclient.api.containers.ge.GrandExchange.getOccupiedSlotCount();
	}
	
	public static boolean goBack() {
		return net.eternalclient.api.containers.ge.GrandExchange.goBack();
	}
	
	public static boolean isBuyOpen() {
		return net.eternalclient.api.containers.ge.GrandExchange.isBuyOpen();
	}
	
	public static boolean isGeneralOpen() {
		return net.eternalclient.api.containers.ge.GrandExchange.isGeneralOpen();
	}
	
	public static boolean isOpen() {
		return net.eternalclient.api.containers.ge.GrandExchange.isOpen();
	}
	
	public static boolean isReadyToCollect() {
		return net.eternalclient.api.containers.ge.GrandExchange.isReadyToCollect();
	}
	
	public static boolean isReadyToCollect(int slot) {
		return net.eternalclient.api.containers.ge.GrandExchange.isReadyToCollect(slot);
	}
	
	public static boolean isSellOpen() {
		return net.eternalclient.api.containers.ge.GrandExchange.isSellOpen();
	}
	
	public static boolean isSlotEnabled(int slot) {
		return net.eternalclient.api.containers.ge.GrandExchange.isSlotEnabled(slot);
	}
	
	public static boolean open() {
		return net.eternalclient.api.containers.ge.GrandExchange.open();
	}
	
	public static boolean openBuyScreen(int slot) {
		return net.eternalclient.api.containers.ge.GrandExchange.openBuyScreen(slot);
	}
	
	public static boolean openSellScreen(int slot) {
		return net.eternalclient.api.containers.ge.GrandExchange.openSellScreen(slot);
	}
	
	public static boolean openSlotInterface(int slot) {
		return net.eternalclient.api.containers.ge.GrandExchange.openSlotInterface(slot);
	}
	
	private static WidgetChild getDBWidgetChild(net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild) {
		return widgetChild != null ? new WidgetChild(widgetChild) : null;
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
