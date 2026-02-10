package com.vikovalfo.spring_course.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vikovalfo.spring_course.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {

    @Query("SELECT c FROM Client c JOIN FETCH c.addresses")
    Optional<Client> findOne(Long id);
}
