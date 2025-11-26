package com.vikovalfo.spring_course.ioc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;
import com.vikovalfo.spring_course.ioc.repositories.impl.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

	@Value("classpath:json/product.json")
	private Resource resource;

	@Bean("productJson")
	@Primary
	ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson(resource);
	}
}
