package com.vikovalfo.spring_course.invoice_generator.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {

	private String name;
	private Integer price;

	public Product() {
	}

	public Product(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

}
