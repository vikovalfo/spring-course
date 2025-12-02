package com.vikovalfo.spring_course.invoice_generator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikovalfo.spring_course.invoice_generator.models.Client;
import com.vikovalfo.spring_course.invoice_generator.models.Invoice;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private Invoice invoice;

	@GetMapping("/show")
	public Invoice show() {
		Invoice in = new Invoice();
		Client cl = new Client();

		cl.setName(invoice.getClient().getName());
		cl.setLastName(invoice.getClient().getLastName());

		in.setClient(cl);
		in.setDescription(invoice.getDescription());
		in.setItems(invoice.getItems());

		return in;
	}
}
