package com.company;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class MyKey {
    public static void main(String[] args) {
        new MyKeyX();
    }
}
class MyKeyX extends Frame{
    public MyKeyX(){
        setBounds(100, 100, 200, 200);
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            //键盘按下
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode =  e.getKeyCode();
                if(keyCode == KeyEvent.VK_UP){
                    System.out.println("press on up");
                }
            }
        });
    }
}
