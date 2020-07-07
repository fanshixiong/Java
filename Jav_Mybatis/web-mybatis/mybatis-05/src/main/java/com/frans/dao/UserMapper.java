package com.frans.dao;

import com.frans.pojo.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * \n" +
            "from users \t")
    List<Users> getUsers();

    @Select("select * from users where id = #{id}")
    Users getUserByID(@Param("id") int id2);

    @Insert("insert into users(id, name, password, address) values(#{id}, #{name}, #{password}, #{address})")
    int addUser(Users users);

    @Update("update users set name = #{name}, password = #{password} where id = #{id}")
    int updateUser(Users user);

    @Delete("delete from users where id = #{id}")
    int deleteUser(@Param("id") int id2);
}