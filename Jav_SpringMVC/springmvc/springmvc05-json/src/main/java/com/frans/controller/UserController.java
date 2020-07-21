package com.frans.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frans.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/json1",produces = "application/json;charset=utf-8")
    @ResponseBody  //��������ͼ������,��ֱ�ӷ����ַ���
    public String json1() throws JsonProcessingException {
        //����һ��jackson�Ķ���ӳ������������������
        ObjectMapper mapper = new ObjectMapper();
        //����һ������
        User user = new User("������", 3, "��");
        //�����ǵĶ��������Ϊjson��ʽ
        String str = mapper.writeValueAsString(user);
        //����@ResponseBodyע�⣬����Ὣstrת��json��ʽ���أ�ʮ�ַ���
        return str;
    }

}
