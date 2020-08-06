package com.frans.service.user;

import com.frans.mapper.UserMapper;
import com.frans.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * service层捕获异常，进行事务处理
 * 事务处理：调用不同dao的多个方法，必须使用同一个connection（connection作为参数传递）
 * 事务完成之后，需要在service层进行connection的关闭，在dao层关闭（PreparedStatement和ResultSet对象）
 * @author Administrator
 *
 */
@Transactional
@Service("userService")
public class UserServiceImple implements UserService{

    @Autowired
    @Qualifier("userMapper")
    private UserMapper userMapper;

    @Override
    public boolean add(User user) {
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

    @Override
    public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = null;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        System.out.println("currentPageNo ---- > " + currentPageNo);
        System.out.println("pageSize ---- > " + pageSize);
        try {
            userList = userMapper.getUserList(queryUserName,queryUserRole,currentPageNo,pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int getUserCount(String queryUserName, int queryUserRole) {
        int count = 0;
        System.out.println("queryUserName ---- > " + queryUserName);
        System.out.println("queryUserRole ---- > " + queryUserRole);
        try {
            count = userMapper.getUserCount(queryUserName,queryUserRole);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public User selectUserCodeExist(String userCode) {
        User user = null;
        try {
            user = userMapper.getLoginUser( userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean deleteUserById(Integer delId) {
        boolean flag = false;
        try {
            if(userMapper.deleteUserById(delId) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        try{
            user = userMapper.getUserById(id);
        }catch (Exception e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }

    @Override
    public boolean modify(User user) {
        boolean flag = false;
        try {
            if(userMapper.modify(user) > 0)
                flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public String checkPwd(int id, String oldpassword) {
        int result = userMapper.checkPwd(id, oldpassword);
        return result == 1 ? "true" : "false";
    }

    @Override
    public boolean updatePwd(int id, String pwd) {
        boolean flag = false;
        try{
            if(userMapper.updatePwd(id,pwd) > 0)
                flag = true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
