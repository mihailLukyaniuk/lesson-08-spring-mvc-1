package com.godeltech.mastery.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    @RequestMapping({"/", "/index", "hello"})
    public String helloWorld() {
        return "helloWorld";
    }
}
