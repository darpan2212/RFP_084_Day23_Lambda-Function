package com.lambda;

@FunctionalInterface
interface IMathFunction {
	int calculate(int a, int b);
	
	static void printResult(int x, int y, IMathFunction fObj) {
		System.out.println(fObj.calculate(x, y));
	}
}

public class MathOperations {
	
	public static void main(String[] args) {

		IMathFunction add = (int x, int y) -> x + y;
		System.out.println(add.calculate(5, 6));

		IMathFunction multiply = (a, b) -> a * b;
		System.out.println(multiply.calculate(5, 6));

		IMathFunction substraction = (a, b) -> a - b;
		System.out.println(substraction.calculate(5, 6));

		IMathFunction division = (a, b) -> {
			if (b == 0)
				return 0;
			return a / b;
		};
		System.out.println(division.calculate(5, 0));
		
		IMathFunction.printResult(50, 5, (a, b) -> {
			if (b == 0)
				return 0;
			return a / b;
		});
		
	}

}