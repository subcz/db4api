package org.dreambot.api.wrappers.widgets;

import net.eternalclient.api.wrappers.input.Mouse;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.wrappers.items.Item;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WidgetChild {
	private final net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild;
	
	public WidgetChild(net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild) {
		this.widgetChild = widgetChild;
	}
	
	public net.eternalclient.api.wrappers.widgets.WidgetChild toEC() {
		return widgetChild;
	}
	
	public boolean containsMouse() {
		Rectangle rect = getRectangle();
		return rect != null && rect.contains(Mouse.getMousePosition());
	}
	
	public boolean equals(net.eternalclient.api.wrappers.widgets.WidgetChild widgetChild) {
		return this.widgetChild.equals(widgetChild);
	}
	
	public boolean equals(WidgetChild widgetChild) {
		return equals(widgetChild.widgetChild);
	}
	
	public String[] getActions() {
		return widgetChild.getActions();
	}
	
	public int getActionType() {
		return widgetChild.getActionType();
	}
	
	public WidgetChild getChild(int index) {
		net.eternalclient.api.wrappers.widgets.WidgetChild w = widgetChild.getChild(index);
		return w != null ? new WidgetChild(w) : null;
	}
	
	private List<Item> getChildItems() {
		return widgetChild.getChildItems()
				.stream()
				.filter(Objects::nonNull)
				.map(Item::new)
				.collect(Collectors.toList());
	}
	
	public WidgetChild[] getChildren() {
		return widgetChild.getChildren()
				.stream()
				.map(WidgetChild::new)
				.toArray(WidgetChild[]::new);
	}
	
	public int getChildSequenceId() {
		return widgetChild.getSpriteId();
	}
	
	public int getHeight() {
		return widgetChild.getHeight();
	}
	
	public int getID() {
		return widgetChild.getID();
	}
	
	public int getIndex() {
		return widgetChild.getIndex();
	}
	
	public Item getItem() {
		net.eternalclient.api.wrappers.item.Item item = widgetChild.getItem();
		return item != null ? new Item(item) : null;
	}
	
	public int getItemId() {
		return widgetChild.getItemID();
	}
	
	public List<Item> getItems() {
		return widgetChild.getItems()
				.stream()
				.filter(Objects::nonNull)
				.map(Item::new)
				.collect(Collectors.toList());
	}
	
	public int getItemStack() {
		return widgetChild.getItemStack();
	}
	
	public String getLeftClickAction() {
		String[] actions = widgetChild.getActions();
		return actions.length > 0 ? actions[0] : null;
	}
	
	public int getLoopCycle() {
		return widgetChild.getLoopCycle();
	}
	
	public int getParentID() {
		return widgetChild.getParentID();
	}
	
	public int getRealID() {
		return widgetChild.getRealID();
	}
	
	public int getRealParentID() {
		return widgetChild.getRealParentID();
	}
	
	public Rectangle getRectangle() {
		return widgetChild.getRectangle();
	}
	
	public int getRelativeX() {
		return widgetChild.getRelativeX();
	}
	
	public int getRelativeY() {
		return widgetChild.getRelativeY();
	}
	
	public int getScrollMax() {
		return widgetChild.getScrollMax();
	}
	
	public int getScrollX() {
		return widgetChild.getScrollX();
	}
	
	public int getScrollY() {
		return widgetChild.getScrollY();
	}
	
	public String getSelectedAction() {
		return widgetChild.getSelectedAction();
	}
	
	public int getSequenceId() {
		return widgetChild.getSpriteId();
	}
	
	public int getSequenceIndex() {
		return widgetChild.getSpriteId();
	}
	
	public String getText() {
		return widgetChild.getText();
	}
	
	public int getTextColor() {
		return widgetChild.getTextColor();
	}
	
	public String getTooltip() {
		return widgetChild.getTooltip();
	}
	
	public int getType() {
		return widgetChild.getType();
	}
	
	public int getWidth() {
		return widgetChild.getWidth();
	}
	
	public int getX() {
		return widgetChild.getX();
	}
	
	public int getY() {
		return widgetChild.getY();
	}
	
	public boolean hasAction(String action) {
		return widgetChild.hasAction(action);
	}
	
	public boolean hasActionExact(String action) {
		String[] actions = getActions();
		if(actions == null) return false;
		for(String a : actions) if(a.equals(action)) return true;
		return false;
	}
	
	public int hashCode() {
		return widgetChild.hashCode();
	}
	
	public boolean interact() {
		return widgetChild.interact();
	}
	
	public boolean interact(String action) {
		return widgetChild.interact(action);
	}
	
	public boolean interact(Filter<String> filter) {
		return widgetChild.interact(filter::match);
	}
	
	public boolean isHidden() {
		return widgetChild.isHidden();
	}
	
	public boolean isVisible() {
		return widgetChild.isVisible();
	}
	
	@Override
	public String toString() {
		return widgetChild.toString();
	}
}
