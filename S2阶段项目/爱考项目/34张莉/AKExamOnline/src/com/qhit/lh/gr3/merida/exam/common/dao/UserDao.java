package com.qhit.lh.gr3.merida.exam.common.dao;

import com.qhit.lh.gr3.merida.exam.common.bean.User;

/**
 * @author 张莉
 * 2018年1月3日上午11:09:58
 * TODO
 */
public interface UserDao {

	/**
	 * @param user
	 * @return登录
	 */
	public User login(User user);
}
