package com.company;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo extends JFrame {
    public static void main(String[] args) {
        new JButtonDemo();
    }

    public JButtonDemo(){
        Container container = this.getContentPane();
        //URL resource = JButtonDemo.class.getResource("1.jpg");
        //Icon icon = new ImageIcon(resource);

        JRadioButton radioButton1 = new JRadioButton("J1");
        JRadioButton radioButton2 = new JRadioButton("J2");
        JRadioButton radioButton3 = new JRadioButton("J3");

        //单选框只能选一个，分组
        ButtonGroup group = new ButtonGroup();
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);

        container.add(radioButton1, BorderLayout.WEST);
        container.add(radioButton2, BorderLayout.CENTER);
        container.add(radioButton3, BorderLayout.EAST);

        //多选框：
        JCheckBox checkBox1 = new JCheckBox("c1");
        JCheckBox checkBox2 = new JCheckBox("c2");

        container.add(checkBox1, BorderLayout.NORTH);
        container.add(checkBox2, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBounds(100, 100, 500, 500);
    }
}
