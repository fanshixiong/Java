package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
	    //Frame 看源码
        Frame frame = new Frame("My Windows");
        // 需要设置可见性
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setBackground(new Color(154, 72, 84));
        frame.setLocation(200, 200);

        //大小固定
        frame.setResizable(false);
        TestFrame frame1 = new TestFrame(100, 100, 200, 200, Color.blue);
        TestFrame frame2 = new TestFrame(200, 200, 200, 200, Color.gray);

    }
}
