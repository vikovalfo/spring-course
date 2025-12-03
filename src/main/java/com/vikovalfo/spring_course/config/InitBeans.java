package com.vikovalfo.spring_course.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vikovalfo.spring_course.models.domain.User;

@Configuration
public class InitBeans {

	@Bean
	List<User> users() {
		List<User> users = new ArrayList<>();
		users.add(new User(1L, "ABC", "DEF"));
		users.add(new User(1L, "GHI", "JKL"));
		users.add(new User(1L, "MNO", "PQR"));
		users.add(new User(1L, "STU", "VW"));
		users.add(new User(1L, "XY", "Z"));
		return users;
	}
}
