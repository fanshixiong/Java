package com.frans.dao;

import com.frans.pojo.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    Users getUserById(int id);

    int addUsers(Users user);

    int updateUser(Users user);

    int deleteUser(int id);

    List<Users> getUserList();

    //分页
    List<Users> getUserByLimit(Map<String, Integer> map);
}