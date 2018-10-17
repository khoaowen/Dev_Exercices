import org.junit.jupiter.api.Test;

import model.LastDigit;

public class TestPerformance {

	@Test
	public void testStream() {
		LastDigit.toLastDigit(1);
	}
	@Test
	public void testSwitchCase() {
		LastDigit.toPrimeNumberSwitchCase(1);
	}
}
