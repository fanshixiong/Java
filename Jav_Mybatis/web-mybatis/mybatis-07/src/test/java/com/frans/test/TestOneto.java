package com.frans.test;

import com.frans.dao.StudentMapper;
import com.frans.dao.TeacherMapper;
import com.frans.pojo.Student;
import com.frans.pojo.Teacher;
import com.frans.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestOneto {
    @Test
    public void getTeachers(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teachers = mapper.getTeachers(1);
        System.out.println(teachers);

        sqlSession.close();
    }  @Test
    public void getTeachers2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teachers = mapper.getTeachers2(1);
        System.out.println(teachers);

        sqlSession.close();
    }
    

}
