package org.dreambot.api.methods.map;

import org.dreambot.api.wrappers.interactive.Entity;

import java.awt.*;
import java.util.Arrays;

public class Area {
	private net.eternalclient.api.wrappers.map.Area area;
	
	public Area(int x1, int y1, int x2, int y2, int z) {
		this.area = new net.eternalclient.api.wrappers.map.Area(x1, y1, x2, y2, z);
	}
	
	public Area(int x1, int y1, int x2, int y2) {
		this(x1, y1, x2, y2, 0);
	}
	
	public Area(Tile... tiles) {
		net.eternalclient.api.wrappers.map.Tile[] ecTiles = Arrays.stream(tiles)
				.map(tile -> new net.eternalclient.api.wrappers.map.Tile(tile.getX(), tile.getY(), tile.getZ()))
				.toArray(net.eternalclient.api.wrappers.map.Tile[]::new);
		this.area = new net.eternalclient.api.wrappers.map.Area(ecTiles);
	}
	
	public Area(Tile northeastTile, Tile southwestTile) {
		this.area = new net.eternalclient.api.wrappers.map.Area(
				new net.eternalclient.api.wrappers.map.Tile(northeastTile.getX(), northeastTile.getY(), northeastTile.getZ()),
				new net.eternalclient.api.wrappers.map.Tile(southwestTile.getX(), southwestTile.getY(), southwestTile.getZ())
		);
	}
	
	public Area(net.eternalclient.api.wrappers.map.Area area) {
		this.area = area;
	}
	
	public boolean contains(int x, int y) {
		return area.contains(x, y);
	}
	
	public boolean contains(Tile tile) {
		return area.contains(tile.getX(), tile.getY());
	}
	
	public boolean contains(Entity entity) {
		return area.contains(entity.getX(), entity.getY());
	}
	
	public static Area genereteArea(int radius, Tile center) {
		net.eternalclient.api.wrappers.map.Tile ecCenter = new net.eternalclient.api.wrappers.map.Tile(
				center.getX(), center.getY(), center.getZ()
		);
		return new Area(new net.eternalclient.api.wrappers.map.Area(ecCenter, radius));
	}
	
	public Tile getCenter() {
		return new Tile(area.getCenter());
	}
	
	public Tile getNearestTile(Entity entity) {
		return new Tile(area.getNearestTile(entity.toEC()));
	}
	
	public Polygon getPolygonArea() {
		return area.getPolygon();
	}
	
	public Tile getRandomTile() {
		return new Tile(area.getRandomTile());
	}
	
	public Tile getTile() {
		return getCenter();
	}
	
	public Tile[] getTiles() {
		return area.getTiles()
				.stream()
				.map(Tile::new)
				.toArray(Tile[]::new);
	}
	
	public void setZ(int plane) {
		area.setPlane(plane);
	}
}
