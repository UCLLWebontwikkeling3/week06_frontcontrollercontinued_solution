package controller;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hashing {
	
	private static String salt;

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(hashing("banana"));
	}
	
	public static String hashing(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest hash = MessageDigest.getInstance("SHA-512");
		hash.reset();
		
		SecureRandom random = new SecureRandom();
		byte seed[] = random.generateSeed(20);
		salt = new BigInteger(1, seed).toString(16);
		System.out.println(salt.length());
		hash.update(salt.getBytes("UTF-8"));
		
		hash.update(password.getBytes("UTF-8"));
		String hashedPassword = new BigInteger(1, hash.digest()).toString(16);
		System.out.println(hashedPassword.length());
		return hashedPassword;
	}
	
	private static String hasAgain(String password, String salt) {
		return null;
	}

}
