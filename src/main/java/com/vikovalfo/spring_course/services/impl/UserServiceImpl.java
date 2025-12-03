package com.vikovalfo.spring_course.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vikovalfo.spring_course.models.domain.User;
import com.vikovalfo.spring_course.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private List<User> users;

	public UserServiceImpl() {
		users = new ArrayList<>();
		users.add(new User(1L, "ABC", "DEF"));
		users.add(new User(1L, "GHI", "JKL"));
		users.add(new User(1L, "MNO", "PQR"));
		users.add(new User(1L, "STU", "VW"));
		users.add(new User(1L, "XY", "Z"));
	}

	@Override
	public List<User> findAll() {
		return users;
	}

	@Override
	public Optional<User> findById(long id) {
		User user = null;
		for (User u : users) {
			if (u.getId() == id) {
				user = u;
				break;
			}
		}

		if (user == null) {
			return Optional.empty();
		}

		return Optional.ofNullable(user);
	}

}
