package com.company;


import javax.swing.*;
import java.awt.*;

//图标接口 实现
public class IconDemo extends JFrame implements Icon {
    private int width;
    private int height;

    public static void main(String[] args) {
        new IconDemo().init();
    }

    public IconDemo(){}

    public IconDemo(int width, int height){
        this.height = height;
        this.width = width;
    }

    public void init(){
        IconDemo iconDemo = new IconDemo(15, 15);

        JLabel jLabel = new JLabel("Title", iconDemo, SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(jLabel);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int i, int i1) {
        graphics.fillOval(i, i1, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
