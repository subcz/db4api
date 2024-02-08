package org.dreambot.api.wrappers.interactive;

import org.dreambot.api.interfaces.Identifiable;
import org.dreambot.api.interfaces.Locatable;

public class NPC extends Character implements Identifiable, Locatable {
	private final net.eternalclient.api.wrappers.interactives.NPC npc;
	
	public NPC(net.eternalclient.api.wrappers.interactives.NPC npc) {
		super(npc);
		
		this.npc = npc;
	}
	
	public net.eternalclient.api.wrappers.interactives.Entity toEC() {
		return npc;
	}
	
	public boolean equals(net.eternalclient.api.wrappers.interactives.NPC npc) {
		return this.npc.equals(npc);
	}
	
	public boolean equals(NPC npc) {
		return equals(npc.npc);
	}
	
	public String[] getActions() {
		return npc.getActions();
	}
	
	public int getID() {
		return npc.getID();
	}
	
	public int getIdleAnimation() {
		return npc.getStandAnimation();
	}
	
	public int getIndex() {
		return npc.getIndex();
	}
	
	public int getLevel() {
		return npc.getLevel();
	}
	
	public String getName() {
		return npc.getName();
	}
	
	public int getWalkingAnimation() {
		return npc.getWalkAnimation();
	}
	
	public int getSize() {
		return npc.getWidth();
	}
	
	public int getWidthScale() {
		return npc.getWidth();
	}
	
	public boolean hasAction(String... actions) {
		return npc.hasAction(actions);
	}
	
	public int hashCode() {
		return npc.hashCode();
	}
	
	@Override
	public String toString() {
		return npc.toString();
	}
}
