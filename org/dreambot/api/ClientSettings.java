package org.dreambot.api;

public class ClientSettings {
	// TODO: IMPLEMENT CLIENT SETTINGS PLZ EC?
	public static boolean isDisplayFps() { 
		return net.eternalclient.api.Client.getRSClient().getPreferences().getDisplayFps();
	 }
	
	public static void setDisplayFps(boolean display) {
		net.eternalclient.api.Client.getRSClient().getPreferences().setDisplayFps(display);
	}
	
//	public static boolean isLoginMusicDisabled() {
//
//	}
//
//	public static void setLoginMusicDisabled(boolean disabled) {
//
//	}
//
//	public static java.lang.String getSavedUsername() {
//
//	}
//
//	public static void setSavedUsername(java.lang.String username) {
//
//	}
	
	public static boolean isHideUsername() {
		return net.eternalclient.api.Client.getRSClient().getPreferences().getHideUsername();
	}
	
	public static void setHideUsername(boolean hide) {
		net.eternalclient.api.Client.getRSClient().getPreferences().setHideUsername(hide);
	}
	
//	public static boolean isRememberUsername() {
//
//	}
//
//	public static int getResizableValue() {
//
//	}
//
//	public static boolean isResizableActive() {
//
//	}
//
//	public static java.util.Map<java.lang.Integer,java.lang.Integer> getClientParameters() {
//
//	}
	
	public static void addStoredAuth(java.lang.String username, int auth) { 
		
	}
	
	public static boolean areRoofsHidden() {
		return net.eternalclient.api.Client.getRSClient().getPreferences().getRoofsHidden();
	}
	
	public static boolean toggleRoofs(boolean on) {
		net.eternalclient.api.Client.getRSClient().getPreferences().setRoofsHidden(!on);
		return true;
	}
	
//	public static boolean closeSettingsInterface() {
//
//	}
//
//	public static boolean isOpen() {
//
//	}
//
//	public static boolean toggleGameAudio(boolean on) {
//
//	}
//
//	public static boolean toggleResizable(boolean on) {
//
//	}
//
//	public static int getClientBrightness() {
//
//	}
//
//	public static boolean setClientBrightness(int brightness) {
//
//	}
//
//	public static void clearLayoutPreferences() {
//
//	}
//
//	public static boolean setClientLayout(org.dreambot.api.data.ClientLayout layout) {
//
//	}
//
//	public static org.dreambot.api.data.ClientLayout getClientLayout() {
//
//	}
//
//	public static boolean isGameAudioOn() {
//
//	}
//
//	public static boolean toggleAcceptAid(boolean on) {
//
//	}

	public static boolean isAcceptAidEnabled() {
		return net.eternalclient.api.Client.isAcceptAidActive();
	}

//	public static boolean toggleDataOrbs(boolean on) {
//
//	}
//
//	public static boolean areDataOrbsEnabled() {
//
//	}
//
//	public static boolean toggleLevelUpInterface(boolean on) {
//
//	}
//
//	public static boolean isLevelUpInterfaceEnabled() {
//
//	}
//
//	public static boolean toggleEscInterfaceClosing(boolean on) {
//
//	}
//
//	public static boolean isEscInterfaceClosingEnabled() {
//
//	}
//
//	public static boolean isShiftClickDroppingEnabled() {
//
//	}
//
//	public static boolean toggleShiftClickDropping(boolean on) {
//
//	}
//
//	public static boolean toggleScrollToZoom(boolean on) {
//
//	}
//
//	public static boolean isScrollToZoomEnabled() {
//
//	}
//
//	public static boolean canUseMiddleMouseForCamera() {
//
//	}
//
//	public static boolean toggleChatEffects(boolean on) {
//
//	}
//
//	public static boolean areChatEffectsEnabled() {
//
//	}
//
//	public static boolean toggleTransparentChatbox(boolean on) {
//
//	}
//
//	public static boolean isTransparentChatboxEnabled() {
//
//	}
//
//	public static boolean toggleClickThroughChatbox(boolean on) {
//
//	}
//
//	public static boolean isClickThroughChatboxEnabled() {
//
//	}
//
//	public static boolean toggleItemPilesOnDeath(boolean on) {
//
//	}
//
//	public static boolean areItemPilesOnDeathEnabled() {
//
//	}
//
//	public static boolean toggleMoveFollowerOptionsLower(boolean on) {
//
//	}
//
//	public static boolean isMoveFollowerOptionsLowerEnabled() {
//
//	}
//
//	public static boolean toggleSellPriceWarning(boolean on) {
//
//	}
//
//	public static boolean isSellPriceWarningEnabled() {
//
//	}
//
//	public static boolean toggleFeroxExitWarning(boolean on) {
//
//	}
//
//	public static boolean isFeroxExitWarningEnabled() {
//
//	}
//
//	public static boolean toggleFeroxExitWarningOnHighRiskWorld(boolean on) {
//
//	}
//
//	public static boolean isFeroxExitWarningOnHighRiskWorldEnabled() {
//
//	}
//
//	public static boolean toggleBuyPriceWarning(boolean on) {
//
//	}
//
//	public static boolean isBuyPriceWarningEnabled() {
//
//	}
//
//	public static org.dreambot.api.data.ActionMode getPlayerAttackOptionsMode() {
//
//	}
//
//	public static boolean setPlayerAttackOptionsMode(org.dreambot.api.data.ActionMode mode) {
//
//	}
//
//	public static boolean setNPCAttackOptionsMode(org.dreambot.api.data.ActionMode mode) {
//
//	}
//
//	public static org.dreambot.api.data.ActionMode getNPCAttackOptionsMode() {
//
//	}
//
//	public static boolean areLootNotificationsEnabled() {
//
//	}
//
//	public static int getLootDropMinimumValue() {
//
//	}
//
//	public static boolean toggleLootNotifications(boolean on) {
//
//	}
//
//	public static boolean isSkullPreventionActive() {
//
//	}
//
//	public static boolean toggleSkullPrevention(boolean on) {
//
//	}
//
//	public static boolean restoreDefaultKeybinds() {
//
//	}
//
//	public static boolean toggleSetting(org.dreambot.api.ClientSettings.SettingsTab tab, java.lang.String settingLabel, org.dreambot.api.utilities.impl.Condition completedCondition) {
//
//	}
//
//	public static boolean setDefaultZoom() {
//
//	}
//
//	public static boolean isZoomingEnabled() {
//
//	}
//
//	public static boolean isTradeDelayEnabled() {
//
//	}
//
//	public static boolean toggleTradeDelay(boolean on) {
//
//	}
//
//	public static boolean isAmmoAutoEquipping() {
//
//	}
//
//	public static boolean toggleAmmoAutoEquipping(boolean on) {
//
//	}
//
//	public static boolean areRunesAutoPouching() {
//
//	}
//
//	public static boolean toggleRuneAutoPouching(boolean on) {
//
//	}
//
//	public static boolean areCollectionLogNotificationsEnabled() {
//
//	}
//
//	public static boolean areCollectionLogPopupsEnabled() {
//
//	}
//
//	public static boolean toggleCollectionLogNotifications(boolean on) {
//
//	}
//
//	public static boolean toggleCollectionLogPopups(boolean on) {
//
//	}
	
	public static int getMusicVolume() {
		return net.eternalclient.api.Client.getRSClient().getPreferences().getMusicVolume();
	}
	
	public static int getSoundEffectVolume() {
		return net.eternalclient.api.Client.getRSClient().getPreferences().getSoundEffectVolume();
	}
	
//	public static int getAreaVolume() {
//
//	}
//
//	public static double getBrightness() {
//
//	}
//
//	public static boolean isWorldHopConfirmationEnabled() {
//
//	}
//
//	public static boolean toggleWorldHopConfirmation(boolean enabled) {
//
//	}
//
//	public static boolean isMakeXDartsEnabled() {
//
//	}
//
//	public static boolean toggleMakeXDarts(boolean enabled) {
//
//	}
}
