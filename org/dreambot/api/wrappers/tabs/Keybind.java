package org.dreambot.api.wrappers.tabs;

import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.input.FKeys;

import java.util.HashMap;
import java.util.Objects;

public enum Keybind {
	ACCOUNT,
	ATTACK,
	EMOTE,
	EQUIPMENT,
	FRIEND,
	GROUPING,
	INVENTORY,
	LOGOUT,
	MAGIC,
	MUSIC,
	PRAYER,
	QUEST,
	SETTINGS,
	SKILL;
	
	public net.eternalclient.api.wrappers.tabs.keybinds.Keybind toEC() {
		try {
			return net.eternalclient.api.wrappers.tabs.keybinds.Keybind.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("KEYBIND: Missing EC keybind for DreamBot keybind \"" + name() + "\".");
			return null;
		}
	}
	
	public static Keybind get(int varpbitValue) {
		return valueOf(net.eternalclient.api.wrappers.tabs.keybinds.Keybind.get(varpbitValue));
	}
	
	public static HashMap<Keybind, FKeys> getAllKeybinds() {
		HashMap<net.eternalclient.api.wrappers.tabs.keybinds.Keybind, net.eternalclient.api.wrappers.input.FKeys> ecKeybinds = net.eternalclient.api.wrappers.tabs.keybinds.Keybind.getAllKeybinds();
		HashMap<Keybind, FKeys> result = new HashMap<>();
		for(net.eternalclient.api.wrappers.tabs.keybinds.Keybind keybind : ecKeybinds.keySet()) {
			result.put(valueOf(keybind), FKeys.valueOf(ecKeybinds.get(keybind)));
		}
		return result;
	}
	
	public int getBindVarpbit() {
		return Objects.requireNonNull(toEC()).getBindVarpbit();
	}
	
	public static FKeys getKeybind(Keybind keybind) {
		return FKeys.valueOf(net.eternalclient.api.wrappers.tabs.keybinds.Keybind.getKeybind(keybind.toEC()));
	}
	
	@Override
	public String toString() {
		return Objects.requireNonNull(toEC()).toString();
	}
	
	public static Keybind valueOf(net.eternalclient.api.wrappers.tabs.keybinds.Keybind keybind) {
		for(Keybind kb : values()) {
			if(kb.name().equals(keybind.name())) return kb;
		}
		Logger.log("KEYBIND: Missing Dreambot keybind for EC keybind \"" + keybind + "\".");
		return null;
	}
}
