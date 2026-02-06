package com.vikovalfo.spring_course.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vikovalfo.spring_course.entities.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

}
