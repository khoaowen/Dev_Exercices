package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import app.NombrePremier;

public class TestSommePremier {

	@Test
	public void sommeDe0Premier() {
		assertEquals(NombrePremier.calculerSommeDesPremiers(0), 0);
	}

	@Test
	public void sommeDe1Premier() {
		assertEquals(NombrePremier.calculerSommeDesPremiers(1), 2);
	}

	@Test
	public void sommeDe2Premiers() {
		assertEquals(NombrePremier.calculerSommeDesPremiers(2), 5);
	}

	@Test
	public void sommeDe3Premiers() {
		assertEquals(NombrePremier.calculerSommeDesPremiers(3), 10);
	}

	@Test(expectedExceptions = { IllegalArgumentException.class })
	public void sommeDeNegativePremiers() {
		NombrePremier.calculerSommeDesPremiers(-1);
	}

}
