package org.dreambot.api;

import net.eternalclient.api.accessors.GraphicsObjects;
import net.eternalclient.api.accessors.Projectiles;
import net.eternalclient.api.rs.RSClient;
import net.eternalclient.api.rs.RSCollisionMap;
import net.eternalclient.api.wrappers.interactives.GraphicsObject;
import net.eternalclient.api.wrappers.map.Map;
import net.eternalclient.api.wrappers.map.Tile;
import net.eternalclient.api.wrappers.projectile.Projectile;
import net.eternalclient.api.wrappers.walking.Walking;
import org.dreambot.api.data.GameState;

import javax.swing.*;
import java.awt.*;

public class Client {
	public static boolean gainFocus() {
		RSClient client = net.eternalclient.api.Client.getRSClient();
		Frame frame = (Frame)SwingUtilities.windowForComponent(client.getApplet());
		
		if(frame != null) {
			frame.requestFocus();
			return true;
		}
		
		return false;
	}
	
	public static Tile getBase() {
		return Map.getBase();
	}
	
	public static int getBaseX() {
		return Map.getBaseX();
	}
	
	public static int getBaseY() {
		return Map.getBaseX();
	}
	
	public static Canvas getCanvas() {
		 return net.eternalclient.api.Client.getRSClient().getCanvas();
	}
	
	public static RSCollisionMap[] getCollisionMaps() {
		return net.eternalclient.api.Client.getRSClient().getCollisionMaps();
	}
	
	public static Tile getDestination() {
		return (Tile)Walking.getDestination(); // TODO! Test cast
	}
	
	public static int getDestX() {
		return getDestination().getX();
	}
	
	public static int getDestY() {
		return getDestination().getY();
	}
	
	public static int getFPS() {
		return net.eternalclient.api.Client.getRSClient().getFPS();
	}
	
	public static int getForcedFPS() {
		return net.eternalclient.api.Client.getSettings().getFpsLimit();
	}
	
	public static int getGameCycle() {
		return net.eternalclient.api.Client.getRSClient().getGameCycle();
	}
	
	public static int getGameSocket() {
		return net.eternalclient.api.Client.getRSClient().getGameCycle();
	}
	
	public static GameState getGameState() {
		return GameState.valueOf(getGameStateId()); // TODO! Check id match
	}
	
	public static int getGameStateId() {
		return net.eternalclient.api.Client.getGameStateID();
	}
	
	public static int getGameTick() {
		return (int)net.eternalclient.api.Client.getGameTick();
	}
	
	public static java.util.List<GraphicsObject> getGraphicsObjects() {
		return GraphicsObjects.all();
	}
	
	public static int getLoginIndex() {
		return net.eternalclient.api.Client.getLoginIndex();
	}
	
	public static int getMapAngle() {
		return net.eternalclient.api.Client.getRSClient().getMapAngle();
	}
	
	public static int getMembershipLeft() {
		return net.eternalclient.api.Client.getRemainingMembershipDays();
	}
	
	public static int getMyPlayerIndex() {
		return net.eternalclient.api.Client.getRSClient().getLocalPlayerIndex();
	}
	
	public static String getPassword() {
		return net.eternalclient.api.Client.getRSClient().getPassword();
	}
	
	public static int getPlane() {
		return net.eternalclient.api.Client.getRSClient().getPlane();
	}
	
	public static java.util.List<Projectile> getProjectiles() {
		return Projectiles.all();
	}
	
	public static int getRunescapeFPS() {
		return net.eternalclient.api.Client.getRSClient().getFPS();
	}
	
	public static int[][][] getTileHeights() {
		return net.eternalclient.api.Client.getRSClient().getTileHeights();
	}
	
	public static byte[][][] getTileSettings() {
		return net.eternalclient.api.Client.getRSClient().getTileSettings();
	}
	
	public static String getUsername() {
		return net.eternalclient.api.Client.getRSClient().getUsername();
	}
	
	public static int getViewportHeight() {
		return net.eternalclient.api.Client.getRSClient().getViewportHeight();
	}
	
	public static int getViewportWidth() {
		return net.eternalclient.api.Client.getRSClient().getViewportWidth();
	}
	
	public static boolean hasFocus() {
		RSClient client = net.eternalclient.api.Client.getRSClient();
		Frame frame = (Frame)SwingUtilities.windowForComponent(client.getApplet());
		return frame != null && frame.hasFocus();
	}
	
	public static boolean isInCutscene() {
		return net.eternalclient.api.Client.isInCutscene();
	}
	
	public static boolean isLoggedIn() {
		return net.eternalclient.api.Client.isLoggedIn();
	}
	
	public static boolean isMembers() {
		return net.eternalclient.api.Client.hasMembership();
	}
	
	public static boolean isRenderingDisabled() {
		return !net.eternalclient.api.Client.getSettings().isRenderingEnabled();
	}
	
	public static boolean isWorldSelectorOpen() {
		return  net.eternalclient.api.Client.getRSClient().isWorldSelectOpen();
	}
	
	public static void setForcedFPS(int fps) {
		net.eternalclient.api.Client.getSettings().setFpsLimit(fps);
	}
	
	public static void setRenderingDisabled(boolean disabled) {
		net.eternalclient.api.Client.getSettings().setRenderingEnabled(!disabled);
	}
}
