package com.company;

import java.awt.*;

public class TestFrame extends Frame {
    static int id = 0;
    public TestFrame(int x, int y, int w, int h, Color col){
        super("MyFrame:" + (++id));
        setBounds(x, y, w, h);
        setBackground(col);
        setVisible(true);

    }
}
