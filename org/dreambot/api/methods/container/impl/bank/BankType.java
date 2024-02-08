package org.dreambot.api.methods.container.impl.bank;

import org.dreambot.api.utilities.Logger;

import java.util.Objects;

public enum BankType {
	BOOTH,
	CHEST,
	EXCHANGE,
	NPC;
	
	public net.eternalclient.api.containers.bank.BankType toEC() {
		try {
			return net.eternalclient.api.containers.bank.BankType.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("BANK TYPE: Missing EC bank type for DreamBot bank type \"" + name() + "\".");
			return null;
		}
	}
	
	public String[] getActions() {
		return Objects.requireNonNull(toEC()).getActions();
	}
	
	public static BankType valueOf(net.eternalclient.api.containers.bank.BankType bankType) {
		for(BankType type : values()) {
			if(type.name().equals(bankType.name())) return type;
		}
		return null;
	}
}
