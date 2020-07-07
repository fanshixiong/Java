package com.frans.dao.user;

import com.frans.pojo.User;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserMapperImpl implements UserMapper{
    @Override
    public int add(User user) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int add = mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
        return add;
    }

    @Override
    public User getLoginUser(String userCode) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User loginUser = mapper.getLoginUser(userCode);
        sqlSession.close();
        return loginUser;
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList(userName, userRole, (currentPageNo-1)*pageSize, pageSize);

        sqlSession.close();
        return userList;
    }

    @Override
    public int getUserCount(String userName, int userRole) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int userCount = mapper.getUserCount(userName, userRole);
        sqlSession.close();
        return userCount;
    }

    @Override
    public int deleteUserById(Integer delId) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(delId);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }

    @Override
    public User getUserById(String id) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(id);
        sqlSession.close();
        return userById;
    }

    @Override
    public int modify(User user) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int modify = mapper.modify(user);
        sqlSession.commit();
        sqlSession.close();
        return modify;
    }

    @Override
    public int updatePwd(int id, String pwd) throws Exception {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updatePwd(id, pwd);
        sqlSession.commit();
        sqlSession.close();
        return i;
    }
}
