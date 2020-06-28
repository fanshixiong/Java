package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestCalc {
    public static void main(String[] args) {
        windowClose(new Calculator());
    }
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class Calculator extends Frame{
    //属性
    TextField num1, num2, res;
    //方法
    public Calculator(){
        this.LoadFrame();
    }
    public void LoadFrame(){
        // 3个文本框
        num1 = new TextField(10);
        num2 = new TextField(10);
        res = new TextField(20);

        // 1个按钮
        Button button = new Button("=");
        // 1个标签
        Label label = new Label("+");


        //button.addActionListener(new MyCalculatorListener(num1, num2, res));
        button.addActionListener(new MyCalculatorListener());



        //布局
        setLayout(new FlowLayout());

        add(num1);
        add(label);
        add(num2);
        add(button);
        add(res);

        pack();
        setVisible(true);

    }

    //更好的包装
    //内部类的最大好处就是可以畅通无阻地访问外部的属性和方法。
    private class MyCalculatorListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int n1 = Integer.parseInt(num1.getText());
            int n2 = Integer.parseInt(num2.getText());

            // 相加, 显示
            res.setText("" + (n1 + n2));

            //清除前两个框
            num1.setText("");
            num2.setText("");
        }
    }

}


//面向对象：
class MyCalculatorListener1 implements ActionListener{
    //private TextField num1, num2, res;

    //组合
    Calculator calculator = null;
    /*
    public MyCalculatorListener(TextField num1, TextField num2, TextField res){
        this.num1 = num1;
        this.num2 = num2;
        this.res = res;
    }*/
    public MyCalculatorListener1(Calculator calculator){
        this.calculator = calculator;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        // 获得num1, num2
        // num1.getText(); num2.getText();
        int num1 = Integer.parseInt(calculator.num1.getText());
        int num2 = Integer.parseInt(calculator.num2.getText());

        // 相加, 显示
        calculator.res.setText("" + (num1 + num2));

        //清除前两个框
        calculator.num1.setText("");
        calculator.num2.setText("");
    }
}
