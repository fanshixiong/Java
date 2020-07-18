package com.frans.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ControllerTest1 implements Controller {
    @Override
    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg", "ControllerTest1");

        modelAndView.setViewName("test");
        return modelAndView;
    }
}
