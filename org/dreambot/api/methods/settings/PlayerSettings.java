package org.dreambot.api.methods.settings;

public class PlayerSettings {
	public static int getBitValue(int id) {
		return net.eternalclient.api.accessors.PlayerSettings.getBitValue(id);
	}
	
	public static int getCleanedConfig(int id, int and) {
		return getConfig(id) & and;
	}
	
	public static int getConfig(int id) {
		return net.eternalclient.api.accessors.PlayerSettings.getConfig(id);
	}
}
