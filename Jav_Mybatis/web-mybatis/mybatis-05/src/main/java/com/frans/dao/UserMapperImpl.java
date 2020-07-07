package com.frans.dao;

import com.frans.pojo.Users;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperImpl implements UserMapper{

    @Override
    public List<Users> getUsers() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Users> users = mapper.getUsers();
        for (Users user : users) {
            System.out.println(user);
        }
        sqlSession.close();
        return users;
    }
    @Test
    public void getUsertest(){
        List<Users> users = getUsers();
        for (Users user : users) {
            System.out.println(user);
        }

        Users userByID = getUserByID(1);
        System.out.println(userByID);
    }

    @Override
    public Users getUserByID(int id2) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users userByID = mapper.getUserByID(id2);
        System.out.println(userByID);
        sqlSession.close();
        return userByID;
    }

    @Override
    public int addUser(Users users) {
        return 0;
    }

    @Override
    public int updateUser(Users user) {
        return 0;
    }

    @Override
    public int deleteUser(int id2) {
        return 0;
    }

}
