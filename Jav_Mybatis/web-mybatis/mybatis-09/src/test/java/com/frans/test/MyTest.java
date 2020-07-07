package com.frans.test;

import com.frans.dao.UserMapper;
import com.frans.pojo.User;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserByID(2);
        System.out.println(user);


        System.out.println("========================================");
        User user1 = mapper.queryUserByID(2);
        System.out.println(user1);
        System.out.println(user == user1);
        sqlSession.close();
    }


}
