package com.frans.service.role;

import com.frans.dao.role.RoleMapper;
import com.frans.dao.role.RoleMapperImpl;
import com.frans.pojo.Role;

import java.util.List;

public class RoleServiceImple implements RoleService{
    private RoleMapper roleMapper;
    public RoleServiceImple(){
        roleMapper = new RoleMapperImpl();
    }
    @Override
    public List<Role> getRoleList() {
        List<Role> roleList = null;
        try {
            roleList = roleMapper.getRoleList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roleList;
    }
}
