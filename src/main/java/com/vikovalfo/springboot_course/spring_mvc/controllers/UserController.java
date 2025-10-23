package com.vikovalfo.springboot_course.spring_mvc.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.vikovalfo.springboot_course.spring_mvc.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model) {

        User user = new User("Alessa", "Valencia");
        user.setEmail("alessa@email.com");
        model.addAttribute("title", "Hola World Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        model.addAttribute("title", "List of users!");
        return "list";
    }
    
    @ModelAttribute("users")
    public List<User> usersModel() {
        return Arrays.asList(
                new User("Pepa", "Gonzalez"),
                new User("Lalo", "Perez", "lalo@email.com"),
                new User("Juanita", "Roe", "juana@email.com"),
                new User("Andres", "Doe"));
    }

}
