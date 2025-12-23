package com.vikovalfo.spring_course.jpa_hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vikovalfo.spring_course.jpa_hibernate.repositories.PersonRepository;

@SpringBootApplication
public class SpringCourseApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		findOne();
	}

	public void findOne() {
		// Person person = personRepository.findById(1L).orElseThrow();
		// System.out.println(person);
		/*
		 * Optional<Person> personOptional = personRepository.findById(1L);
		 * Person person = null;
		 * if (personOptional.isPresent()) {
		 * person = personOptional.get();
		 * 
		 * }
		 * System.out.println(person);
		 */
		personRepository.findById(1L).ifPresent(System.out::println);
	}

	public void listing() {
		List<Object[]> people = personRepository.gettingPersonData();
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

		people = personRepository.gettingPersonData("Java");
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

		people = personRepository.gettingPersonData("Alessa", "C++");
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

	}

}
