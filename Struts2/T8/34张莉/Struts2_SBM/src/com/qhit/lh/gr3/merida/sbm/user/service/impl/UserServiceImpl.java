/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.user.service.impl;

import java.util.List;

import com.qhit.lh.gr3.merida.sbm.user.bean.User;
import com.qhit.lh.gr3.merida.sbm.user.dao.UserDao;
import com.qhit.lh.gr3.merida.sbm.user.dao.impl.UserDaoImpl;
import com.qhit.lh.gr3.merida.sbm.user.service.UserService;

/**
 * @author 张莉
 * TODO
 * 2017年12月8日下午8:11:36
 */
public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.merida.sbm.user.service.UserService#getAll()
	 */
	@Override
	public List<User> getAll() throws Exception {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.merida.sbm.user.service.UserService#addUser(com.qhit.lh.gr3.merida.sbm.user.bean.User)
	 */
	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.merida.sbm.user.service.UserService#doLogin(java.lang.String, java.lang.String)
	 */
	@Override
	public User doLogin(String userName, String userPassword) {
		// TODO Auto-generated method stub
		return userDao.doLogin(userName, userPassword);
	}

}
