package com.company.annotation;

import java.lang.annotation.*;

@MyAnnotation
public class Test01 {
    public static void main(String[] args) {

    }
}

//定义一个注解

//target表示注解可以用在哪些地方
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//Retention表示注解在哪里有效
//runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documeted 表示是否将注解生成在Javadoc中
@Documented

//Inherited表示 子类可以继承父类的注解
@Inherited

//自定义注解 @interface
@interface MyAnnotation{

}
