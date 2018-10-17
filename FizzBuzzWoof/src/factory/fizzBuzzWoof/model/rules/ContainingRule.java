package factory.fizzBuzzWoof.model.rules;

import java.util.function.Consumer;

import factory.fizzBuzzWoof.controller.FizzBuzzWoofTransformer;
import factory.fizzBuzzWoof.model.FizzBuzzWoofEnum;

public class ContainingRule implements Consumer<FizzBuzzWoofTransformer>{

	@Override
	public void accept(FizzBuzzWoofTransformer t) {
		String valueOf = String.valueOf(t.getValueToTransform());
		
		for (int i = 0 ; i< valueOf.length(); i++) {
			char c = valueOf.charAt(i);
			int digit = c - '0';
			FizzBuzzWoofEnum fromInt = FizzBuzzWoofEnum.fromInt(digit);
			if (fromInt != null) {
				t.appendResult(fromInt.getLabel());
			}
		}
	}

	
}
