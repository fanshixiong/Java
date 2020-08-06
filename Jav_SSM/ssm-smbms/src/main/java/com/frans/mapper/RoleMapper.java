package com.frans.mapper;

import com.frans.pojo.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from smbms_role")
    public List<Role> getRoleList();
}
