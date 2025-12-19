package com.vikovalfo.spring_course.jpa_hibernate.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vikovalfo.spring_course.jpa_hibernate.entities.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1")
    List<Person> searchingByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> gettingPersonData();

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.programmingLanguage = ?1")
    List<Object[]> gettingPersonData(String programmingLanguage);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.name = ?1 AND p.programmingLanguage = ?2")
    List<Object[]> gettingPersonData(String name, String programmingLanguage);

}
