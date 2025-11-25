package com.vikovalfo.spring_course.ioc.repositories;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.vikovalfo.spring_course.ioc.models.Product;

// @SessionScope per http session, shopping cart, logins
// @RequestScope per request singleton-like but oly for the mapped operation
@Repository("largeLists")
public class ProductRepositoryImpl implements ProductRepository {

	private List<Product> dataList;

	public ProductRepositoryImpl() {
		this.dataList = Arrays.asList(new Product(1L, "Corsair mem module", 300),
				new Product(2L, "CPU intel Corei7", 500), new Product(3L, "Power supply 800w", 150),
				new Product(4L, "Motherboard Gigabyte", 450));
	}

	@Override
	public List<Product> listAll() {
		return dataList;
	}

	@Override
	public Product findProductById(Long id) {
		return dataList.stream().filter((Product product) -> product.getId().equals(id)).findFirst().orElseThrow();
	}
}
