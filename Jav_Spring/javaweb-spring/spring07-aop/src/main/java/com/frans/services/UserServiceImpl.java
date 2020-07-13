package com.frans.services;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除");
    }

    @Override
    public void query() {
        System.out.println("查询");
    }

    @Override
    public void update() {
        System.out.println("更新");
    }
}
