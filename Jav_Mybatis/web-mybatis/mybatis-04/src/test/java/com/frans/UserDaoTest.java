package com.frans;

import com.frans.dao.UserMapper;
import com.frans.pojo.Users;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import org.apache.log4j.Logger;

public class UserDaoTest {
    static Logger logger = Logger.getLogger(UserDaoTest.class);
    @Test
    public void test(){
        //第一步：获得SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();


        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        logger.info("info: GetUserById");
        Users users = mapper.getUserById(0);
        System.out.println(users);

        sqlSession.close();
    }

    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUsers(new Users(12, 3, 4, 5));

        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new Users(0, 3, 5, 5));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(1);

        sqlSession.commit();
        sqlSession.close();
    }
}
