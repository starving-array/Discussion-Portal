package com.socialapp.User.helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertHash {

	private String input;
	
	public ConvertHash(String input) {
		this.input = input;
	}

	public String getHash(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hashBytes = digest.digest(input.getBytes());
			StringBuilder hexString = new StringBuilder();

			for (byte b : hashBytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
