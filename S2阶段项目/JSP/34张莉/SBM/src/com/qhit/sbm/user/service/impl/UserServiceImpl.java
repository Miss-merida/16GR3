package com.qhit.sbm.user.service.impl;

import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.sbm.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().doLogin(userName, userPassword);
	}

	/* (non-Javadoc)
	 * @see com.qhit.sbm.user.service.UserService#addUser(com.qhit.sbm.user.bean.User)
	 */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return new UserDaoImpl().addUser(user);
	}

}
