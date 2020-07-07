package com.frans.service.user;

import com.frans.dao.user.UserMapper;
import com.frans.dao.user.UserMapperImpl;
import com.frans.pojo.User;
import com.frans.tools.MybatisUtils;

import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
public class UserServiceImple implements UserService{
    private UserMapper userMapper;
    public UserServiceImple(){
        userMapper = new UserMapperImpl();
    }
    @Override
    public boolean add(User user) {
        MybatisUtils
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
        return flag;
    }

    @Override
    public User login(String userCode, String userPassword) {
        return null;
    }

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        return null;
    }

    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        return 0;
    }

    @Override
    public User selectUserCodeExist(String userCode) {
        return null;
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        return false;
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public boolean modify(User user) {
        return false;
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        return false;
    }
}
