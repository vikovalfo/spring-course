package com.vikovalfo.spring_course.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vikovalfo.spring_course.models.domain.User;
import com.vikovalfo.spring_course.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private List<User> users;

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public Optional<User> findById(long id) {
		return users.stream().filter(user -> user.getId() == id).findFirst();
	}

}
