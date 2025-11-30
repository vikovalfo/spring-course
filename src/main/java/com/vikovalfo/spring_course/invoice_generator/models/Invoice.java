package com.vikovalfo.spring_course.invoice_generator.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class Invoice {

	@Autowired
	private Client client;

	@Value("${invoice.desc}")
	private String descriptionString;

	@Autowired
	List<Item> items;

}
