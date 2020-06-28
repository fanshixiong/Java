package com.frans;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum  SingletonEnum {
    INSTANCE;

    public SingletonEnum getInstance(){
        return INSTANCE;
    }
}

class Test{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        /*
        SingletonEnum instance = SingletonEnum.INSTANCE;
        SingletonEnum instance1 = SingletonEnum.INSTANCE;

        System.out.println(instance);
        System.out.println(instance1);

         */

        SingletonEnum instance = SingletonEnum.INSTANCE;
        Constructor<SingletonEnum> declaredConstructor = SingletonEnum.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonEnum instance1 = declaredConstructor.newInstance();
        System.out.println(instance);
        System.out.println(instance1);
    }
}
