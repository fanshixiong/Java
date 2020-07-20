package com.frans.controller;


import com.frans.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.����ǰ�˲���
        System.out.println("���ܵ�ǰ�˵Ĳ���Ϊ��" + name);
        //2. �����صĽ�����ݸ�ǰ��
        model.addAttribute("msg", name);

        //3. ��ͼ��ת
        return "test";
    }

    //ǰ�˽��ܵ��Ƕ���

    /**
     *
     * @param user
     *   1. ����ǰ���û����ݵĲ������жϲ��������֣���������ֱ���ڷ����ϣ�����ֱ������
     *   2. ���贫�ݵ���һ��User����ƥ��User�����е��ֶ������������һ����ok������ƥ�䲻��
     * @return
     */
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

}
