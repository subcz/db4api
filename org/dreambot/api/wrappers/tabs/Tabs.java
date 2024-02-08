package org.dreambot.api.wrappers.tabs;

public class Tabs {
	public static Tab getOpen() {
		return Tab.valueOf(net.eternalclient.api.wrappers.tabs.Tabs.getOpen());
	}
	
	public static boolean isDisabled(Tab tab) {
		return net.eternalclient.api.wrappers.tabs.Tabs.isDisabled(tab.toEC());
	}
	
	public static boolean isOpen(Tab tab) {
		return net.eternalclient.api.wrappers.tabs.Tabs.isOpen(tab.toEC());
	}
	
	public static boolean logout() {
		return net.eternalclient.api.wrappers.tabs.Tabs.logout();
	}
	
	public static boolean open(Tab tab) {
		return net.eternalclient.api.wrappers.tabs.Tabs.open(tab.toEC());
	}
	
	public static boolean openWithKey(Tab tab) {
		return net.eternalclient.api.wrappers.tabs.Tabs.openWithFKey(tab.toEC());
	}
}
