package org.dreambot.api.wrappers.interactive;

import org.dreambot.api.interfaces.Identifiable;
import org.dreambot.api.interfaces.Locatable;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.util.Direction;

import java.util.List;
import java.util.stream.Collectors;

public class GameObject extends Entity implements Identifiable, Locatable {
	private final net.eternalclient.api.wrappers.interactives.GameObject gameObject;
	
	public GameObject(net.eternalclient.api.wrappers.interactives.GameObject gameObject) {
		super(gameObject);
		
		this.gameObject = gameObject;
	}
	
	public net.eternalclient.api.wrappers.interactives.GameObject toEC() {
		return gameObject;
	}
	
	public boolean canReach(Tile tile) {
		return gameObject.canReach(tile.toEC());
	}
	
	public double distance() {
		return gameObject.distance();
	}
	
	public double distance(Tile tile) {
		return gameObject.distance(tile.toEC());
	}
	
	public double distance(Entity entity) {
		return gameObject.distance(entity.toEC());
	}
	
	public boolean equals(net.eternalclient.api.wrappers.interactives.GameObject gameObject) {
		return this.gameObject.equals(gameObject);
	}
	
	public boolean equals(GameObject gameObject) {
		return equals(gameObject.gameObject);
	}
	
	public String[] getActions() {
		return gameObject.getActions();
	}
	
	public int getHeight() {
		return gameObject.getHeight();
	}
	
	public int getID() {
		return gameObject.getID();
	}
	
	public int getLocalX() {
		return gameObject.getLocalPoint().getX();
	}
	
	public int getLocalY() {
		return gameObject.getLocalPoint().getY();
	}
	
	public Model getModel() {
		return new Model(gameObject);
	}
	
	public String getName() {
		return gameObject.getName();
	}
	
	public List<Tile> getObjectTiles() {
		return gameObject.getTiles()
				.stream()
				.map(Tile::new)
				.collect(Collectors.toList());
	}
	
	public int getOrientation() {
		return Direction.valueOf(gameObject.getOrientation()).getId();
	}
	
	public int getPlane() {
		return gameObject.getPlane();
	}
	
	public Tile getTile() {
		return new Tile(gameObject.getTile());
	}
	
	public int getWidth() {
		return gameObject.getWidth();
	}
	
	public int getX() {
		return gameObject.getX();
	}
	
	public int getY() {
		return gameObject.getY();
	}
	
	public int getZ() {
		return gameObject.getPlane();
	}
	
	public boolean hasAction(String... actions) {
		return gameObject.hasAction(actions);
	}
	
	public int hashCode() {
		return gameObject.hashCode();
	}
	
	@Override
	public String toString() {
		return gameObject.toString();
	}
}
