package com.vikovalfo.spring_course;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		manyToOneFindbyIdClient();
	}

	void manyToOne() {

		Client client = new Client("Lesty", "Eleonor");
		clientRepository.save(client);

		Invoice invoice = new Invoice("Office expenses", 2000L);
		invoice.setClient(client);
		Invoice invoiceDb = invoiceRepository.save(invoice);

		System.out.println(invoiceDb.toString());
	}

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
