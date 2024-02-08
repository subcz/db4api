package org.dreambot.api.methods.container.impl.bank;

import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Objects;

public enum BankMode {
	INSERT,
	ITEM,
	NOTE,
	SWAP;
	
	public net.eternalclient.api.containers.bank.BankMode toEC() {
		try {
			return net.eternalclient.api.containers.bank.BankMode.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("BANK MODE: Missing EC bank mode for DreamBot bank mode \"" + name() + "\".");
			return null;
		}
	}
	
	public int getChildId() {
		return Objects.requireNonNull(toEC()).getChildIndex();
	}
	
	@Override
	public String toString() {
		return Objects.requireNonNull(toEC()).toString();
	}
	
	public static BankMode valueOf(net.eternalclient.api.containers.bank.BankMode bankMode) {
		for(BankMode mode : values()) {
			if(mode.name().equals(bankMode.name())) return mode;
		}
		Logger.log("BANK MODE: Missing Dreambot bank mode for EC bank mode \"" + bankMode + "\".");
		return null;
	}
}
