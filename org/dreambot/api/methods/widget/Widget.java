package org.dreambot.api.methods.widget;

import org.dreambot.api.wrappers.widgets.WidgetChild;

import java.util.List;
import java.util.stream.Collectors;

public class Widget {
	private final net.eternalclient.api.wrappers.widgets.Widget widget;
	
	public Widget(net.eternalclient.api.wrappers.widgets.Widget widget) {
		this.widget = widget;
	}
	
	public net.eternalclient.api.wrappers.widgets.Widget toEC() {
		return widget;
	}
	
	public WidgetChild getChild(int id) {
		net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild = widget.getChild(id);
		return widgetChild != null ? new WidgetChild(widgetChild) : null;
	}
	
	public List<WidgetChild> getChildren() {
		return widget.getChildren()
				.stream()
				.map(WidgetChild::new)
				.collect(Collectors.toList());
	}
	
	public int getID() {
		return widget.getID();
	}
	
	public boolean isVisible() {
		return widget.isVisible();
	}
	
	@Override
	public String toString() {
		return widget.toString();
	}
}
