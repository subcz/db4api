package org.dreambot.api.methods.container.impl.bank;

import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Objects;

public enum BankTab {
	MAIN_TAB,
	FIRST_TAB,
	SECOND_TAB,
	THIRD_TAB,
	FOURTH_TAB,
	FIFTH_TAB,
	SIXTH_TAB,
	SEVENTH_TAB,
	EIGHTH_TAB,
	NINTH_TAB;
	
	public net.eternalclient.api.containers.bank.BankTab toEC() {
		try {
			return net.eternalclient.api.containers.bank.BankTab.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("BANK TAB: Missing EC bank tab for DreamBot bank tab \"" + name() + "\".");
			return null;
		}
	}
	
	public WidgetChild getWidgetChild() {
		net.eternalclient.api.wrappers.widgets.WidgetChild wigetChild = Objects.requireNonNull(toEC()).getWidget();
		return wigetChild != null ? new WidgetChild(wigetChild) : null;
	}
	
	public static BankTab valueOf(net.eternalclient.api.containers.bank.BankTab bankTab) {
		for(BankTab tab : values()) {
			if(tab.name().equals(bankTab.name())) return tab;
		}
		Logger.log("BANK TAB: Missing Dreambot bank tab for EC bank tab \"" + bankTab + "\".");
		return null;
	}
}
