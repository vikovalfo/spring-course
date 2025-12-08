package com.vikovalfo.spring_course.interceptors_deepdive.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {

    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request) {

        Map<String, Object> map = new HashMap<>();
        map.put("message", "Welcome to the Customer attention center");
        map.put("date", new Date().toString());
        map.put("message", request.getAttribute("message"));
        return ResponseEntity.ok(map);

    }
}
