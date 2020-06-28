package com.company.reflection;


//双亲委派机制。如果存在一个和源码一样的包，java并不会加载你写的包，只会加载java包里的文件。
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统的类加载器
        System.out.println(ClassLoader.getSystemClassLoader());

        //获取系统的类加载器的父类加载器 --> 扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());

        //获取扩展类加载器的父类加载器 --> 根加载器(c/c++)
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        //测试当前类是由哪个加载器加载的
        System.out.println(Class.forName("com.company.reflection.Test07").getClassLoader());

        //测试JDK内置的类是谁加载的
        System.out.println(Class.forName("java.lang.Object").getClassLoader());

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
    }
}
