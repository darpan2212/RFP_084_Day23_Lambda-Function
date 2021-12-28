package com.lambda;

@FunctionalInterface
public interface IValidate {
	public boolean validate(String regex, String field);
}