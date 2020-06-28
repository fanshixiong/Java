package com.company.reflection;

//测试类什么时候会初始化
public class Test06 {

    static {
        System.out.println("Main类被初始化");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用  父类没被引用，会先初始化它的父类
        Son son = new Son();

        //2.反射也会产生主动引用
//        Class aClass = Class.forName("com.company.reflection.Son");
//        System.out.println(aClass);

        //3.不会产生类的引用的方法b
//        System.out.println(Son.b);   //子类引用父类的静态方法或者变量，并不会让子类初始化

//        Son[] sons = new Son[8];    //这是一个名字和一片空间而已，并不会初始化类

//        System.out.println(Son.M);  //常量并不会引起父类和子类的初始化 常量在链接阶段就存入常量池中了

    }

}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被初始化");
    }
}

class Son extends Father {
    static int m = 100;
    static {
        System.out.println("子类被初始化");
        m = 300;
    }


    static final int M = 1;
}
