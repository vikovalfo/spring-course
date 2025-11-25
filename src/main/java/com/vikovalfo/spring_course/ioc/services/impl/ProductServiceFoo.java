package com.vikovalfo.spring_course.ioc.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;
import com.vikovalfo.spring_course.ioc.services.ProductService;

@Service
public class ProductServiceFoo implements ProductService {

	private final ProductRepository productRepository;

	@Value("${config.price.tax}")
	private Double tax;

	public ProductServiceFoo(@Qualifier("productJson") ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> listAll() {
		return productRepository.listAll().stream().map((Product product) -> {
			Double price = product.getPrice() * tax;
			product.setPrice(price);
			return (Product) product.clone();
		}).collect(Collectors.toList());
	}

	@Override
	public Product findProductbyId(Long id) {
		return productRepository.findProductById(id);
	}
}
