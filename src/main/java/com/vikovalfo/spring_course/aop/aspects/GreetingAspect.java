package com.vikovalfo.spring_course.aop.aspects;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Aspect
@Component
public class GreetingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* com.vikovalfo.spring_course.aop.services.GreetingService.*(..))")
	private void greetingLoggerPointCut() {
	}

	@Before("greetingLoggerPointCut()")
    public void loggerBefore(JoinPoint joinPoint) {

        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
		logger.info("Before: " + method + " with arguments: " + args);

    }

	@After("greetingLoggerPointCut()")
	public void loggerAfter(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("After: " + method + " with arguments: " + args);

	}

	@AfterReturning("greetingLoggerPointCut()")
	public void loggerAfterReturning(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("After returning: " + method + " with arguments: " + args);

	}

	@AfterThrowing("greetingLoggerPointCut()")
	public void loggerAfterThrowing(JoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		logger.info("After throwing exception: " + method + " with arguments: " + args);

	}

	@Around("greetingLoggerPointCut()")
	public Object loggerAround(ProceedingJoinPoint joinPoint) {

		String method = joinPoint.getSignature().getName();
		String args = Arrays.toString(joinPoint.getArgs());
		Object proceeed = null;

		try {

			logger.info("Around: " + method + " with arguments: " + args);
			proceeed = joinPoint.proceed();
			logger.info("Around: " + method + " returned: " + proceeed);
			return proceeed;

		} catch (Throwable e) {
			logger.info("Around: " + method + " thrown: " + e.getMessage());
		}
		return proceeed;
	}
}
