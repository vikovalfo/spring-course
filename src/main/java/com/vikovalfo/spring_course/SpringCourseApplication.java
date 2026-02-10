package com.vikovalfo.spring_course;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.vikovalfo.spring_course.entities.Address;
import com.vikovalfo.spring_course.entities.Client;
import com.vikovalfo.spring_course.entities.Invoice;
import com.vikovalfo.spring_course.repositories.ClientRepository;
import com.vikovalfo.spring_course.repositories.InvoiceRepository;

@SpringBootApplication
public class SpringCourseApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		oneToMany();
		oneToManyFind();
	}

	@Transactional
	void oneToMany() {
		Client client = new Client("Lesty", "Eleonor");

		Address address1 = new Address("Evergreeen", 123);
		Address address2 = new Address("Central Perk", 456);

		// client.setAddresses(Arrays.asList(address1, address2));
		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		clientRepository.save(client);

		// System.out.println(clientDb.toString());

	}

	@Transactional
	void oneToManyFind() {

		Optional<Client> optionalClient = clientRepository.findById(3L);
		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			System.out.println(client.toString());
		}
	}

	@Transactional
	void manyToOne() {

		Client client = new Client("Lesty", "Eleonor");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Office expenses", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);

		System.out.println(invoiceDb.toString());
	}

	@Transactional
	void manyToOneFindbyIdClient() {

		Optional<Client> optionalClient = clientRepository.findById(2L);

		if (optionalClient.isPresent()) {
			Client client = optionalClient.orElseThrow();
			Invoice invoice = new Invoice("Office expenses", 2000L);
			invoice.setClient(client);
			Invoice invoiceDb = invoiceRepository.save(invoice);

			System.out.println(invoiceDb.toString());
		}

	}

}
