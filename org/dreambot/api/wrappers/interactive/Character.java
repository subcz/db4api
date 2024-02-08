package org.dreambot.api.wrappers.interactive;

import net.eternalclient.api.utilities.Log;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.wrappers.interactive.util.Direction;

public abstract class Character extends Entity {
	private final net.eternalclient.api.wrappers.interactives.Character character;
	
	public Character(net.eternalclient.api.wrappers.interactives.Character character) {
		super(character);
		
		this.character = character;
	}
	
	public net.eternalclient.api.wrappers.interactives.Entity toEC() {
		return character;
	}
	
	public boolean equals(net.eternalclient.api.wrappers.interactives.Character character) {
		return this.character.equals(character);
	}
	
	public boolean equals(Character character) {
		return equals(character.character);
	}
	
	public int getAnimation() {
		return character.getAnimation();
	}
	
	public Character getCharacterInteractingWithMe() {
		return ECtoDB(character.getTargetedBy(true));
	}
	
	public Direction getFacingDirection() {
		return Direction.valueOf(character.getOrientation());
	}
	
	public int getGridX() {
		return character.getGridX();
	}
	
	public int getGridY() {
		return character.getGridY();
	}
	
	public int getHealthPercent() {
		return character.getHealthPercent();
	}
	
	public int getIndex() {
		return character.getIndex();
	}
	
	public Character getInteractingCharacter() {
		return ECtoDB(character.getTarget());
	}
	
	public int getInteractingIndex() {
		return character.getTargetIndex();
	}
	
	public int getOrientation() {
		return Direction.valueOf(character.getOrientation()).getId();
	}
	
	public int getRenderableHeight() {
		return character.getHeight();
	}
	
	public Tile getServerTile() {
		return new Tile(character.getServerTile());
	}
	
	public int getSpotAnimation() {
		return character.getSpotAnimation();
	}
	
	public int getStandAnimation() {
		return character.getStandAnimation();
	}
	
	public int getWalkAnimation() {
		return character.getWalkAnimation();
	}
	
	public int getX() {
		return character.getX();
	}
	
	public int getY() {
		return character.getY();
	}
	
	public int getZ() {
		return character.getPlane();
	}
	
	public int hashCode() {
		return character.hashCode();
	}
	
	public boolean isAnimating() {
		return character.isAnimating();
	}
	
	public boolean isHealthBarVisible() {
		return character.isHealthBarVisible();
	}
	
	public boolean isInCombat() {
		return character.isInCombat();
	}
	
	public boolean isInteractedWith() {
		return character.getTargetedBy(true) != null;
	}
	
	public boolean isInteracting(Character character) {
		if(character instanceof NPC) {
			return this.character.isInteractingWith((net.eternalclient.api.wrappers.interactives.NPC)character.toEC());
		}
		else if(character instanceof Player) {
			return this.character.isInteractingWith((net.eternalclient.api.wrappers.interactives.Player)character.toEC());
		}
		else {
			return false;
		}
	}
	
	public boolean isMoving() {
		return character.isMoving();
	}
	
	public boolean isStandingStill() {
		return character.isStandingStill();
	}
	
	private Character ECtoDB(net.eternalclient.api.wrappers.interactives.Character ecChar) {
		if(ecChar instanceof net.eternalclient.api.wrappers.interactives.NPC) {
			return new NPC((net.eternalclient.api.wrappers.interactives.NPC)ecChar);
		}
		else if(ecChar instanceof net.eternalclient.api.wrappers.interactives.Player) {
			return new Player((net.eternalclient.api.wrappers.interactives.Player)ecChar);
		}
		else {
			Log.info("DREAMBOT CHARACTER: Unknown EC character type in getCharacterInteractingWithMe() = " + ecChar.getClass());
			return null;
		}
	}
}
