package com.frans.dao.user;

import com.frans.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    /**
     * 增加用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @Insert("insert into smbms_user \n" +
            "        (userCode,userName,userPassword,userRole,gender,birthday,phone,address,creationDate,createdBy)\n" +
            "\t    values(#{userCode},#{userName},#{userPassword},#{userRole},#{gender},#{birthday},#{phone},#{address},#{creationDate},#{createdBy})\n" +
            "    ")
    public int add(User user)throws Exception;

    /**
     * 通过userCode获取User
     * @param userCode
     * @return
     * @throws Exception
     */
    @Select("select * from smbms.smbms_user where userCode = #{userCode}")
    public User getLoginUser(@Param("userCode") String userCode)throws Exception;

    /**
     * 通过条件查询-userList
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    public List<User> getUserList(@Param("userName") String userName, @Param("userRole") int userRole, @Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize)throws Exception;
    /**
     * 通过条件查询-用户表记录数
     * @param userName
     * @param userRole
     * @return
     * @throws Exception
     */
    public int getUserCount(@Param("userName") String userName, @Param("userRole") int userRole)throws Exception;

    /**
     * 通过userId删除user
     * @param delId
     * @return
     * @throws Exception
     */
    @Delete("delete from smbms_user where id = #{delId}")
    public int deleteUserById(@Param("delId") Integer delId)throws Exception;


    /**
     * 通过userId获取user
     * @param id
     * @return
     * @throws Exception
     */
    @Select("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.id = #{id} and u.userRole = r.id")
    public User getUserById(@Param("id") String id)throws Exception;

    /**
     * 修改用户信息
     * @param user
     * @return
     * @throws Exception
     */
    @Update("update smbms_user \n " +
            "set userName=#{userName}, gender=#{gender},birthday=#{birthday},phone=#{phone},address=#{address},userRole=#{userRole},modifyBy=#{modifyBy},modifyDate=#{modifyData} where id = #{id} ")
    public int modify(User user)throws Exception;


    /**
     * 修改当前用户密码
     * @param id
     * @param pwd
     * @return
     * @throws Exception
     */
    @Update("update smbms_user set userPassword= #{pwd} where id = #{id}")
    public int updatePwd(@Param("id") int id, @Param("pwd") String pwd)throws Exception;


}
