package com.vikovalfo.spring_course.ioc.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(@Qualifier("productRepositoryImpl") ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> listAll() {
		return productRepository.listAll().stream().map((Product product) -> {
			Double price = product.getPrice() * 1.25d;
			// return new Product(product.getId(), product.getName(), price);
			product.setPrice(price);
			return (Product) product.clone();
		}).collect(Collectors.toList());
	}

	@Override
	public Product findProductbyId(Long id) {
		return productRepository.findProductById(id);
	}
}
