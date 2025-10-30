package com.vikovalfo.springboot_course.spring_mvc.controllers;

import com.vikovalfo.springboot_course.spring_mvc.models.dto.ParamDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/params")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam(required = false, defaultValue = "Hi!") String message){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(message);
        return  paramDto;
    }

    @GetMapping("/bar")
    public ParamDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamDto paramDto = new ParamDto();
        paramDto.setMessage(text);
        paramDto.setCode(code);
        return paramDto;
    }

    @GetMapping("/request")
    public ParamDto request(HttpServletRequest httpServletRequest){
        Integer code = 10;
        String text = "Hi!";
        try{
            code = Integer.parseInt(httpServletRequest.getParameter("code"));
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        try{
            text = httpServletRequest.getParameter("text");
        } catch (Exception e) {
            e.getMessage();
        }
        ParamDto paramDto = new ParamDto();
        paramDto.setCode(code);
        paramDto.setMessage(text);
        return  paramDto;
    }
}
