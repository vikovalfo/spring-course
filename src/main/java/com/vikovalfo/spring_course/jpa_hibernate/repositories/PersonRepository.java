package com.vikovalfo.spring_course.jpa_hibernate.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vikovalfo.spring_course.jpa_hibernate.entities.Person;
import com.vikovalfo.spring_course.jpa_hibernate.dto.PersonDTO;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.id BETWEEN 2 AND 5")
    List<Person> findAllBetweenIdRange();

    @Query("SELECT LOWER(p.name || ' ' || p.lastName) FROM Person p")
    List<String> findAllFullNameConcatLower();

    @Query("SELECT UPPER(p.name || ' ' || p.lastName) FROM Person p")
    List<String> findAllFullNameConcatUpper();

    // @Query("SELECT CONCAT(p.name, ' ', p.lastName) FROM Person p")
    @Query("SELECT p.name || ' ' || p.lastName FROM Person p")
    List<String> findAllFullNameConcat();

    @Query("SELECT DISTINCT(p.name) FROM Person p")
    List<String> findAllNamesDistinct();

    @Query("SELECT DISTINCT(p.programmingLanguage) FROM Person p")
    List<String> findAllProgrammingLanguagesDistinct();

    @Query("SELECT new com.vikovalfo.spring_course.jpa_hibernate.dto.PersonDTO(p.name, p.lastName) FROM Person p")
    List<PersonDTO> findallClassPersonDTOByConstructor();

    @Query("SELECT new Person(p.name, p.lastName) FROM Person p")
    List<Person> findallClassPersonByConstructor();

    @Query("SELECT CONCAT(p.name, ' ', p.id) as fullname FROM Person p WHERE p.id = :id")
    String getFullNameById(Long id);

    List<Person> findByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p FROM Person p WHERE p.programmingLanguage = ?1")
    List<Person> searchingByProgrammingLanguage(String programmingLanguage);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p")
    List<Object[]> gettingPersonData();

    @Query("SELECT p, p.programmingLanguage FROM Person p")
    List<Object[]> findAllMixedPerson();

    @Query("SELECT p.id, p.name, p.lastName, p.programmingLanguage FROM Person p")
    List<Object[]> gettingPersonDataList();

    @Query("SELECT p.name, p.lastName, p.programmingLanguage FROM Person p WHERE p.id = :id")
    Object gettingPersonDataById(Long id);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.programmingLanguage = ?1")
    List<Object[]> gettingPersonData(String programmingLanguage);

    @Query("SELECT p.name, p.programmingLanguage FROM Person p WHERE p.name = ?1 AND p.programmingLanguage = ?2")
    List<Object[]> gettingPersonData(String name, String programmingLanguage);

    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("SELECT p FROM Person p WHERE p.programmingLanguage LIKE %:programmingLanguage%")
    List<Person> findAllByProgrammingLanguage(String programmingLanguage);

}
