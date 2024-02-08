package org.dreambot.api.methods.prayer;

import org.dreambot.api.misc.Formatting;
import org.dreambot.api.wrappers.widgets.WidgetChild;

public enum Prayer {
	THICK_SKIN(1),
	BURST_OF_STRENGTH(4),
	CLARITY_OF_THOUGHT(7),
	SHARP_EYE(8),
	MYSTIC_WILL(9),
	ROCK_SKIN(10),
	SUPERHUMAN_STRENGTH(13),
	IMPROVED_REFLEXES(16),
	RAPID_RESTORE(19),
	RAPID_HEAL(22),
	PROTECT_ITEM(25),
	HAWK_EYE(26),
	MYSTIC_LORE(27),
	STEEL_SKIN(28),
	ULTIMATE_STRENGTH(31),
	INCREDIBLE_REFLEXES(34),
	PROTECT_FROM_MAGIC(37),
	PROTECT_FROM_MISSILES(40),
	PROTECT_FROM_MELEE(43),
	EAGLE_EYE(44),
	MYSITC_MIGHT(45),
	RETRIBUTION(46),
	REDEMPTION(49),
	SMITE(52),
	PRESERVE(55),
	CHIVALRY(60),
	PIETY(70),
	RIGOUR(74),
	AUGURY(77);
	
	private final String name;
	private final int level;
	
	Prayer(int level) {
		this.name = Formatting.pascalToRegular(name());
		this.level = level;
	}
	
	public int getChildIndex() {
		return toEC().getWidgetInfo().getChildId();
	}
	
	public int getLevel() {
		return level;
	}
	
	public int getQuickPrayerChild() {
		return toEC().getQuickPrayerIndex();
	}
	
	public int getSetting() {
		return toEC().getVarbit();
	}
	
	public WidgetChild getWidgetChild() {
		net.eternalclient.api.wrappers.widgets.WidgetChild widget = toEC().getWidget();
		return widget != null ? new WidgetChild(widget) : null;
	}
	
	public int getWidgetIndex() {
		return toEC().getWidgetInfo().getId();
	}
	
	public net.eternalclient.api.wrappers.prayer.Prayer toEC() {
		return net.eternalclient.api.wrappers.prayer.Prayer.valueOf(name());
	}
	
	public static Prayer of(String name) {
		return valueOf(name);
	}
	
	public static Prayer valueOf(net.eternalclient.api.wrappers.prayer.Prayer prayer) {
		return valueOf(prayer.name());
	}
	
	@Override
	public String toString() {
		return name;
	}
}
