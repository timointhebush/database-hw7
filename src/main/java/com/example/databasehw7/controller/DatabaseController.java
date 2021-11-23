package com.example.databasehw7.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DatabaseController {

    @GetMapping(value = "/home")
    public String home() {
        return "Hello World";
    }

    @GetMapping(value = "/test")
    public ModelAndView viewTest() {
        ModelAndView modelAndView = new ModelAndView("test");
        modelAndView.addObject("name", "world");
        return modelAndView;
    }
}
