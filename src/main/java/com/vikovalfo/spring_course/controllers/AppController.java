package com.vikovalfo.spring_course.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

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
}
