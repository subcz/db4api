package org.dreambot.api.wrappers.input;

import org.dreambot.api.utilities.Logger;

import java.util.Objects;

public enum FKeys {
	ESC,
	F1,
	F10,
	F11,
	F12,
	F2,
	F3,
	F4,
	F5,
	F6,
	F7,
	F8,
	F9,
	NONE,
	UNKNOWN;
	
	public net.eternalclient.api.wrappers.input.FKeys toEC() {
		try {
			return net.eternalclient.api.wrappers.input.FKeys.valueOf(name());
		}
		catch(IllegalArgumentException e) {
			Logger.log("FKEYS: Missing EC FKey for DreamBot FKey \"" + name() + "\".");
			return null;
		}
	}
	
	public static FKeys get(int keyValue) {
		return valueOf(net.eternalclient.api.wrappers.input.FKeys.get(keyValue));
	}
	
	public char getKeyChar() {
		return Objects.requireNonNull(toEC()).getKeyChar();
	}
	
	public int getKeyCode() {
		return Objects.requireNonNull(toEC()).getKeyCode();
	}
	
	public int getKeyValue() {
		return Objects.requireNonNull(toEC()).getKeyValue();
	}
	
	@Override
	public String toString() {
		return Objects.requireNonNull(toEC()).toString();
	}
	
	public static FKeys valueOf(net.eternalclient.api.wrappers.input.FKeys fkey) {
		for(FKeys f : values()) {
			if(f.name().equals(fkey.name())) return f;
		}
		Logger.log("FKEYS: Missing Dreambot FKey for EC FKey \"" + fkey + "\".");
		return null;
	}
}
