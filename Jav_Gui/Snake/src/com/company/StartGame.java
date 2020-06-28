package com.company;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Snake");

        jFrame.setBounds(10, 10, 900, 720);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.add(new GamePanel());
        jFrame.setVisible(true);
    }
}
