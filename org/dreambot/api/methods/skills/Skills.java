package org.dreambot.api.methods.skills;

import net.eternalclient.api.wrappers.tabs.Tab;
import net.eternalclient.api.wrappers.tabs.Tabs;

import java.util.Arrays;

public class Skills {
	public static int getBoostedLevel(Skill skill) {
		return net.eternalclient.api.accessors.Skills.getBoostedLevels(skill.toEC());
	}
	
	public static int[] getBoostedLevels() {
		return Arrays.stream(Skill.values()).map(Skills::getBoostedLevel).mapToInt(Integer::intValue).toArray();
	}
	
	public static int[] getExperience() {
		return Arrays.stream(Skill.values()).map(Skills::getExperience).mapToInt(Integer::intValue).toArray();
	}
	
	public static int getExperience(Skill skill) {
		return net.eternalclient.api.accessors.Skills.getExperience(skill.toEC());
	}
	
	public static int getExperienceForLevel(int level) {
		return net.eternalclient.api.accessors.Skills.getExperienceAt(level);
	}
	
	public static int getExperienceForLevel(Skill skill) {
		return net.eternalclient.api.accessors.Skills.getExperienceToNextLevel(skill.toEC());
	}
	
	public static int[] getLevels() {
		return Arrays.stream(Skill.values()).map(Skills::getRealLevel).mapToInt(Integer::intValue).toArray();
	}
	
	public static int getRealLevel(Skill skill) {
		return net.eternalclient.api.accessors.Skills.getRealLevel(skill.toEC());
	}
	
	public static int getTotalLevel() {
		return net.eternalclient.api.accessors.Skills.getTotalLevel();
	}
	
	public static boolean open() {
		return Tabs.open(Tab.SKILL);
	}
}
