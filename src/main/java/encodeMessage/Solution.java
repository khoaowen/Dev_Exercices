package encodeMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Solution {

	public static void main(String args[]) {
		String MESSAGE = "%";

		// Write an action using System.out.println()
		// To debug: System.err.println("Debug messages...");

		System.out.println(Integer.toBinaryString('C'));
		System.out.println(Integer.toBinaryString('%'));
		System.out.println(convertToBit("C"));
		System.out.println(convertToBit("%"));

		System.out.println(encode(MESSAGE).equals("00 0 0 0 00 00 0 0 00 0 0 0")); // 0100101
		// System.err.println(convertToBlocs("00000", PREFIX.ZERO).computeValue());
		// System.err.println(convertToBlocs("0", PREFIX.ZERO).computeValue());
		// System.err.println(convertToBlocs("11111", PREFIX.ONE).computeValue());
		// System.err.println(convertToBlocs("1", PREFIX.ONE).computeValue());

	}

	public static String encode(String s) {
		String res = convertToBit(s);
		List<Bloc> blocs = extractBlocs(res);
		StringBuilder bd = new StringBuilder();
		for (int i = 0; i < blocs.size(); i++) {
			bd.append(blocs.get(i).computeValue());
			if (i < blocs.size() - 1) {
				bd.append(" ");
			}

		}
		return bd.toString();
	}

	public static List<Bloc> extractBlocs(String bits) {
		List<Bloc> blocs = new ArrayList<Bloc>();
		int counter = 0;
		char firstChar = bits.charAt(0);
		for (int i = 0; i < bits.length(); i++) {
			if (firstChar == bits.charAt(i)) {
				counter++;
			} else {
				blocs.add(new Bloc(Prefix.fromChar(firstChar), counter));
				firstChar = bits.charAt(i);
				counter = 1;
			}
			if (i == bits.length() - 1) {
				blocs.add(new Bloc(Prefix.fromChar(firstChar), counter));
			}
		}
		return blocs;
	}

	public static String convertToBit(String message) {
		// stringToBinary
		StringBuilder binary = new StringBuilder();
		char[] charArray = message.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			int c = charArray[i];
			binary.append(fill0For7Bits(Integer.toBinaryString(c)));
		}
		return binary.toString();
	}

	public static String fill0For7Bits(String bits) {
		StringBuilder bd = new StringBuilder();
		int missing = 7 - bits.length();
		while (missing > 0) {
			bd.append("0");
			missing--;
		}
		return bd.append(bits).toString();
	}

	public static Bloc convertToBlocs(String bits, Prefix prefix) {
		return new Bloc(prefix, bits.length());
	}

	public enum Prefix {
		ZERO("00 "), ONE("0 ");

		private final String value;

		Prefix(String val) {
			value = val;
		}

		public String getValue() {
			return value;
		}

		public static Prefix fromChar(char c) {
			if (c == '1') {
				return ONE;
			} else {
				return ZERO;
			}
		}
	}

	public static class Bloc {
		private final Prefix prefix;
		private final int length;

		Bloc(Prefix prefix, int length) {
			this.prefix = prefix;
			this.length = length;
		}

		public Prefix getPrefix() {
			return prefix;
		}

		public int getLength() {
			return length;
		}

		public String computeValue() {
			StringBuilder bd = new StringBuilder(prefix.getValue());
			for (int i = 0; i < length; i++) {
				bd.append("0");
			}
			return bd.toString();
		}
	}

}