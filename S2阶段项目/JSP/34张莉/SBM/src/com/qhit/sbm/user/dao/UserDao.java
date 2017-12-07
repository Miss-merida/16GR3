package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

/**
 * @author 张莉
 * TODO
 * 2017年12月6日上午9:38:26
 */
public interface UserDao {
	   /**
	 * @param user
	 * @return
	 * 添加
	 */
	public int addUser(User user);
		/**
		 * @param userName
		 * @param userPassword
		 * 登录的数据访问
		 */
	public User doLogin(String userName, String userPassword);
}
