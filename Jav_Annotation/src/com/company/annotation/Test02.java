package com.company.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test02 {

    //注解可以显示赋值，如果没有默认值则必须赋值
    @MyAnnotation2(name = "frans")
    public void test() { }

    @MyAnnotation3("frans")
    public void test2(){}
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{

    //注解的参数：参数类型 + 参数名称 ();
    String name() default "";
}

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{

    String value();
}