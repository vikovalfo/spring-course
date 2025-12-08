package com.vikovalfo.spring_course.interceptors.interceptors;

import java.util.Random;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
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
        HandlerMethod handlerMethod = ((HandlerMethod) handler);
        logger.info("Loading interceptor prehandler: incoming... " + handlerMethod.getMethod().getName());
        long start = System.currentTimeMillis();
        request.setAttribute("start", start);
        Thread.sleep(new Random().nextInt(500));
        /*
         * Map<String, String> json = new HashMap<>();
         * 
         * json.put("message", "Do not have access to this resource");
         * json.put("date", new Date().toString());
         * 
         * ObjectMapper mapper = new ObjectMapper();
         * String jsonString = mapper.writeValueAsString(json);
         * 
         * response.setContentType("application/json");
         * response.setStatus(401);
         * response.getWriter().write(jsonString);
         */

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            @Nullable ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = ((HandlerMethod) handler);
        logger.info("Loading interceptor posthandler: outgoing... " +
                handlerMethod.getMethod().getName());
        long end = System.currentTimeMillis();
        long start = ((long) request.getAttribute("start"));
        long result = end - start;
        logger.info("Elapsed time: " + result + " milliseconds");

    }

}
