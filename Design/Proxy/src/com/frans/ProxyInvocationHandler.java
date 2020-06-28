package com.frans;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    //生成得到代理类
    public Object getProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }


    //处理代理实例
    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        //动态代理的本质，反射
        log(method.getName());
        return method.invoke(object, objects);
    }

    public void log(String msg){
        System.out.println("执行了" + msg);
    }


}
