package com.company;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestMouseListener {
    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame("mouse");
        windowClose(myFrame);
    }
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() { //匿名内部类
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class MyFrame extends Frame{
    ArrayList points;
    public MyFrame(String title){
        super(title);
        setBounds(100, 100, 400, 400);

        points = new ArrayList<>();

        this.addMouseListener(new MyMouseListener());

        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Iterator iterator = points.iterator();
        while(iterator.hasNext()){
            Point p = (Point) iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(p.x, p.y, 10, 10);
        }
    }

    public void addPoints(Point point){
        points.add(point);
    }
    //适配器模式
    private class MyMouseListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame myFrame = (MyFrame)e.getSource();
            //myFrame.addPoints(new Point(e.getX(), e.getY()));
            points.add(new Point(e.getX(), e.getY()));
            myFrame.repaint(); //刷新页面 重新记录
        }
    }

    private class MyFrameListener extends WindowAdapter{

    }
}
