package com.vikovalfo.spring_course.ioc.repositories;

import java.util.List;

import com.vikovalfo.spring_course.ioc.models.Product;

public interface ProductRepository {

	public List<Product> listAll();

	public Product findProductById(Long id);

}
