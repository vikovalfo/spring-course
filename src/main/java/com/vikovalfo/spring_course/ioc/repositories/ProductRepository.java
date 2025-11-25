package com.vikovalfo.spring_course.ioc.repositories;

import java.util.Arrays;
import java.util.List;

import com.vikovalfo.spring_course.ioc.models.Product;

public class ProductRepository {

	private List<Product> dataList;

	public ProductRepository() {
		this.dataList = Arrays.asList(new Product(1L, "Corsair mem module", 300),
				new Product(2L, "CPU intel Corei7", 500), new Product(3L, "Power supply 800w", 150),
				new Product(4L, "Motherboard Gigabyte", 450));
	}

	public List<Product> listAll() {
		return dataList;
	}

	public Product findProductById(Long id) {
		return dataList.stream().filter((Product product) -> product.getId().equals(id)).findFirst().orElseThrow();
	}
}
