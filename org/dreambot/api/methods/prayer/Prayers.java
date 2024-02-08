package org.dreambot.api.methods.prayer;

import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.Arrays;

public class Prayers {
	public static Prayer[] getActive() {
		return Arrays.stream(net.eternalclient.api.wrappers.prayer.Prayers.getActive())
				.map(Prayer::valueOf)
				.toArray(Prayer[]::new);
	}
	
	public static WidgetChild getWidgetChild(Prayer prayer) {
		return prayer.getWidgetChild();
	}
	
	public static WidgetChild getWidgetChildQuickPrayer(Prayer prayer) {
		net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild = net.eternalclient.api.wrappers.prayer.Prayers.getQuickPrayerWidgetChild();
		return widgetChild != null ? new WidgetChild(widgetChild) : null;
	}
	
	public static boolean isActive(Prayer prayer) {
		return prayer.toEC().isActive();
	}
	
	public static boolean isOpen() {
		return net.eternalclient.api.wrappers.prayer.Prayers.isOpen();
	}
	
	public static boolean isQuickPrayerActive() {
		return net.eternalclient.api.wrappers.prayer.Prayers.isQuickPrayerActive();
	}
	
	public static boolean openTab() {
		return net.eternalclient.api.wrappers.prayer.Prayers.openTab();
	}
	
	public static boolean toggle(boolean active, Prayer prayer) {
		if(isActive(prayer) == active) return true;
		return active ? net.eternalclient.api.wrappers.prayer.Prayers.enable(prayer.toEC()) :
				net.eternalclient.api.wrappers.prayer.Prayers.disable(prayer.toEC());
	}
	
	public static boolean toggleQuickPrayer(boolean active) {
		return active ? net.eternalclient.api.wrappers.prayer.Prayers.enableQuickPrayer() :
				net.eternalclient.api.wrappers.prayer.Prayers.disableQuickPrayer();
	}
}
