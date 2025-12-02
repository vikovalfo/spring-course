package com.vikovalfo.spring_course.invoice_generator.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Invoice {

	@Autowired
	private Client client;

	@Value("${invoice.desc}")
	private String description;

	@Autowired
	List<Item> items;

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
