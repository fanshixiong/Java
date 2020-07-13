package com.frans.annotion;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotionPointCut {
    @Before("execution(* com.frans.services.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("方法执行前---------------------------------------");
    }

    @After("execution(* com.frans.services.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("方法执行后---------------------------------------");
    }

    @Around("execution(* com.frans.services.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("-------------执行前");

        Signature signature = proceedingJoinPoint.getSignature();//获得签名
        System.out.println(signature);
        //执行方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("-------------执行后");

        System.out.println(proceed);
    }
}
