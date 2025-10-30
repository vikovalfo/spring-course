package com.vikovalfo.springboot_course.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({ "", "/", "/home" })
    public String home() {
        return "forward:/list";// redirect:/list forward preserves the data from the request through dispatcher
    }
}
