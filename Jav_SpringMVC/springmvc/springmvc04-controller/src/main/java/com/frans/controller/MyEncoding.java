package com.frans.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyEncoding {

    //�������������
    @RequestMapping("/e/t")
    public String test(Model model, String name){
        System.out.println(name);
        Model msg = model.addAttribute("msg", name);//��ȡ���ύ��ֵ
        return "test"; //��ת��testҳ����ʾ�����ֵ
    }
}