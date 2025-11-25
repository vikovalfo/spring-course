package com.vikovalfo.spring_course.ioc.services;

import java.util.List;

import com.vikovalfo.spring_course.ioc.models.Product;

public interface ProductService {

	public List<Product> listAll();

	public Product findProductbyId(Long id);

}
