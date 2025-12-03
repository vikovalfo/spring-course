package com.vikovalfo.spring_course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vikovalfo.spring_course.exceptions.UserNotFoundExcception;
import com.vikovalfo.spring_course.models.domain.User;
import com.vikovalfo.spring_course.services.UserService;

@RestController
public class AppController {

	@Autowired
	private UserService userService;

	@GetMapping("/division-error")
	public String divisionError() {
		int a = 100 / 0;
		return "Ok 200";
	}

	@GetMapping("/integer-parse")
	public String numberParsing() {
		int a = Integer.parseInt("f");
		return "Ok 200";
	}

	@GetMapping("/show/{id}")
	public User show(@PathVariable Long id) {
		User result = userService.findById(id).orElseThrow(() -> new UserNotFoundExcception("The user wasn't found"));
		return result;
	}
}
