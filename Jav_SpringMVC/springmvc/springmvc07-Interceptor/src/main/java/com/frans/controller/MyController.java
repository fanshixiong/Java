package com.frans.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @RequestMapping("/a1")
    public String a1(){
        System.out.println("++++++++++++a1++++++++++++");
        return "OK";
    }
}
