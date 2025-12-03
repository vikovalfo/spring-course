package com.vikovalfo.spring_course.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.vikovalfo.spring_course.exceptions.UserNotFoundExcception;
import com.vikovalfo.spring_course.models.Error;

@RestControllerAdvice
public class HandlerExceptionController {

	@ExceptionHandler({ ArithmeticException.class })
	public ResponseEntity<Error> divisionByZero(Exception exception) {

		Error error = new Error();

		error.setError("Invalid division");
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		error.setDate(new Date());

		return ResponseEntity.status(error.getStatus()).body(error);

	}

	@ExceptionHandler({ NoHandlerFoundException.class })
	public ResponseEntity<Error> notFound(Exception exception) {

		Error error = new Error();

		error.setError("URI Not found");
		error.setMessage(exception.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setDate(new Date());

		return ResponseEntity.status(error.getStatus()).body(error);
	}

	@ExceptionHandler({ NumberFormatException.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> numberFormat(Exception exception) {

		Map<String, Object> error = new HashMap<>();

		error.put("date", new Date());
		error.put("error", "Number format error");
		error.put("message", exception.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

		return error;

	}

	@ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class,
			UserNotFoundExcception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, Object> nullPointer(Exception exception) {

		Map<String, Object> error = new HashMap<>();

		error.put("date", new Date());
		error.put("error", "Element requested is not present");
		error.put("message", exception.getMessage());
		error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

		return error;

	}

}
