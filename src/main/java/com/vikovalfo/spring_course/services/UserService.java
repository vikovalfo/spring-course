package com.vikovalfo.spring_course.services;

import java.util.List;
import java.util.Optional;

import com.vikovalfo.spring_course.models.domain.User;

public interface UserService {

	List<User> findAll();

	Optional<User> findById(long id);

}
