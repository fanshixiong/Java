package com.company;

import java.awt.*;

public class TestPaint {
    public static void main(String[] args) {
        new MyPaint().loadFrame();
    }
}
class MyPaint extends Frame{

    public void loadFrame(){
        setBounds(200, 200, 500, 400);
        setVisible(true);
    }
    //
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.fillOval(100, 100, 100, 100);
    }
}