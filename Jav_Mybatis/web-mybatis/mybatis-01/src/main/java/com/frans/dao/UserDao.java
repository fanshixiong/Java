package com.frans.dao;

import com.frans.pojo.Users;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<Users> getUserList();

    Users getUserById(int id);

    int addUsers(Users user);

    int updateUser(Users user);

    int deleteUser(int id);

    int addUser2(Map<String,Object> map);
}