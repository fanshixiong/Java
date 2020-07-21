package com.frans.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.frans.pojo.User;
import com.frans.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController//���������ַ���
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

    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        User user1 = new User("������1", 13, "��");
        User user2 = new User("������2", 13, "��");
        User user3 = new User("������3", 13, "��");
        User user4 = new User("������4", 13, "��");
        User user5 = new User("������5", 13, "��");
        User user6 = new User("������6", 13, "��");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);

        String str = mapper.writeValueAsString(users);
        return str;
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        //�ر�ʱ���
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        Date date = new Date();

       //��ʽ��ʱ���
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //return mapper.writeValueAsString(simpleDateFormat.format(date));

        mapper.setDateFormat(simpleDateFormat);

        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/json5")
    public String json5() throws JsonProcessingException {
        Date date = new Date();
        String json = JsonUtils.getJson(date);
        return json;
    }

    @RequestMapping("/json6")
    public String json6() throws JsonProcessingException {
        User user1 = new User("������1", 13, "��");
        User user2 = new User("������2", 13, "��");
        User user3 = new User("������3", 13, "��");
        User user4 = new User("������4", 13, "��");
        User user5 = new User("������5", 13, "��");
        User user6 = new User("������6", 13, "��");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        return JsonUtils.getJson(users);
    }



    // fastjson
    @RequestMapping("/json8")
    public String json8(){
        //����һ������
        User user1 = new User("�ؽ�1��", 3, "��");
        User user2 = new User("�ؽ�2��", 3, "��");
        User user3 = new User("�ؽ�3��", 3, "��");
        User user4 = new User("�ؽ�4��", 3, "��");
        List<User> list = new ArrayList<User>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        System.out.println("*******Java���� ת JSON�ַ���*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON�ַ��� ת Java����*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java���� ת JSON���� ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON���� ת Java���� ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return JSON.toJSONString(list);
    }
}
