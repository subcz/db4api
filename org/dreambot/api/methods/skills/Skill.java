package org.dreambot.api.methods.skills;

import net.eternalclient.api.accessors.Skills;
import org.dreambot.api.misc.Formatting;

public enum Skill implements Comparable<Skill> {
	ATTACK(0),
	DEFENCE(1),
	STRENGTH(2),
	HITPOINTS(3),
	RANGED(4),
	PRAYER(5),
	MAGIC(6),
	COOKING(7),
	WOODCUTTING(8),
	FLETCHING(9),
	FISHING(10),
	FIREMAKING(11),
	CRAFTING(12),
	SMITHING(13),
	MINING(14),
	HERBLORE(15),
	AGILITY(16),
	THIEVING(17),
	SLAYER(18),
	FARMING(19),
	RUNECRAFTING(20),
	HUNTER(21),
	CONSTRUCTION(22);
	
	private final String name;
	private final int id;
	
	Skill(int id) {
		this.name = Formatting.pascalToRegular(name());
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public int getBoostedLevel() {
		return Skills.getBoostedLevels(toEC());
	}
	
	public int getExperience() {
		return Skills.getExperience(toEC());
	}
	
	public int getExperienceToLevel() {
		return Skills.getExperienceToNextLevel(toEC());
	}
	
	public int getLevel() {
		return Skills.getRealLevel(toEC());
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public net.eternalclient.api.wrappers.skill.Skill toEC() {
		return net.eternalclient.api.wrappers.skill.Skill.valueOf(name()); // TODO: Test
	}
}
