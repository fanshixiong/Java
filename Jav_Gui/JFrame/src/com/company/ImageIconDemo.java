package com.company;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public static void main(String[] args) {
        new ImageIconDemo();
    }

    public ImageIconDemo(){
        //获取图片地址
        JLabel jLabel = new JLabel("Image");
        URL url = ImageIconDemo.class.getResource("1.jpg");

        ImageIcon imageIcon = new ImageIcon(url);
        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(jLabel);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 400);
    }
}
