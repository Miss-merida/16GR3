/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.user.service;

import java.util.List;

import com.qhit.lh.gr3.merida.sbm.user.bean.User;

/**
 * @author 张莉
 * TODO
 * 2017年12月8日下午8:11:08
 */
public interface UserService {
	/**
	 * @return
	 * 查询所有的用户
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	/**
	 * @param user
	 * @return
	 * 添加用户
	 */
	public int addUser(User user);
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * 登录的数据访问
	 */
	public User doLogin(String userName,String userPassword);

}
