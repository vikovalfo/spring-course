package com.vikovalfo.spring_course.aop.services.impl;

import org.springframework.stereotype.Service;

import com.vikovalfo.spring_course.aop.services.GreetingService;

@Service
public class GreetingServiceBasic implements GreetingService {

    @Override
	public String sayHello(String person, String phrase) {
        return phrase + " " + person;
    }

	@Override
	public String sayHelloError(String person, String phrase) {
		throw new RuntimeException("Some error");
	}

}
