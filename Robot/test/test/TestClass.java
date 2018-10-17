package test;

import org.junit.Assert;
import org.junit.Test;

public class TestClass {
	
	private static final String REGEX_COMMAND="[LRM]+";
	private static final String REGEX_PLATEAU="\\d+ \\d+";
	private static final String REGEX_ROVER= "\\d+ \\d+ [NSEW]";
	
	@Test
	public void testGoodRoverPattern() {
		String line = "5 5 E";
		Assert.assertTrue(line.matches(REGEX_ROVER));
		line = "5 15 S";
		Assert.assertTrue(line.matches(REGEX_ROVER));
		line = "5 5 W";
		Assert.assertTrue(line.matches(REGEX_ROVER));
		line = "5 5 N";
		Assert.assertTrue(line.matches(REGEX_ROVER));
	}
	@Test
	public void testBadRoverPattern() {
		String line = "5 5";
		Assert.assertFalse(line.matches(REGEX_ROVER));
		line = "5 15S";
		Assert.assertFalse(line.matches(REGEX_ROVER));
		line = "5 W";
		Assert.assertFalse(line.matches(REGEX_ROVER));
		line = "N";
		Assert.assertFalse(line.matches(REGEX_ROVER));
	}
	@Test
	public void testGoodPlateauPattern() {
		String line = "5 5";
		Assert.assertTrue(line.matches(REGEX_PLATEAU));
		line = "5 15";
		Assert.assertTrue(line.matches(REGEX_PLATEAU));
		
	}
	@Test
	public void testBadPlateauPattern() {
		String line = "5 5 1";
		Assert.assertFalse(line.matches(REGEX_PLATEAU));
		line = "5 R";
		Assert.assertFalse(line.matches(REGEX_PLATEAU));
		line = "5";
		Assert.assertFalse(line.matches(REGEX_PLATEAU));
		
	}
	
	@Test
	public void testGoodCommandPattern() {
		String line = "LMLMLMMML";
		Assert.assertTrue(line.matches(REGEX_COMMAND));
		line= "MMLMLMMMRRRL";
		Assert.assertTrue(line.matches(REGEX_COMMAND));
		line= "RRRRR";
		Assert.assertTrue(line.matches(REGEX_COMMAND));
		
	}
	@Test
	public void testBadCommandPattern() {
		String line = "LMLMLHMMML";
		Assert.assertFalse(line.matches(REGEX_COMMAND));
		line = "LMLML HMMML";
		Assert.assertFalse(line.matches(REGEX_COMMAND));
	}

}
