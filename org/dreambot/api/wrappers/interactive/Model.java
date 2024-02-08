package org.dreambot.api.wrappers.interactive;

import net.eternalclient.api.interfaces.Interactable;
import net.eternalclient.api.rs.RSModel;

import java.awt.*;

public class Model {
	private final Interactable interactable;
	
	public Model(Interactable interactable) {
		this.interactable = interactable;
	}
	
	public Shape getHullBounds() {
		return interactable.getConvexHullOnScreen();
	}
}
