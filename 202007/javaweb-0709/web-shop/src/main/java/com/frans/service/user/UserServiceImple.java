package com.frans.service.user;

import com.frans.dao.user.UserMapper;
import com.frans.pojo.User;
import com.frans.tools.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
public class UserServiceImple implements UserService{
    @Override
    public boolean add(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        try{
            int add = userMapper.add(user);
            if(add > 0) {
                flag = true;
                System.out.println("add success!");
            }else{
                System.out.println("add failed!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public User login(String userCode, String userPassword) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try {
            user = userMapper.getLoginUser(userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(null != user){
            if(!user.getUserPassword().equals(userPassword)){
                user = null;
            }
        }
        return user;
    }

    @Test
    public void teset(){
        String username = "admin11";
        String pwd = "00000011";
        User user = new User();
        user.setUserName(username);
        user.setUserPassword(pwd);
        user.setUserPermitted("admin1");
        add(user);
    }
    @Override
    public User getUserById(String id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = null;
        try{
            user = userMapper.getUserById(id);
        }catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        sqlSession.close();
        return user;
    }

    @Override
    public boolean modify(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        try {
            if(userMapper.modify(user) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }

    @Override
    public boolean updatePwd(String id, String pwd) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean flag = false;
        try{
            if(userMapper.updatePwd(id, pwd) > 0)
                flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        sqlSession.commit();
        sqlSession.close();
        return flag;
    }
}
