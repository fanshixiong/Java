package com.frans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyEncoding {

    //过滤器解决乱码
    @RequestMapping("/e/t")
    public String test(Model model, String name){
        System.out.println(name);
        Model msg = model.addAttribute("msg", name);//获取表单提交的值
        return "test"; //跳转到test页面显示输入的值
    }
}