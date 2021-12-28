package com.lambda;

import java.util.regex.Pattern;

public class ValidateDemo {

	public static void main(String[] args) {
		IValidate isValiFirstName = (pattern, firstName) -> Pattern
				.compile(pattern).matcher(firstName).matches();

		System.out.println(
				isValiFirstName.validate("^[a-zA-Z]{3,}$", "Vijay"));
	}

}