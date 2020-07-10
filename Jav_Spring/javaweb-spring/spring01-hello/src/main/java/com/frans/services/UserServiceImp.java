package com.frans.services;

import com.frans.dao.UserDao;
import com.frans.dao.UserDaoImp;

public class UserServiceImp implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }

}
