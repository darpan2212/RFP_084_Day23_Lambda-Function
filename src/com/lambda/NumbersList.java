package com.lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class NumbersList {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			numbers.add((int)(Math.random()*100));
		}

		Iterator<Integer> itrNumbers = numbers.iterator();
		
		while(itrNumbers.hasNext()) {
			System.out.println("Iterator value : "+itrNumbers.next());
		}
		
		Consumer<Integer> intConsumer = n -> {
			System.out.println("For Each number : "+n);
		};
		
		numbers.forEach(intConsumer);
	}
}