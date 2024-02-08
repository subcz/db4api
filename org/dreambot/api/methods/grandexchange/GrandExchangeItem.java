package org.dreambot.api.methods.grandexchange;

import net.eternalclient.api.data.GrandExchangeOfferState;
import org.dreambot.api.wrappers.items.Item;

import java.util.Arrays;

public class GrandExchangeItem {
	private final Item item;
	
	public GrandExchangeItem(Item item) {
		this.item = item;
	}
	
	public int getAmount() {
		return item.getAmount();
	}
	
	public int getID() {
		return item.getID();
	}
	
	public Item getItem() {
		return item;
	}
	
	public String getName() {
		return item.getName();
	}
	
	public int getPrice() {
		return net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getPrice();
	}
	
	public int getSlot() {
		return item.getSlot();
	}
	
	public int getTransferredAmount() {
		return net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getQuantitySold();
	}
	
	public int getTransferredValue() {
		return net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getSpent();
	}
	
	public int getValue() {
		return net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getTotalQuantity() * getPrice();
	}
	
	public boolean isBuyOffer() {
		GrandExchangeOfferState state = net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getState();
		return Arrays.asList(GrandExchangeOfferState.BUYING, GrandExchangeOfferState.BOUGHT, GrandExchangeOfferState.CANCELLED_BUY).contains(state);
	}
	
	public boolean isCanceled() {
		GrandExchangeOfferState state = net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getState();
		return Arrays.asList(GrandExchangeOfferState.CANCELLED_BUY, GrandExchangeOfferState.CANCELLED_SELL).contains(state);
	}
	
	public boolean isReadyToCollect() {
		return net.eternalclient.api.containers.ge.GrandExchange.isReadyToCollect(item.getSlot());
	}
	
	public boolean isSellOffer() {
		GrandExchangeOfferState state = net.eternalclient.api.containers.ge.GrandExchange.getGrandExchangeOffer(item.getSlot()).getState();
		return Arrays.asList(GrandExchangeOfferState.SELLING, GrandExchangeOfferState.SOLD, GrandExchangeOfferState.CANCELLED_SELL).contains(state);
	}
}
