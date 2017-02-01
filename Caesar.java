package cipher;

import java.io.*;
import java.util.Set;
import java.util.HashSet;

public class Caesar {
    
	/**
	 * A helper function that shifts letters.
	 * @param c A character. 
	 * @param shift An integer that makes the shift. For example, if the shift is 2, 
	 *              then A becomes C, B becomes D, and so on. 
	 * @return The shifted character.
	 */
    private char shiftCharacter(char c, int shift) {
	    if (c >= 'A' && c <= 'Z') {
		    return (char) ('A' + (c - 'A' + shift) % 26);
	    } else {
	        return (char) ('a' + (c - 'a' + shift) % 26);
	    }
    }
	
	/**
	 * Enciphers the message, using the shift. Allow the shift to be any integer value; 
	 * use the modulo operator to cut it down to a value between 0 and 25.
	 * @param shift Any integer value.
	 * @param plainText The original text that hasn't been enciphered. 
	 * @return The ciphered text which was enciphered from the plainText using the shift. 
	 */
	public String encipher(int shift, String plainText) {
		String cipheredText = "";
		for (int i = 0; i < plainText.length(); i++) {
			char a = plainText.charAt(i);
			if (Character.isLetter(a)) {
			    a = shiftCharacter(a, shift);
			}
			cipheredText += a;
		}
		return cipheredText;
	}
	
	/**
	 * Given any message enciphered using a Caesar cipher, decipher it and return the 
	 * deciphered message.
	 * @param cipheredText The text that has been enciphered.
	 * @return The text that is correctly deciphered . 
	 */
	public String decipher(String cipheredText) {
		Set<String> wordList = new HashSet<String>();
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader("wordsEn.txt"));
			String line = reader.readLine();
			while (line != null) {
				wordList.add(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		double maxRatio = 0;
		String decipheredText = "";
		// A correctly deciphered message should consist of as many English words in the "wordsEn.txt"
		// file as possible. Try each possible shift to see which one can get the most words right.
		for (int shift = 0; shift < 26; shift++) {
			String text = "";
			for (int i = 0; i < cipheredText.length(); i++) {
				char b = cipheredText.charAt(i);
				if (Character.isLetter(b)) {
					b = shiftCharacter(b, shift);
				}
				text += b;
			}
			String[] decipheredWords = text.replaceAll("[^A-Za-z]", " ").split(" ");
			int countTrue = 0;
			int countFalse = 0;
			for (String word: decipheredWords) {
				if (wordList.contains(word.toLowerCase())) {
					countTrue += 1;
				} else {
					countFalse += 1;
				}
			}
			double ratio = (double) countTrue / (countTrue + countFalse);
			if (ratio > maxRatio) {
				decipheredText = text;
				maxRatio = ratio;
			}
		}
		return decipheredText;
	}
}
