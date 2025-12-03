package com.vikovalfo.spring_course.exceptions;

public class UserNotFoundExcception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundExcception(String message) {
		super(message);
	}
}
