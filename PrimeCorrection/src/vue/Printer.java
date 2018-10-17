package vue;

import java.util.List;
import java.util.Map;

import model.LastDigit;
import model.Statistique;

public class Printer {

	private Map<LastDigit, Statistique> statistiques ;
	
	public Printer(Map<LastDigit, Statistique> statistiques) {
		this.statistiques = statistiques;
	}
	
	public void print() {
		printHeader();
		for (LastDigit chiffre : LastDigit.values()) {
			printLine(chiffre.value());
		}
		printFooter();
	
	}


	private void printLine(int chiffre) {
		List<Double> stats = statistiques.get(LastDigit.toLastDigit(chiffre)).getStats();
		System.out.printf("|    "+chiffre+"   | %.2f | %.2f | %.2f | %.2f |",
				stats.get(LastDigit.ONE.getPosition()),
				stats.get(LastDigit.THREE.getPosition()),
				stats.get(LastDigit.SEVEN.getPosition()),
				stats.get(LastDigit.NINE.getPosition())
				);
		System.out.println();
	}

	private void printFooter() {
		System.out.println("------------------------------------------");
	}

	private void printHeader() {
		printFooter();
		System.out.println("|From to |   1   |   3   |   7   |   9   |");
		printFooter();
	}
}
