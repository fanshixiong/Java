package com.frans.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //���������ᱻSpring�ӹ�
//@Controllerע��ģ���������з����ķ���ֵ��String�� �����о����ҳ����Է��ʣ���ô�ͻᱻ��ͼ������������
@RequestMapping("/t1")
public class ControllerTest2{

    //ӳ�����·��
    @RequestMapping("/t2")
    public String index(Model model){
        //Spring MVC���Զ�ʵ����һ��Model������������ͼ�д�ֵ
        model.addAttribute("msg", "ControllerTest2");
        //������ͼλ��
        return "test";//WEB_INF/jsp/test.jsp
    }

}