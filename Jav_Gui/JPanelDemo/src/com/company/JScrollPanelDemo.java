package com.company;

import javax.swing.*;
import java.awt.*;

public class JScrollPanelDemo extends JFrame {
    public static void main(String[] args) {
        new JScrollPanelDemo();
    }

    public JScrollPanelDemo() {
        Container container = this.getContentPane();

        //文本域
        JTextArea jTextArea = new JTextArea(20, 50);
        jTextArea.setText("Text");

        //Scroll 面板：
        JScrollPane jScrollPane = new JScrollPane(jTextArea);

        container.add(jScrollPane);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 400, 400);
    }
}
