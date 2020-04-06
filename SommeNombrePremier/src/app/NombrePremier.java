package app;

public class NombrePremier {

	public static int calculerSommeDesPremiers(int nombreDesPremiers) {
		if (nombreDesPremiers < 0) {
			throw new IllegalArgumentException("Nombre négactive non autorisé");
		}
		if (nombreDesPremiers == 1) {
			return 2;
		}
		int counterDeNombrePremier = 0;
		int nombreEntier = 2;
		int res = 0;

		while (counterDeNombrePremier < nombreDesPremiers) {
			if (NombrePremier.estNombrePremier(nombreEntier)) {
				counterDeNombrePremier++;
				res += nombreEntier;
			}
			nombreEntier++;
		}

		return res;
	}

	public static boolean estNombrePremier(int nombre) {
		if (nombre < 2) {
			return false;
		}
		int nombreDivise = 0;
		for (int i = 1; i <= nombre; i++) {
			if (nombre % i == 0) {
				nombreDivise++;
			}
		}
		if (nombreDivise > 2) {
			return false;
		}
		return true;
	}

}
