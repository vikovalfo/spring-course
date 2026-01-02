package com.vikovalfo.spring_course.jpa_hibernate;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

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
		deleteOne();
	}

	@Transactional
	public void createFromCommandLine() {
		String name, lastName, progLan;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Name: ");
			name = sc.nextLine();
			System.out.println("Last name: ");
			lastName = sc.nextLine();
			System.out.println("Programming language: ");
			progLan = sc.nextLine();
			create(name, lastName, progLan);
		}
	}

	@Transactional
	public void create(String name, String lastName, String progLan) {
		Person person = new Person(null, name, lastName, progLan);
		personRepository.save(person);
	}

	@Transactional
	public void update() {
		Person person = null;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the person's id: ");
			long id = Integer.parseInt(sc.nextLine());

			Optional<Person> optional = personRepository.findById(id);

			if (optional.isPresent()) {
				person = optional.get();
				System.out.println(
						"old person's name is " + person.getName() + ", Enter new: ");
				String nm = sc.nextLine();
				if (!person.getName().equalsIgnoreCase(nm)) {
					person.setName(nm);
				}
				System.out.println(
						"old person's last name is " + person.getLastName() + ", Enter new: ");
				String lnm = sc.nextLine();
				if (!person.getLastName().equalsIgnoreCase(lnm)) {
					person.setLastName(lnm);
				}
				System.out.println(
						"old person's programming language is " + person.getProgrammingLanguage() + ", Enter new: ");
				String prolan = sc.nextLine();
				if (!person.getProgrammingLanguage().equalsIgnoreCase(prolan)) {
					person.setProgrammingLanguage(prolan);
				}
				Person updatedPerson = personRepository.save(person);
				System.out.println(updatedPerson);
			}
		}
	}

	@Transactional
	public void deleteOne() {
		Person person = null;
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the person's id: ");
			long id = Integer.parseInt(sc.nextLine());

			Optional<Person> optional = personRepository.findById(id);

			if (optional.isPresent()) {
				person = optional.get();
				personRepository.deleteById(person.getId());
			}
		}
	}

	@Transactional(readOnly = true)
	public void FindAll() {
		System.out.println(personRepository.findOne(1L).get());
		System.out.println(personRepository.findAllByProgrammingLanguage("ava"));
	}

	@Transactional(readOnly = true)
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

	@Transactional(readOnly = true)
	public void listing() {
		List<Object[]> people = personRepository.gettingPersonData();
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

		people = personRepository.gettingPersonData("Java");
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

		people = personRepository.gettingPersonData("Alessa", "C++");
		people.stream().forEach(obj -> System.out.println("Name: " + obj[0] + ", Programming language: " + obj[1]));

	}

}
