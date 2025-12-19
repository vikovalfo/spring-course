package com.vikovalfo.spring_course.jpa_hibernate.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vikovalfo.spring_course.jpa_hibernate.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
