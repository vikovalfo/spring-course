package com.vikovalfo.spring_course.ioc.models;

import org.springframework.stereotype.Component;

@Component
public class Product implements Cloneable {

	private Long id;
	private String name;
	private double price;

	public Product() {
	}

	public Product(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.setPrice(price);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			return new Product(id, name, price);
		}
	}

}
