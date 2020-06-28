package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogDemo extends JFrame {
    public DialogDemo(){
        this.setVisible(true);
        this.setSize(700, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //容器
        Container container = this.getContentPane();
        //绝对布局
        container.setLayout(null);
        //按钮：
        JButton jButton = new JButton("Title");
        jButton.setBounds(100, 100, 200, 200);

        //弹出弹窗
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //弹窗
                new MyDialogDemo();
            }
        });

        container.add(jButton);
    }

    public static void main(String[] args) {
        new DialogDemo();
    }
}

class MyDialogDemo extends JDialog{
    public MyDialogDemo(){
        this.setVisible(true);
        this.setBounds(100, 100, 400, 400);
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container =  this.getContentPane();
        container.setLayout(null);

        JLabel jLabel = new JLabel("label");
        jLabel.setBounds(100, 100, 200, 200);

        container.add(jLabel);
    }
}