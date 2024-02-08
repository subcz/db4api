package org.dreambot.api.wrappers.interactive;

import org.dreambot.api.interfaces.Identifiable;
import org.dreambot.api.interfaces.Locatable;
import org.dreambot.api.methods.filter.Filter;
import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.map.Tile;

import java.awt.*;

public abstract class Entity implements Identifiable, Locatable {
	private final net.eternalclient.api.wrappers.interactives.Entity entity;
	
	public Entity(net.eternalclient.api.wrappers.interactives.Entity entity) {
		this.entity = entity;
	}
	
	public net.eternalclient.api.wrappers.interactives.Entity toEC() {
		return entity;
	}
	
	public boolean canReach() {
		return entity.canReach();
	}
	
	public double distance() {
		return entity.distance();
	}
	
	public double distance(net.eternalclient.api.wrappers.map.Tile tile) {
		return entity.distance(tile);
	}
	
	public double distance(Tile tile) {
		return distance(new net.eternalclient.api.wrappers.map.Tile(tile.getX(), tile.getY(), tile.getZ()));
	}
	
	public double distance(net.eternalclient.api.wrappers.interactives.Entity entity) {
		return entity.distance(entity);
	}
	
	public double distance(Entity entity) {
		return distance(entity.entity.getTile());
	}
	
	public boolean equals(Entity entity) {
		return this.entity.equals(entity.entity);
	}
	
	public String[] getActions() {
		return entity.getActions();
	}
	
	public Rectangle getBoundingBox() {
		return entity.getClickBox().getBounds();
	}
	
	public Point getCenterPoint() {
		Rectangle bounds = getBoundingBox();
		return new Point((int)Math.round(bounds.getCenterX()), (int)Math.round(bounds.getCenterY()));
	}
	
	public Point getClickablePoint() {
		return entity.getInteractPoint();
	}
	
	public String getLeftClickAction() {
		String[] actions = entity.getActions();
		return actions.length > 0 ? actions[0] : null;
	}
	
	public Model getModel() {
		return new Model(entity);
	}
	
	public String getName() {
		return entity.getName();
	}
	
	public int getRenderableHeight() {
		return entity.getHeight();
	}
	
	public Area getSurroundingArea(int radius) {
		return Area.genereteArea(radius, new Tile(entity.getTile()));
	}
	
	public Tile getTile() {
		return new Tile(entity.getTile());
	}
	
	public boolean hasAction(String... actions) {
		return entity.hasAction(actions);
	}
	
	public int hashCode() {
		return entity.hashCode();
	}
	
	public boolean interact() {
		return entity.interact();
	}
	
	public boolean interact(String action) {
		return entity.interact(action);
	}
	
	public boolean interact(Filter<String> action) {
		return entity.interact(action::match);
	}
	
	public boolean isOnScreen() {
		return entity.isOnScreen();
	}
	
	public double walkingDistance(Tile tile) {
		return tile.walkingDistance(new Tile(entity.getTile()));
	}
}
