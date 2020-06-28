package com.frans.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//监听案例
public class MyPanel{
    public static void main(String[] args) {
        Frame frame = new Frame("端午节快乐");
        Panel panel = new Panel(null);
        frame.setLayout(null);
        frame.setBounds(300, 300, 500, 500);
        frame.setBackground(new Color(121, 203, 60));
        panel.setBounds(20, 20, 300, 300);
        panel.setBackground(new Color(0, 255, 0));
        frame.add(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
            }
        });
    }
}
