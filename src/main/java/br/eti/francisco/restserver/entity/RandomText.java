package br.eti.francisco.restserver.entity;

import java.util.Random;

public class RandomText {
	
	private static final String CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.~";
	
	public static String getRandom(int size){
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < size; i++) {
			Random random = new Random();
			int v = random.nextInt(CHARS.length());
			result.append(CHARS.charAt(v));
		}
		return result.toString();
	}

}
