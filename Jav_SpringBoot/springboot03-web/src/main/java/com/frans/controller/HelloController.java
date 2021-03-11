package com.frans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/hello")
    public String hello(Map<String, Object> map){
        map.put("msg", "<h1>Hello Thymeleaf</h1>");
        map.put("users", Arrays.asList("frans", "fanshi"));
        return "hello";
    }
}
