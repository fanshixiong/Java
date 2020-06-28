package com.frans;

import javafx.scene.control.Tab;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//懒汉式单例模式
public class LazyMan {

    //红绿灯
    private static boolean frans_fan = false;

    private LazyMan() {
        synchronized (LazyMan.class){
            if(frans_fan == false){
                frans_fan = true;
            }else{
                throw new RuntimeException("不要使用反射破坏单例");
            }
            /*
            if(lazyMan != null){
                throw new RuntimeException("不要使用反射破坏单例");
            }*/
        }
        System.out.println(Thread.currentThread().getName() + "ok");
    }

    /**
     * Java并发编程
     * volatile关键字的两层语义
     * 　　一旦一个共享变量（类的成员变量、类的静态成员变量）被volatile修饰之后，那么就具备了两层语义：
     *
     * 　　1）保证了不同线程对这个变量进行操作时的可见性，即一个线程修改了某个变量的值，这新值对其他线程来说是立即可见的。
     *
     * 　　2）禁止进行指令重排序。
     */
    private static volatile LazyMan lazyMan; //volatile防止指令重排。

    //双重检测锁模式的懒汉式单例，DCL单例
    public static LazyMan getInstance(){
        //加锁
        if(lazyMan == null){
            synchronized (LazyMan.class){
                if(lazyMan == null){
                    lazyMan = new LazyMan();  //不是原子操作
                }
            }
        }

        return lazyMan;
    }

    //反射可以破坏单例
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Field frans_fan = LazyMan.class.getDeclaredField("frans_fan");
        frans_fan.setAccessible(true);


        //LazyMan instance = LazyMan.getInstance();
        Constructor<LazyMan> declaredConstructor = LazyMan.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyMan lazyMan = declaredConstructor.newInstance();

        frans_fan.set(lazyMan, false);

        LazyMan lazyMan1 = declaredConstructor.newInstance();

        System.out.println(lazyMan);
        System.out.println(lazyMan1);
    }

    /*
    //多线程并发问题
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LazyMan.getInstance();
            }).start();
        }
    }*/
}
/**
 * 1. 分配内存空间
 * 2. 执行构造方法，初始化对象
 * 3. 把这个对象指向这个空间
 *
 * 默认执行顺序 123
 * 但是可能会出现 132 的执行顺序，此时lazyman还没有完成构造
 */
