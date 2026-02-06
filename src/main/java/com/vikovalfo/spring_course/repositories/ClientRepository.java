package com.vikovalfo.spring_course.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vikovalfo.spring_course.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

}
