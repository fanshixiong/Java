package com.frans.dao.user;

import com.frans.pojo.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {
    /**
     * 增加用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into shop.shop_user \n" +
            "(userId, " +
            "name, " +
            "password, " +
            "permitted," +
            "email," +
            "address," +
            "callPhone)\n" +
            "values(" +
            "#{userId}," +
            "#{userName}," +
            "#{userPassword}, " +
            "#{userPermitted}, " +
            "#{userEmail}, " +
            "#{userAddress}, " +
            "#{userCallPhone})\n" +
            "    ")
    public int add(User user)throws Exception;

    /**
     * 通过userName获取User
     * @param userName
     * @return
     * @throws Exception
     */
    public User getLoginUser(@Param("userName") String userName)throws Exception;

    /**
     * 通过userId获取user
     * @param id
     * @return
     * @throws Exception
     */

    public User getUserById(@Param("id") String id)throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @Update("update shop.shop_user \n " +
            "set name=#{userName}, " +
            "address=#{userAddress}" +
            "where id = #{id} ")
    public int modify(User user)throws Exception;


    /**
     * 修改当前用户密码
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    @Update("update shop.shop_user set password= #{pwd} where id = #{id}")
    public int updatePwd(@Param("id") String id, @Param("pwd") String pwd)throws Exception;
}
