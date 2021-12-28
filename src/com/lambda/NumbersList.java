package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumbersList {

	public static void main(String[] args) {

		List<Integer> intList = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			intList.add((int) (Math.random() * 100));
		}

		// Method1 : iterate each element of the list with iterator
		Iterator<Integer> itrNumbers = intList.iterator();
		while (itrNumbers.hasNext()) {
			System.out.println(
					"Mth1 Iterator value : " + itrNumbers.next());
		}

		// Method2 : iterate each element of the list with foreach method
		Consumer<Integer> intConsumer = n -> {
			System.out.println("Mth2 For Each number : " + n);
		};
		intList.forEach(intConsumer);

		// Method3: iterate each element of the list with MyConsumer
		MyConsumer consumer = new MyConsumer();
		intList.forEach(consumer);

		// Method4: iterate each element of the list with new Consumer
		intList.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer n) {
				System.out.println("Mth4 new Consumer : " + n);
			}
		});

		// Method5: iterate each element of the list with lambda function
		intList.forEach(n -> {
			System.out.println("Mth5 lambda : " + n);
		});

		// Method6: convert each element of the list to double
		Function<Integer, Double> toDoubleValue = Integer::doubleValue;
		List<Double> doubleList = new ArrayList<>();
		intList.forEach(n -> {
			doubleList.add(toDoubleValue.apply(n));
		});
		System.out.println("Mth6 Double values : " + doubleList);

		// Method7: test the intList numbers are even or not
		Predicate<Integer> isEvenValue = n -> n > 0 && n % 2 == 0;
		List<Double> evenNumbers = new ArrayList<>();
		intList.forEach(n -> {
			if (isEvenValue.test(n))
				evenNumbers.add(n.doubleValue());
		});
		System.out.println("Mth7 Even values : " + evenNumbers);

		// Method8: Stream foreach (UC 2.1)
		intList.stream().forEach(n -> {
			System.out.println("Mth8 Stream for each : " + n);
		});

		List<Double> evenList = new ArrayList<>();
		intList.forEach(n -> {
			doubleList.add(toDoubleValue.apply(n));
		});
		doubleList.forEach(n1 -> {
			if (isEvenValue.test(n1.intValue())) {
				evenList.add(n1);
			}
		});
		System.out.println(
				"Mth9 Even values from double : " + evenNumbers);

		// Method10: UC 2.2,2.3,2.4
		List<Double> streamList = intList.stream().filter(isEvenValue)
				.map(toDoubleValue).collect(Collectors.toList());

		System.out.println("Mth10 Stream List : " + streamList);
		System.out.println("After Mth10 Int List : " + intList);

		Comparator<Integer> minCompare = (n1, n2)-> n1<n2?n1:n2; 
		Comparator<Integer> maxCompare = (n1, n2)-> n1>n2?n1:n2; 
		System.out.println(intList.stream().min(minCompare));
		System.out.println(intList.stream().max(maxCompare));
	}
}