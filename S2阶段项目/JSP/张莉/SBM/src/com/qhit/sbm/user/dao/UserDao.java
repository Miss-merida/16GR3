package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

public interface UserDao {
	/**
	 * @param userName
	 * @param passWord
	 * @return
	 * ��¼�����ݷ���
	 */
	public User doLogin(String userName, String userPassword);
}
