package com.vikovalfo.spring_course.interceptors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("loadingtimeInterceptor")
    private HandlerInterceptor loadingtimeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(loadingtimeInterceptor).addPathPatterns("/app/foo",
        // "/app/bar");
        registry.addInterceptor(loadingtimeInterceptor).excludePathPatterns("/app/foo", "/app/**");
        // registry.addInterceptor(loadingtimeInterceptor).excludeHttpMethods(HttpMethod.GET);

    }

}
