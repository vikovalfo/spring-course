package com.vikovalfo.spring_course.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServicePointcuts {

	@Pointcut("execution(* com.vikovalfo.spring_course.aop.services.GreetingService.*(..))")
	public void greetingLoggerPointCut() {
	}

	@Pointcut("execution(* com.vikovalfo.spring_course.aop.services.GreetingService.*(..))")
	public void fooLoggerPointCut() {
	}
}
