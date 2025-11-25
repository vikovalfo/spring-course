package com.vikovalfo.spring_course.ioc.repositories.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;

@Repository
public class ProductRepositoryJpa implements ProductRepository {

	@Override
	public List<Product> listAll() {
		return Collections.singletonList(new Product(1L, "Keyboard Logitech GKB500", 120.25));
	}

	@Override
	public Product findProductById(Long id) {
		return new Product(id, "New product", 50.99);
	}

}
