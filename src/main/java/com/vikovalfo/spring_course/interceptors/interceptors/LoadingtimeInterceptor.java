package com.vikovalfo.spring_course.interceptors.interceptors;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("loadingtimeInterceptor")
public class LoadingtimeInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(LoadingtimeInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        logger.info(LoadingtimeInterceptor.class.getName() + LoadingtimeInterceptor.class.getMethod("preHandle",
                LoadingtimeInterceptor.class));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        logger.info(LoadingtimeInterceptor.class.getName() + LoadingtimeInterceptor.class.getMethod("postHandle",
                LoadingtimeInterceptor.class));
    }

}
