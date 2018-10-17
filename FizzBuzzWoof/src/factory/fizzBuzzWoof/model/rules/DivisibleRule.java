package factory.fizzBuzzWoof.model.rules;

import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

import factory.fizzBuzzWoof.controller.FizzBuzzWoofTransformer;
import factory.fizzBuzzWoof.model.FizzBuzzWoofEnum;

public class DivisibleRule implements Consumer<FizzBuzzWoofTransformer>{
	
	private final FizzBuzzWoofEnum fizzBuzzWoofEnum;

	public DivisibleRule(FizzBuzzWoofEnum fizzBuzzWoofEnum) {
		this.fizzBuzzWoofEnum = fizzBuzzWoofEnum;
	}


	@Override
	public void accept(FizzBuzzWoofTransformer t) {
		switch (fizzBuzzWoofEnum) {
		case FIZZ:
		case BUZZ:
		case WOOF:
			if (t.getValueToTransform() % fizzBuzzWoofEnum.getValue() ==0) {
				t.appendResult(fizzBuzzWoofEnum.getLabel());
			} else {
				t.appendResult(String.valueOf(t.getValueToTransform()));
			}
			break;
		default:
			Logger.getLogger(DivisibleRule.class.getName()).log(Level.SEVERE, "Can not handle enum: " + fizzBuzzWoofEnum);
		}
	}
		

}
