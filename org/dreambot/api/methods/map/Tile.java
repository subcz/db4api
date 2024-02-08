package org.dreambot.api.methods.map;


import net.eternalclient.api.utilities.math.Calculations;
import net.eternalclient.api.wrappers.map.Area;
import org.dreambot.api.wrappers.interactive.Entity;

import java.awt.*;

public class Tile {
	private net.eternalclient.api.wrappers.map.Tile tile;
	
	public Tile(int x, int y, int z) {
		this.tile = new net.eternalclient.api.wrappers.map.Tile(x, y, z);
	}
	
	public Tile(int x, int y) {
		this(x, y, 0);
	}
	
	public Tile(net.eternalclient.api.wrappers.map.Tile tile) {
		this.tile = tile;
	}
	
	public net.eternalclient.api.wrappers.map.Tile toEC() {
		return tile;
	}
	
	public double distance() {
		return tile.distance();
	}
	
	public double distance(Tile tile) {
		return tile.distance(tile);
	}
	
	public double distance(Entity entity) {
		Tile t = entity.getTile();
		return tile.distance(new net.eternalclient.api.wrappers.map.Tile(t.getX(), t.getY(), t.getZ()));
	}
	
	public boolean equals(Tile tile) {
		return this.tile.equals(tile.tile);
	}
	
	public Area getArea(int radius) {
		return tile.getSurroundingArea(radius);
	}
	
	public int getGridX() {
		return tile.getGridX();
	}
	
	public int getGridY() {
		return tile.getGridY();
	}
	
	public Polygon getPolygon() {
		return tile.getPolygon();
	}
	
	public Tile getRandomizedTile(int deviation) {
		int mean = 2;
		int dx = (int)Math.round(Calculations.nextGaussianRandom(mean, deviation));
		int dy = (int)Math.round(Calculations.nextGaussianRandom(mean, deviation));
		return new Tile(tile.getX() + dx, tile.getY() + dy, tile.getPlane());
	}
	
	public Tile getRandomizedTile() {
		return getRandomizedTile(1);
	}
	
	public int getX() {
		return tile.getX();
	}
	
	public int getY() {
		return tile.getY();
	}
	
	public int getZ() {
		return tile.getPlane();
	}
	
	public void setX(int x) {
		 tile = new net.eternalclient.api.wrappers.map.Tile(x, tile.getY(), tile.getPlane());
	}
	
	public void setY(int y) {
		tile = new net.eternalclient.api.wrappers.map.Tile(tile.getX(), y, tile.getPlane());
	}
	
	public void setZ(int z) {
		tile = new net.eternalclient.api.wrappers.map.Tile(tile.getX(), tile.getY(), z);
	}
	
	public int hashCode() {
		return tile.hashCode();
	}
	
	@Override
	public String toString() {
		return tile.toString();
	}
	
	public Tile translate(int x, int y) {
		tile.translate(x, y);
		return this;
	}
	
	public Tile translate(Tile tile) {
		tile.translate(tile.getX(), tile.getY());
		return this;
	}
	
	public double walkingDistance(Tile tile) {
		return tile.walkingDistance(tile);
	}
}
