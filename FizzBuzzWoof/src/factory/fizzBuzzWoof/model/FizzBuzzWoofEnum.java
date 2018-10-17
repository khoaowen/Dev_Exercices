package factory.fizzBuzzWoof.model;

import java.util.Arrays;

/**
 * Enum which represents the different transformations
 *
 */
public enum FizzBuzzWoofEnum {
	/**
	 * Transformer for value 3
	 */
	FIZZ(3,"Fizz"),
	/**
	 * Transformer for value 5
	 */
	BUZZ(5,"Buzz"),
	/**
	 * Transformer for value 7
	 */
	WOOF(7,"Woof"),
	/**
	 * Transformer for value 0
	 */
	ASTERISK(0,"*");
	
	private final int value;
	private final String label;
	
	private FizzBuzzWoofEnum(int value, String label) {
		this.value = value;
		this.label=label;
	}

	public String getLabel() {
		return label;
	}

	public int getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param integer
	 * @return {@code null} if integer is not recognized by FizzBuzzWoofEnum
	 */
	public static FizzBuzzWoofEnum fromInt(int integer) {
		return Arrays.stream(FizzBuzzWoofEnum.values()).filter(e -> e.value==integer).findAny().orElse(null);
	}
}
