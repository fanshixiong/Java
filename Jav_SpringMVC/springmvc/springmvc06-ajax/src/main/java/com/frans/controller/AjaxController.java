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
        list.add(new User("fsx1��",3,"��"));
        list.add(new User("fsx2��",3,"��"));
        list.add(new User("fsx3��",3,"��"));
        return JSON.toJSONString(list); //����@RestControllerע�⣬��listת��json��ʽ����
    }


    @RequestMapping("/a3")
    public String ajax3(String name, String pwd){
        String msg = "";
        if(name != null) {
            //���ݿ��в�
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "�û�������";
            }
        }
        if(pwd != null){
            if("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "��������";
            }
        }
        return msg;
    }
}
