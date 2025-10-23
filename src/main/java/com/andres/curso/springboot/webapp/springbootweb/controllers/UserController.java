package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.andres.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Alessa", "Valencia");
        user.setEmail("alessa@email.com");
        model.addAttribute("title", "Hello world Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(
                new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@email.com"),
                new User("Juanita", "Roe", "juana@email.com"),
                new User("Andres", "Doe"));

        model.addAttribute("users", users);
        model.addAttribute("title", "List of users!");
        return "list";
    }

}
