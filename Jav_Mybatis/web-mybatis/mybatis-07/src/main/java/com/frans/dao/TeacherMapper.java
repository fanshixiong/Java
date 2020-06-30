package com.frans.dao;

import com.frans.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //List<Teacher> getTeachers();

    Teacher getTeachers(@Param("tid") int id);
    Teacher getTeachers2(@Param("tid") int id);

}
