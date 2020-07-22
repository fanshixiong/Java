package com.frans.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

@Controller
public class DownController {
    @RequestMapping(value="/download")
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        //Ҫ���ص�ͼƬ��ַ
        String  path = request.getServletContext().getRealPath("/upload");
        String  fileName = "1.jpg";

        //1������response ��Ӧͷ
        response.reset(); //����ҳ�治����,���buffer
        response.setCharacterEncoding("UTF-8"); //�ַ�����
        response.setContentType("multipart/form-data"); //�����ƴ�������
        //������Ӧͷ
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2�� ��ȡ�ļ�--������
        InputStream input=new FileInputStream(file);
        //3�� д���ļ�--�����
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4��ִ�� д������
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return "redirect:/index.jsp";
    }
}
