package com.vikovalfo.spring_course.ioc.repositories.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.vikovalfo.spring_course.ioc.models.Product;
import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;

import tools.jackson.core.JacksonException;
import tools.jackson.databind.ObjectMapper;

public class ProductRepositoryJson implements ProductRepository {

	private List<Product> list;

	public ProductRepositoryJson(Resource resource) {
		readvalueWithResource(resource);
	}

	public ProductRepositoryJson() {
		ClassPathResource resource = new ClassPathResource("/json/product.json", getClass());
		readvalueWithResource(resource);
	}

	private void readvalueWithResource(Resource resource) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			list = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Product[].class));
		} catch (JacksonException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> listAll() {
		return list;
	}

	@Override
	public Product findProductById(Long id) {
		return list.stream().filter((Product product) -> product.getId().equals(id)).findFirst().orElseThrow();
	}

}
