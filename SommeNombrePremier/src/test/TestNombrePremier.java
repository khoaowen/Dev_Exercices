package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import app.NombrePremier;

public class TestNombrePremier {
	@Test
	public void estNombrePremier0() {
		assertEquals(NombrePremier.estNombrePremier(0), false);
	}

	@Test
	public void estNombrePremier1() {
		assertEquals(NombrePremier.estNombrePremier(1), false);
	}

	@Test
	public void estNombrePremier2() {
		assertEquals(NombrePremier.estNombrePremier(2), true);
	}

	@Test
	public void estNombrePremier3() {
		assertEquals(NombrePremier.estNombrePremier(3), true);
	}

	@Test
	public void estNombrePremier4() {
		assertEquals(NombrePremier.estNombrePremier(4), false);
	}

	@Test
	public void estNombrePremier5() {
		assertEquals(NombrePremier.estNombrePremier(5), true);
	}

	@Test
	public void estNombrePremier6() {
		assertEquals(NombrePremier.estNombrePremier(6), false);
	}
}
