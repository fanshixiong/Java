package com.frans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LogiController {
    @RequestMapping("/goSuccess")
    public String success(){
        return "success";
    }

    @RequestMapping("/gologin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session){
        System.out.println("Ω” ’«∞∂À==="+username);
        session.setAttribute("userLoginInfo", username);
        session.setAttribute("username", username);
        return "success";
    }

    @RequestMapping("/logout")
    public String out(HttpSession session){
        session.removeAttribute("userLoginInfo");
        return "login";
    }
}
