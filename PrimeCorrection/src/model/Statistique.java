package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Statistique {
	
	private int total=0;

	private static class Compteur {
		private int value = 0;
		
		public void inc()  {
			value++;
		}
		
		public int getValue() {
			return value;
		}
		@Override
		public String toString() {
			return Integer.toString(value);
		}
		
	}
	
	private Map<LastDigit, Compteur> countFollowing = new HashMap<>();
	
	/**
	 * Increment the counter of the {@code lastDigit} which follows a given prime number
	 * @param lastDigit 
	 */
	public void incrementFollowing(LastDigit lastDigit) {
		Compteur cpt = countFollowing.getOrDefault(lastDigit, new Compteur());
		cpt.inc();
		countFollowing.put(lastDigit, cpt);
		total++;
	}
	
	/**
	 * 
	 * @return the percentage of each last digit which follows a prime number
	 */
	public List<Double> getStats() {
		return Arrays.stream(LastDigit.values())
				.mapToDouble(digit -> countFollowing.get(digit).getValue() / (double) total * 100)
				.boxed().collect(Collectors.toList());
	}
	
}
