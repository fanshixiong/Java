package com.company.reflection;

public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person pers = new Student();
        System.out.println(pers.name);

        //通过对象获得
        Class aClass = pers.getClass();
        System.out.println(aClass.hashCode());

        //通过forname获得
        Class aClass1 = Class.forName("com.company.reflection.Student");
        System.out.println(aClass1.hashCode());

        //通过类名.class获得
        System.out.println(Student.class.hashCode());
    }
}

class Person{
    String name;
    int id;

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "老师";
    }
}
