package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;


public class PrimeProcessor implements AutoCloseable{
	
	private LastDigit previous;
	private Rule rule = new Rule();
	private final String filePath;
	
	public PrimeProcessor(String filePath) {
		this.filePath= filePath;
	}

	public void process() throws IOException {
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			stream.map(Integer::parseInt)
					.map(this::lastDigit)
					.forEach(this::proceed);
				}
	}
	
	private void proceed(LastDigit digit) {
		if (previous != null) {
			rule.updateStatistique(digit, previous);
		}
		
		previous = digit;
	}

	
	private LastDigit lastDigit(int prime) {
		return LastDigit.toLastDigit(prime % 10);
	}
	
	public Map<LastDigit, Statistique> statistiques() {
		return rule.statistiques();
	}

	@Override
	public void close() throws Exception {
		// nothing to close
	}
	
}
