package com.vikovalfo.spring_course.invoice_generator.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.vikovalfo.spring_course.invoice_generator.models.Item;
import com.vikovalfo.spring_course.invoice_generator.models.Product;

@Configuration
@PropertySource("classpath:data.properties")
public class InitBeans {

	@Bean
	List<Item> itemsInvoice() {
		Product p1 = new Product("Reflex Camera", 800);
		Product p2 = new Product("Scooter Honeywell", 750);
		Product p3 = new Product("Gengar Pokemon stuffed animal", 100);
		Product p4 = new Product("Logitech mouse", 10);
		Product p5 = new Product("MSI gamer laptop", 400);
		List<Item> items = Arrays.asList(new Item(p1, 2), new Item(p2, 1), new Item(p3, 2), new Item(p4, 5),
				new Item(p5, 1));
		return items;
	}
}
