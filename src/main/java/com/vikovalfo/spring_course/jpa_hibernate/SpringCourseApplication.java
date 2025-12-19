package com.vikovalfo.spring_course.jpa_hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vikovalfo.spring_course.jpa_hibernate.entities.Person;
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
		List<Person> people = (List<Person>) personRepository.findAll();

		people.forEach(System.out::println);
	}

}
