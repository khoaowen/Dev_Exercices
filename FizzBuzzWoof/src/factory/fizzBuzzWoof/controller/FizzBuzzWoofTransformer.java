package factory.fizzBuzzWoof.controller;

import java.util.function.Consumer;

import factory.fizzBuzzWoof.model.FizzBuzzWoofEnum;
import factory.fizzBuzzWoof.model.rules.ContainingRule;
import factory.fizzBuzzWoof.model.rules.DivisibleRule;

public class FizzBuzzWoofTransformer {
	
	private int valueToTransform;
	private StringBuilder bd = new StringBuilder();

	public FizzBuzzWoofTransformer() {
	}


	public void transform(int i) {
		valueToTransform= i;
		bd = new StringBuilder();
		applyRule(new DivisibleRule(FizzBuzzWoofEnum.FIZZ))
			.applyRule(new DivisibleRule(FizzBuzzWoofEnum.BUZZ))
			.applyRule(new DivisibleRule(FizzBuzzWoofEnum.WOOF))
			.applyRule(new ContainingRule())
		;
	}

	
	public FizzBuzzWoofTransformer applyRule(Consumer<FizzBuzzWoofTransformer> consumer) {
		consumer.accept(this);
		return this;
	}
	
	public int getValueToTransform() {
		return valueToTransform;
	}
	
	public void appendResult(String result) {
		bd.append(result);
	}
	
	public String printTransformedResult() {
		return bd.toString();
	}
}
