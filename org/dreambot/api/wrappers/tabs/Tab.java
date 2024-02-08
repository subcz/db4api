package org.dreambot.api.wrappers.tabs;

import org.dreambot.api.utilities.Logger;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Objects;

public enum Tab {
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
	
	public net.eternalclient.api.wrappers.tabs.Tab toEC() {
		try {
			return net.eternalclient.api.wrappers.tabs.Tab.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("TAB: Missing EC tab for DreamBot tab \"" + name() + "\".");
			return null;
		}
	}
	
	public Keybind getKeybind() {
		return Keybind.valueOf(Objects.requireNonNull(toEC()).getKeybind());
	}
	
	public WidgetChild getWidget() {
		net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild = Objects.requireNonNull(toEC()).getWidget();
		return widgetChild != null ? new WidgetChild(widgetChild) : null;
	}
	
	public boolean isDisabled() {
		return Objects.requireNonNull(toEC()).isDisabled();
	}
	
	public boolean isOpen() {
		return Objects.requireNonNull(toEC()).isOpen();
	}
	
	@Override
	public String toString() {
		return Objects.requireNonNull(toEC()).toString();
	}
	
	public static Tab valueOf(net.eternalclient.api.wrappers.tabs.Tab tab) {
		for(Tab t : values()) {
			if(t.name().equals(tab.name())) return t;
		}
		Logger.log("TAB: Missing Dreambot tab for EC tab \"" + tab + "\".");
		return null;
	}
}
