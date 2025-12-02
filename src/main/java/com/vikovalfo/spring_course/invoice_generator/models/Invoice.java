package com.vikovalfo.spring_course.invoice_generator.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Invoice {

	@Autowired
	private Client client;

	@Value("${invoice.desc.office}")
	private String description;

	@Autowired
	@Qualifier("default")
	List<Item> items;

	@PostConstruct
	public void init() {
		this.description = this.description.concat(", of the client: ")
				.concat(client.getName() + " " + client.getLastName());
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroying object...");
	}

	public Client getClient() {
		return client;
	}

	public String getDescription() {
		return description;
	}


	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public int getTotal() {
		int total = 0;

		/*
		 * for (Item item : items) { total += item.getImport(); }
		 */

		total = items.stream().map((Item item) -> item.getImport()).reduce(0, (sum, item) -> sum + item);

		return total;
	}

}
