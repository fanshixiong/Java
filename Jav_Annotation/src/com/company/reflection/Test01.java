package com.company.reflection;

public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException {

        //通过反射获取类的class对象
        Class aClass = Class.forName("com.company.reflection.User");
        System.out.println(aClass);

        Class aClass1 = Class.forName("com.company.reflection.User");
        Class aClass2 = Class.forName("com.company.reflection.User");
        Class aClass3 = Class.forName("com.company.reflection.User");
        Class aClass4 = Class.forName("com.company.reflection.User");

        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都被封装在Class对象中
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
        System.out.println(aClass4.hashCode());
    }
}


//entity   pojo
//Java Bean
class User{
    private String name;
    private int id;
    private int age;

    public User() {}

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }
}
