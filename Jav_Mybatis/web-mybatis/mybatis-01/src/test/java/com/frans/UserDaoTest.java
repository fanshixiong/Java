package com.frans;

import com.frans.dao.UserDao;
import com.frans.pojo.Users;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        //方式一：getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Users> userList = userDao.getUserList();

        for (Users user : userList) {
            System.out.println(user);
        }



        //关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        Users users = mapper.getUserById(0);
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.addUsers(new Users(2, 3, 4, 5));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updataUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.updateUser(new Users(0, 3, 5, 5));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        mapper.deleteUser(1);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserDao mapper = sqlSession.getMapper(UserDao.class);


        Map<String, Object> map = new HashMap<String, Object>();

        map.put("id1",5);
        map.put("name2","2222333");
        map.put("password3","222333");
        map.put("address4","2333");

        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }
}
