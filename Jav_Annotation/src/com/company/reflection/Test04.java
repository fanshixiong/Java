package com.company.reflection;

public class Test04 {

    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /**
         * 1.加载到内存，会产生一个类对应的Class对象
         * 2.链接，链接结束后m=0  链接：把Java的二进制代码合并到JVM运行状态之中的过程
         * 3.初始化
         * <clinit>(){
         *      System.out.println("A类静态代码块初始化");
         *      m = 300;
         *      m = 100;
         * }
         * m = 100
         */
    }
    /**
     * 1. 加载到内存，会产生一个类对应的Class对象
     * 2. 链接，链接结束后m = 0 链接：把Java的二进制代码合并到JVM的运行状态中的过程。
     * 3. 初始化
     * <clinit>(){
     *     System.out.println("A类静态代码初始化");
     *     m = 300;
     *     m = 100;
     * }</clinit>
     * m = 100
     */

}

class A {
    //①
    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }
    // ②
    static int m = 100;

    //① 和 ② 顺序交换结果会不同。
    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
