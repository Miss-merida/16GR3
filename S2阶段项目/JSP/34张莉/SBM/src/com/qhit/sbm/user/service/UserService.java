package com.qhit.sbm.user.service;

import com.qhit.sbm.user.bean.User;

public interface UserService {
	/*
	 * 
	 * µÇÂ¼µÄÒµÎñ
	 */
	public User doLogin(String userName, String userPassword);

	/**
	 * @param user
	 * @return
	 */
	public int addUser(User user);
}
