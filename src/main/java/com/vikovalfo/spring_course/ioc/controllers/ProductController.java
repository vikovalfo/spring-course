package com.vikovalfo.spring_course.ioc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.services.ProductServiceImpl;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductServiceImpl productService;

	@GetMapping
	public List<Product> listAll() {
		return productService.listAll();
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.findProductbyId(id);
	}

}
