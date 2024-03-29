package com.frans.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类会被Spring接管
//@Controller注解的，如果类中有方法的返回值是String， 并且有具体的页面可以访问，那么就会被视图解析器解析；
@RequestMapping("/t1")
public class ControllerTest2{

    //映射访问路径
    @RequestMapping("/t2")
    public String index(Model model){
        //Spring MVC会自动实例化一个Model对象用于向视图中传值
        model.addAttribute("msg", "ControllerTest2");
        //返回视图位置
        return "test";//WEB_INF/jsp/test.jsp
    }

}