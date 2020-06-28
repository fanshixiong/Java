package com.company;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestText {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        windowClose(myFrame);
    }
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);

        textField.addActionListener(new MyActionListener());
        //设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack(); //自适应

    }
}
