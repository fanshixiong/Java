package com.frans.controller;

import com.alibaba.fastjson.JSON;
import com.frans.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void test1(String name, Model model){
        System.out.println("a1 : param => " + name);
        if ("frans".equals(name)){
            model.addAttribute("txtName", "true");
        }
        else{
            model.addAttribute("txtName", "false");
        }
    }

    @RequestMapping(value = "/a2", produces = "application/json;charset=utf-8")
    public String ajax2(){
        System.out.println("a2 : param => ");
        List<User> list = new ArrayList<>();
        list.add(new User("fsx1号",3,"男"));
        list.add(new User("fsx2号",3,"男"));
        list.add(new User("fsx3号",3,"男"));
        return JSON.toJSONString(list); //由于@RestController注解，将list转成json格式返回
    }


    @RequestMapping("/a3")
    public String ajax3(String name, String pwd){
        String msg = "";
        if(name != null) {
            //数据库中查
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名有误";
            }
        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
        }
        return msg;
    }
}
