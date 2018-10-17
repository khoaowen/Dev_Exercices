package controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.PrimeProcessor;
import vue.Printer;

public class PrimeLauncher {

	public static void main(String... args) {
		if (args.length == 0 ) {
			throw new RuntimeException("Must be launched with an argument indicating the file name which contains the list of prime numbers (ex: primes.txt)");
		}
		
		try (PrimeProcessor p = new PrimeProcessor(args[0])) {
			p.process();
			Printer printer = new Printer(p.statistiques());
			printer.print();
		} catch (Exception e) {
			Logger.getLogger(PrimeLauncher.class.getName()).log(Level.SEVERE, "Problem processing file: " + e.getMessage());
		}
		
	}

}
