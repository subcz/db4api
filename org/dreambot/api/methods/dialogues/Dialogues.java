package org.dreambot.api.methods.dialogues;

import java.util.Arrays;

public class Dialogues {
	public static boolean areOptionsAvailable() {
		return !net.eternalclient.api.accessors.Dialogues.getOptionsList().isEmpty();
	}
	
	public static boolean canContinue() {
		return net.eternalclient.api.accessors.Dialogues.canContinue();
	}
	
	public static boolean canEnterInput() {
		return net.eternalclient.api.accessors.Dialogues.canEnterInput();
	}
	
	public static boolean chooseFirstOption(String... options) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(str -> Arrays.asList(options).contains(str));
	}
	
	public static boolean chooseFirstOptionContaining(String... options) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(str -> {
			for(String option : options) if(str.contains(option)) return true;
			return false;
		});
	}
	
	public static boolean chooseOption(int optionIndex) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(optionIndex);
	}
	
	public static boolean chooseOption(String option) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(option);
	}
	
	public static boolean clickContinue() {
		return net.eternalclient.api.accessors.Dialogues.continueDialogue();
	}
	
	public static boolean clickOption(int optionIndex) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(optionIndex);
	}
	
	public static boolean clickOption(String option) {
		return net.eternalclient.api.accessors.Dialogues.clickOption(option);
	}
	
	public static boolean continueDialogue() {
		return net.eternalclient.api.accessors.Dialogues.continueDialogue();
	}
	
	public static String getNPCDialogue() {
		return net.eternalclient.api.accessors.Dialogues.getNPCDialogue();
	}
	
	public static int getOptionIndex(String option) {
		return net.eternalclient.api.accessors.Dialogues.getOptionIndex(option);
	}
	
	public static int getOptionIndexContaining(String option) {
		return net.eternalclient.api.accessors.Dialogues.getOptionIndexContaining(option);
	}
	
	public static String[] getOptions() {
		return net.eternalclient.api.accessors.Dialogues.getOptions();
	}
	
	public static boolean inDialogue() {
		return net.eternalclient.api.accessors.Dialogues.inDialogue();
	}
	
	public static boolean isProcessing() {
		return net.eternalclient.api.accessors.Dialogues.isProcessing();
	}
	
	public static boolean spaceToContinue() {
		return net.eternalclient.api.accessors.Dialogues.continueDialogue();
	}
	
	public static boolean typeOption(int optionIndex) {
		return net.eternalclient.api.accessors.Dialogues.typeOption(optionIndex);
	}
	
	public static boolean typeOption(String option) {
		return net.eternalclient.api.accessors.Dialogues.typeOption(option);
	}
}
