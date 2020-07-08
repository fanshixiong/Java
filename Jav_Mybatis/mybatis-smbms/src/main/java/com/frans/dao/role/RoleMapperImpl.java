package com.frans.dao.role;

import com.frans.pojo.Role;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleMapperImpl implements RoleMapper{
    @Override
    public List<Role> getRoleList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RoleMapper mapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = mapper.getRoleList();
        sqlSession.close();
        return roleList;
    }
}
