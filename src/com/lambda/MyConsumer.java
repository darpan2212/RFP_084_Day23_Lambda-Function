package com.lambda;

import java.util.function.Consumer;

public class MyConsumer implements Consumer<Integer> {

	@Override
	public void accept(Integer n) {
		System.out.println("Mth3 MyConsumer elements : " + n);
	}

}
