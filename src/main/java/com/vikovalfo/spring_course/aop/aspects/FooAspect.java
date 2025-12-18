package com.vikovalfo.spring_course.aop.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect
@Component
public class FooAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.vikovalfo.spring_course.aop.services.GreetingService.*(..))")
	public void loggerBefore(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Before: " + method + " with arguments: " + args);

	}

	@After("execution(* com.vikovalfo.spring_course.aop.services.GreetingService.*(..))")
	public void loggerAfter(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("After: " + method + " with arguments: " + args);

	}

}
