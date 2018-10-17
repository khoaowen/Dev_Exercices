package model;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public enum LastDigit {

	ONE(1), 
	THREE(3), 
	SEVEN(7), 
	NINE(9);

	/**
	 * The real value of digit
	 */
	private final int value;

	private LastDigit(int value) {
		this.value=value;
	}

	public int getPosition() {
		return ordinal();
	}
	
	/**
	 * Convert an int to the enum
	 * @param i the int to be converted to digit
	 * @return
	 */
	public static LastDigit toLastDigit (int i) {
		return Arrays.stream(values()).filter(p-> p.value() == i).findAny().orElseThrow(() -> new RuntimeException("Unrecognized prime: " + i));
	}

	/**
	 * Convert an int to the prime number
	 * @param i the int to be converted to prime number
	 * @return
	 */
	public static LastDigit toPrimeNumberSwitchCase (int i) {
		switch (i) {
		case 1:
			return ONE;
		case 3:
			return THREE;
		case 7:
			return SEVEN;
		case 9:
			return NINE;
		default:
			Logger.getLogger("LastDigit").log(Level.SEVERE, "Prime number is not handled: " + i);
			return null;
		}
	}

	public int value() {
		return value;
	}
}
