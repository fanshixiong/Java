package com.frans.dao;

import com.frans.pojo.Users;

import java.util.List;

public interface UserMapper {
    Users getUserById(int id);

    int addUsers(Users user);

    int updateUser(Users user);

    int deleteUser(int id);

    List<Users> getUserList();
}