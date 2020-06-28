package com.company.reflection;

import javafx.scene.control.Tab;

import javax.lang.model.element.Element;
import java.lang.annotation.*;
import java.lang.reflect.Field;

//反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class aClass = Class.forName("com.company.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        TableFrans tableFrans = (TableFrans)aClass.getAnnotation(TableFrans.class);
        String value = tableFrans.value();
        System.out.println(value);

        //获得类指定的注解
        Field name = aClass.getDeclaredField("id");
        FieldFrans annotation = name.getAnnotation(FieldFrans.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }
}

@TableFrans("DB_Student")
class Student2{

    @FieldFrans(columnName = "DB_id", type = "int", length = 10)
    private int id;
    @FieldFrans(columnName = "DB_age", type = "int", length = 10)
    private int age;
    @FieldFrans(columnName = "DB_name", type = "varchar", length = 20)
    private String name;

    public Student2() { }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableFrans{
    String value();
}


//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldFrans{
    String columnName();
    String type();
    int length();
}