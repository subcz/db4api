package org.dreambot.api.methods.widget;

import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Widgets {
	public static boolean closeAll() {
		net.eternalclient.api.accessors.Widgets.closeAll();
		return true;
	}
	
	public static WidgetChild get(int... ids) {
		net.eternalclient.api.wrappers.widgets.WidgetChild widget = net.eternalclient.api.accessors.Widgets.getWidgetChild(ids);
		return widget != null ? new WidgetChild(widget) : null;
	}
	
	public static WidgetChild get(Filter<WidgetChild> filter) {
		net.eternalclient.api.wrappers.widgets.WidgetChild widget = net.eternalclient.api.accessors.Widgets.getWidgetChild(filterToPredicate(filter));
		return widget != null ? new WidgetChild(widget) : null;
	}
	
	public static List<WidgetChild> getAll() {
		return toDBList(net.eternalclient.api.accessors.Widgets.getWidgets(w -> true));
	}
	
	public static List<WidgetChild> getAllContainingText(String text) {
		return toDBList(net.eternalclient.api.accessors.Widgets.getWidgetChildrenContainingText(text));
	}
	
	public static List<Widget> getAllWidgets() {
		return net.eternalclient.api.accessors.Widgets.getAllWidgets()
				.stream()
				.map(Widget::new)
				.collect(Collectors.toList());
	}
	
	public static Widget getWidget(int id) {
		net.eternalclient.api.wrappers.widgets.Widget widget = net.eternalclient.api.accessors.Widgets.getWidget(id);
		return widget != null ? new Widget(widget) : null;
	}
	
	public static boolean isOpen() {
		return net.eternalclient.api.accessors.Widgets.canCloseWidgets();
	}
	
	public static boolean isVisible(int... ids) {
		WidgetChild widgetChild = get(ids);
		return widgetChild != null && widgetChild.isVisible();
	}
	
	private static Predicate<net.eternalclient.api.wrappers.widgets.WidgetChild> filterToPredicate(Filter<WidgetChild> filter) {
		return w -> filter.match(new WidgetChild(w));
	}
	
	private static List<WidgetChild> toDBList(List<net.eternalclient.api.wrappers.widgets.WidgetChild> widgets) {
		return widgets.stream()
				.map(WidgetChild::new)
				.collect(Collectors.toList());
	}
}
