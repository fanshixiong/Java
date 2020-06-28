package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.ImageObserver;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Frame frame = new Frame();
        Button button = new Button();

        //因为addActionListener需要一个ActionListener，所以需要构造一个ActionListener
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);

        frame.add(button, BorderLayout.CENTER);
        frame.pack(); //窗体最佳大小
        frame.setVisible(true);



        //两个按钮实现同一个监听
        Button button1 = new Button();
        Button button2 = new Button();

        MyMonitor myMonitor = new MyMonitor();
        button1.addActionListener(myMonitor);
        button2.addActionListener(myMonitor);
        frame.add(button1, BorderLayout.EAST);
        frame.add(button2, BorderLayout.WEST);

        windowClose(frame);
    }

    //关闭窗体：
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
