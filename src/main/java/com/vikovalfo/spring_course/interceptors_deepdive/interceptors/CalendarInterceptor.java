package com.vikovalfo.spring_course.interceptors_deepdive.interceptors;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component("calendarInterceptor")
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
        } else {

            Map<String, Object> map = new HashMap<>();
            StringBuilder message = new StringBuilder("Closed, out of service schedule!");
            ObjectMapper mapper = new ObjectMapper();

            message.append(", please visit from ");
            message.append(openHour);
            message.append(" hrs.");
            message.append(" to ");
            message.append(closeHour);
            message.append(" hrs.");
            message.append(" thanks for your visit!");

            map.put("message", message.toString());
            map.put("date", new Date().toString());

            response.setContentType("application/json");
            response.setStatus(401);
            response.getWriter().write(mapper.writeValueAsString(map));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {

    }
}