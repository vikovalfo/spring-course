package com.vikovalfo.spring_course.invoice_generator.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Client {

	@Value("${client.name}")
	private String name;

	@Value("${client.lastname}")
	private String lastName;

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

}
