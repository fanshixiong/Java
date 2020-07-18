package com.frans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/HelloController")
public class HelloController {

    //��ʵ���ʵ�ַ : ��Ŀ��/HelloController/hello
    @RequestMapping("/hello")
    public String sayHello(Model model){
        //��ģ�����������msg��ֵ��������JSPҳ����ȡ������Ⱦ
        model.addAttribute("msg","hello,SpringMVC");
        //web-inf/jsp/hello.jsp
        return "hello";
    }
}