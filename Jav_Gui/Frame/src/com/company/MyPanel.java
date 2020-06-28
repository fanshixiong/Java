package com.company;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyPanel {
    //面板
    public static void main(String[] args) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        frame.setLayout(null);

        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(146, 154, 76));

        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(new Color(121, 203, 60, 165));

        frame.add(panel);

        frame.setVisible(true);

        //适配器模式：
        //事件监听，监听窗口关闭事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        System.out.println(2.0);
    }
}
