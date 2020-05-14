package com.maruf.spring.hibernate.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidationService {
	private static final String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	public boolean emailValidate(String email) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);

		if (matcher.matches())
			return true;
		else
			return false;

	}

}
