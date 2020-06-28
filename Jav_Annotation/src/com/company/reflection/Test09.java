package com.company.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test09 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //获得Class对象
        Class aClass = Class.forName("com.company.reflection.User");

        //构造一个对象  此调用必须要有默认构造函数
        User user1 = (User) aClass.newInstance(); //本质是调用类的无参构造函数
        System.out.println(user1);  //调用默认构造方法

        //通过构造器创建对象
        Constructor constructor = aClass.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User) constructor.newInstance("frans", 2, 3);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)aClass.newInstance();
        //通过反射获取一个方法
        Method setName = aClass.getDeclaredMethod("setName", String.class);

        //激活： （对象， 方法的值）
        setName.invoke(user3, "frans");
        System.out.println(user3.getName());


        //通过反射操作属性
        User user4 = (User) aClass.newInstance();
        Field name = aClass.getDeclaredField("name");

        //不能直接私有属性，需要关闭程序的安全监测
        name.setAccessible(true); //

        name.set(user4 ,"frans2");
        System.out.println(user4.getName());
    }
}

