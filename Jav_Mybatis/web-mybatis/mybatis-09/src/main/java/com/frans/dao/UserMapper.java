package com.frans.dao;

import com.frans.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User queryUserByID(@Param("id") int id);
}
