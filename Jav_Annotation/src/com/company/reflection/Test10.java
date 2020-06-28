package com.company.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test10 {
    public void test01(Map<String,User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String,User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //加载的方法和参数
        Method test01 = Test10.class.getMethod("test01", Map.class, List.class);
        //获得泛型的参数类型
        Type[] genericParameterTypes = test01.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {  //打印泛型
            System.out.println("----" + genericParameterType);
            if(genericParameterType instanceof ParameterizedType){  //想知道里面的参数类型
                //强转获得真实的泛型信息
                Type[] types = ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type type : types) {
                    System.out.println(type);
                }
            }
        }

        Method test02 = Test10.class.getMethod("test02");
        //获得泛型的返回值类型
        Type genericReturnType = test02.getGenericReturnType();

        if(genericReturnType instanceof ParameterizedType){
            Type[] types = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type type : types) {
                System.out.println(type);
            }
        }
    }
}
