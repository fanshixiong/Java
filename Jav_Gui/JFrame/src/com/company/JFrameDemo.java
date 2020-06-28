package com.company;

import javax.swing.*;
import java.awt.*;

public class JFrameDemo {
    public void init(){
        JFrame frame = new JFrame("title");
        frame.setBounds(100, 100, 200, 200);
        frame.setVisible(true);
        frame.setBackground(Color.ORANGE);
        //设置文字
        JLabel jLabel = new JLabel("my label");
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.add(jLabel);

        frame.getContentPane().setBackground(Color.GRAY);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JFrameDemo().init();
    }

}
