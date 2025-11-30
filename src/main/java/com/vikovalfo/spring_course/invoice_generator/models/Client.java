package com.vikovalfo.spring_course.invoice_generator.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class Client {

	@Value("${client.name}")
	private String name;

	@Value("${client.lastname}")
	private String lastName;

}
