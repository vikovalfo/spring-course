package com.vikovalfo.spring_course.ioc.services;

import java.util.List;
import java.util.stream.Collectors;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;

public class ProductService {

	private ProductRepository productRepository = new ProductRepository();

	public List<Product> listAll() {
		return productRepository.listAll().stream().map((Product product) -> {
			Double price = product.getPrice() * 1.25d;
			// return new Product(product.getId(), product.getName(), price);
			product.setPrice(price);
			return (Product) product.clone();
		}).collect(Collectors.toList());
	}

	public Product findProductbyId(Long id) {
		return productRepository.findProductById(id);
	}
}
