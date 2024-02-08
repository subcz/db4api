package org.dreambot.api.input;

import org.dreambot.api.utilities.impl.Condition;

import java.awt.event.KeyEvent;
import java.security.Key;

public class Keyboard {
	public static void pressEsc() {
		net.eternalclient.api.wrappers.input.Keyboard.pressEscape();
	}
	
	public static boolean type(Object message) {
		net.eternalclient.api.wrappers.input.Keyboard.type(message.toString(), true);
		return true;
	}
	
	public static boolean type(Object message, boolean enter) {
		net.eternalclient.api.wrappers.input.Keyboard.type(message.toString(), enter);
		return true;
	}
	
	public static boolean type(Object message, boolean enter, boolean makeMistakes) {
		return type(message, enter);
	}
	
}
