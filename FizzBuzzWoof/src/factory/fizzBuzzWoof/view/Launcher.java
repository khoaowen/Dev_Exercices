package factory.fizzBuzzWoof.view;

import factory.fizzBuzzWoof.controller.FizzBuzzWoofTransformer;

public class Launcher {

	public static void main (String... args) {
		FizzBuzzWoofTransformer transformer = new FizzBuzzWoofTransformer();
		transformer.transform(Integer.parseInt(args[0]));
		System.out.println(transformer.printTransformedResult());
	}
}
