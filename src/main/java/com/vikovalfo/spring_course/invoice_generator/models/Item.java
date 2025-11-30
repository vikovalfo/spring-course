package com.vikovalfo.spring_course.invoice_generator.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Item {

	private Product product;
	private Integer quantity;

	public Item() {
	}

	public Item(Product product, Integer quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

}
