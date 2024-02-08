package org.dreambot.api.misc;

import java.util.Locale;

public class Formatting {
	public static String pascalToRegular(String str) {
		StringBuilder reg = new StringBuilder();
		
		boolean cap = true;
		for(char c : str.toCharArray()) {
			if(c == '_') {
				reg.append(" ");
				cap = true;
			}
			else if(c == '(') {
				reg.append(c);
				cap = true;
			}
			else if(cap) {
				reg.append(String.valueOf(c).toUpperCase(Locale.ENGLISH));
				cap = false;
			}
			else {
				reg.append(Character.toLowerCase(c));
			}
		}
		
		return reg.toString();
	}
}
