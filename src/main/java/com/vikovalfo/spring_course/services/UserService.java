package com.vikovalfo.spring_course.services;

import java.util.List;

import com.vikovalfo.spring_course.models.domain.User;

public interface UserService {

	List<User> findAll();

	User findById(long id);

}
