package org.dreambot.api.data;

import java.util.Arrays;

public enum GameState {
	CRASHED(-1),
	ENTER_AUTH(11),
	GAME_LOADING(5),
	HOPPING(-1),
	INITIAL_SPLASH_SCREEN(6),
	LOADING(-1),
	LOGGED_IN(10),
	LOGGING_IN(3),
	LOGIN_SCREEN(0),
	NULL(-1);
	
	private final int id;
	
	GameState(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public static GameState valueOf(int id) {
		for(GameState state : GameState.values()) {
			if(state.id == id) return state;
		}
		return null;
	}
}
