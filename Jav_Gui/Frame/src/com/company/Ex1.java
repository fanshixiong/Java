package com.company;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex1 {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(400, 400);
        frame.setLocation(300, 400);
        frame.setLayout(new GridLayout(2, 1));

        Panel p1 = new Panel(new BorderLayout());
        Panel p2 = new Panel(new GridLayout(2, 1));
        Panel p3 = new Panel(new BorderLayout());
        Panel p4 = new Panel(new GridLayout(2, 2));

        p1.add(new Button("E1"), BorderLayout.EAST);
        p1.add(new Button("W1"), BorderLayout.WEST);

        p2.add(new Button("p2-1"));
        p2.add(new Button("p2-2"));
        p1.add(p2, BorderLayout.CENTER);

        p3.add(new Button("E2"), BorderLayout.EAST);
        p3.add(new Button("W2"), BorderLayout.WEST);

        for(int i = 1; i <= 4; i++){
            p4.add(new Button("p4-" + i));
        }
        p3.add(p4, BorderLayout.CENTER);

        frame.add(p1);
        frame.add(p3);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        }); //lambda函数
    }
}
