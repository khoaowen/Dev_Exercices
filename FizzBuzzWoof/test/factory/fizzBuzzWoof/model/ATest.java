package factory.fizzBuzzWoof.model;

import org.junit.Assert;
import org.junit.Test;

import factory.fizzBuzzWoof.controller.FizzBuzzWoofTransformer;


public class ATest {

	@Test
	public void test() {
		Object[] array = "12356".chars().mapToObj(intChar-> (char) intChar ).map(character -> character - '0').toArray();
		Assert.assertTrue(array[0] instanceof Integer);
	}
	
	@Test
	public void testTransformerNotDivisble() {
		FizzBuzzWoofTransformer transformer = new FizzBuzzWoofTransformer();
		transformer.transform(1);
		Assert.assertTrue(transformer.printTransformedResult().equals("1"));
		transformer.transform(2);
		Assert.assertTrue(transformer.printTransformedResult().equals("2"));
	}
	@Test
	public void testTransformer() {
		FizzBuzzWoofTransformer transformer = new FizzBuzzWoofTransformer();
		transformer.transform(6);
		Assert.assertTrue(transformer.printTransformedResult().equals("Fizz"));
	}
}
