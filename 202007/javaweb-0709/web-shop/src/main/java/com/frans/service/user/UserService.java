package com.frans.service.user;

import com.frans.pojo.User;


public interface UserService {
	/**
	 * 增加用户信息
	 * @param user
	 * @return
	 */
	public boolean add(User user);
	
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public User login(String userCode, String userPassword);

	/**
	 * 根据ID查找user
	 * @param id
	 * @return
	 */
	public User getUserById(String id);

	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public boolean modify(User user);

	/**
	 * 根据userId修改密码
	 * @param id
	 * @param pwd
	 * @return
	 */
	public boolean updatePwd(String id, String pwd);
}
