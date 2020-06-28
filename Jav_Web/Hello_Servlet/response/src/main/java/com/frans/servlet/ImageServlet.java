package com.frans.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //如何让浏览器3秒自动刷新一次
        resp.setHeader("refresh", "3");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);

        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();
        //设置图片的背景颜色
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 80, 20);

        //给图片写数据
        graphics.setColor(Color.cyan);
        graphics.setFont(new Font(null, Font.BOLD, 20));
        graphics.drawString(getRandomNum(), 0, 20);

        //告诉浏览器，这个请求用图片的方式打开
        resp.setContentType("image/jpg");
        //网站存在缓存，不要让浏览器存在缓存。
        resp.setDateHeader("expries", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragam", "no-cache");

        //把图片写给浏览器
        ImageIO.write(image, "jpg", resp.getOutputStream());
    }

    private String getRandomNum() {
        Random random = new Random();
        String num = random.nextInt(9999) + "";
        StringBuffer buffer = new StringBuffer();
        for(int i = 0; i < 4-num.length(); i++){
            buffer.append("0");
        }
        return buffer.toString() + num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
