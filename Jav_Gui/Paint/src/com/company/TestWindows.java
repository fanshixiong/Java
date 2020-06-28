package com.company;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestWindows {
    public static void main(String[] args) {
        new MyWindow();
    }
}

class MyWindow extends Frame{
    public MyWindow(){
        setBackground(Color.red);
        setBounds(100, 100, 200, 200);
        setVisible(true);
        //addWindowListener(new MyWindowListener());
        this.addWindowListener(new WindowAdapter() {  //匿名内部类
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
            }
        });
    }
    //内部类
    class MyWindowListener extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e) {
            setVisible(false); //隐藏窗口
            System.exit(0); //正常退出
        }
    }
}
