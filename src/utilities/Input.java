package utilities;

import java.util.Scanner;

public class Input {
	private static Scanner keyboard = new Scanner(System.in);
	/**
	 * Validate input until user enters an integer within the given range.
	 * 
	 * @param min  lowest acceptable number
	 * @param max  highest acceptable number
	 * @return  number within the range
	 */
	public static int validInt(int min, int max) {
		int numInput;
		do {
			while (!keyboard.hasNextInt()) {
				keyboard.nextLine();
			}
			numInput = keyboard.nextInt();
			keyboard.nextLine();
		} while (numInput < min || numInput > max);
		return numInput;
	}

	/**
	 * Validate input until user enters a String up to a maximum length.
	 * 
	 * @param max  the longest the String can be
	 * @param keyboard  the keyboard
	 * @return  the String entered
	 */
	public static String validString(int max) {
		String textInput;
		do {
			textInput = keyboard.nextLine();
		} while (textInput.isEmpty() || textInput.length() > max);
		return textInput;
	}
}