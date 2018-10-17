package model;

import java.util.HashMap;
import java.util.Map;

public class Rule {
	
	private final Map<LastDigit,Statistique> statistiques = new HashMap<>();

	public void updateStatistique(LastDigit currentDigit, LastDigit previousDigit) {
		Statistique aStat = statistiques().getOrDefault(previousDigit, new Statistique());
		aStat.incrementFollowing(currentDigit);
		statistiques().put(previousDigit, aStat);
	}

	public Map<LastDigit,Statistique> statistiques() {
		return statistiques;
	}
	
}