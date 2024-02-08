package org.dreambot.api.misc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hashing {
	public static String hashed(String str) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] encodedhash = digest.digest(str.getBytes(java.nio.charset.StandardCharsets.UTF_8));
			return bytesToHex(encodedhash);
		}
		catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static String bytesToHex(byte[] hash) {
		StringBuilder hexString = new StringBuilder(2 * hash.length);
		for(byte b : hash) {
			String hex = Integer.toHexString(0xff & b);
			if(hex.length() == 1) {
				hexString.append('0');
			}
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
