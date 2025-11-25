package com.vikovalfo.spring_course.ioc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.vikovalfo.spring_course.ioc.repositories.ProductRepository;
import com.vikovalfo.spring_course.ioc.repositories.impl.ProductRepositoryJson;

@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

	@Bean("productJson")
	@Primary
	ProductRepository productRepositoryJson() {
		return new ProductRepositoryJson();
	}
}
