package com.qhit.sbm.user.dao;

import com.qhit.sbm.user.bean.User;

/**
 * @author ����
 * TODO
 * 2017��12��6������9:38:26
 */
public interface UserDao {
	   /**
	 * @param user
	 * @return
	 * ���
	 */
	public int addUser(User user);
		/**
		 * @param userName
		 * @param userPassword
		 * ��¼�����ݷ���
		 */
	public User doLogin(String userName, String userPassword);
}
