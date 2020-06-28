package com.frans;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();

        //代理角色
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();

        //通过调用程序处理角色来处理想要的接口对象
        proxyInvocationHandler.setObject(host);

        Rent proxy = (Rent) proxyInvocationHandler.getProxy(); //Proxy是动态生成的

        proxy.rent();


        //2
        UserServiceImpl userService = new UserServiceImpl();
        proxyInvocationHandler.setObject(userService);

        UserService proxy1 = (UserService) proxyInvocationHandler.getProxy();
        proxy1.add();
    }
}
