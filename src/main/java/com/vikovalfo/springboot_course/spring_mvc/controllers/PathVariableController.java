package com.vikovalfo.springboot_course.spring_mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

import com.vikovalfo.springboot_course.spring_mvc.controllers.models.User;
import com.vikovalfo.springboot_course.spring_mvc.controllers.models.dto.ParamDto;


@RestController
@RequestMapping("/api/var")
public class PathVariableController {
    @Value("${config.username}")
    private String username;

    @Value("${config.message}")
    private String message;

    @Value("${config.listOfValues}")
    private Integer[] listOfValues;

    @Value("#{'${config.listOfValues}'.split(',')}")
    private List<String> spelList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String stringList;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Value("#{${config.valuesMap}.description}")
    private String description;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return paramDto;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Integer id) {
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
        return json;
    }

    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());
        return user;
    }

    @GetMapping("/values")
    public Map<String, Object> values(@Value("${config.code}") Integer code) {
        Map<String, Object> json = new HashMap<>();
        json.put("message", message);
        json.put("envMessage", environment.getProperty("config.message"));
        json.put("code", code);
        json.put("list", listOfValues);
        json.put("spellist", spelList);
        json.put("stringList", stringList);
        json.put("valuesMap", valuesMap);
        json.put("price", valuesMap.get("price"));
        json.put("description", description);
        json.put("user", username);
        return json;
    }
    

}
