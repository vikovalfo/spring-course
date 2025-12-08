package com.vikovalfo.spring_course.interceptors_deepdive.interceptors;

import java.util.Calendar;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CalendarInterceptor implements HandlerInterceptor {

    @Value("${config.calendar.open}")
    private Integer openHour;

    @Value("${config.calendar.close}")
    private Integer closeHour;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= openHour && hour <= closeHour) {
            StringBuilder message = new StringBuilder("Welcome to customer service!");
            message.append(", we are giving service from ");
            message.append(openHour);
            message.append(" hrs.");
            message.append(" to ");
            message.append(closeHour);
            message.append(" hrs.");
            message.append(" thanks for your visit!");
            request.setAttribute("message", message.toString());
            return true;
        } else
            return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

    }
}