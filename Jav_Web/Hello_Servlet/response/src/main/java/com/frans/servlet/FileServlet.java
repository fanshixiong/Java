package com.frans.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1. 要获取下载文件的路径
         * 2. 下载的文件名是啥？
         * 3. 设置想办法让浏览器能够支持下载我们需要的东西
         * 4. 获取下载文件的输入流
         * 5. 创建缓冲区
         * 6. 获取OutputStream对象
         * 7. 将FileOutputStream流写入到buffer缓冲区
         * 8. 使用OutputStream将缓冲区中的数据输出到客户端！
         */

        //String realPath = this.getServletContext().getRealPath("/1.png");
        String realPath = "F:\\Java\\Java_Study\\Jav_Web\\Hello_Servlet\\response\\target\\classes\\frans.png";

        String filename = realPath.substring(realPath.lastIndexOf("\\") + 1);

        resp.setHeader("Content-Disposition", "attachment;filename" + URLEncoder.encode(filename, "utf-8"));

        FileInputStream fileInputStream = new FileInputStream(realPath);
        int len = 0;
        byte[] buffer = new byte[1024];

        ServletOutputStream outputStream = resp.getOutputStream();
        while ((len = fileInputStream.read(buffer)) > 0){
            outputStream.write(buffer, 0, len);
        }
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
