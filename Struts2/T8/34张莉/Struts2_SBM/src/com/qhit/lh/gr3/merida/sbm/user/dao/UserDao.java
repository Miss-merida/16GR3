/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.user.dao;

import java.util.List;

import com.qhit.lh.gr3.merida.sbm.user.bean.User;

/**
 * @author ����
 * TODO
 * 2017��12��8������8:09:16
 */
public interface UserDao {
	/**
	 * @return
	 * ��ѯ���е��û�
	 * @throws Exception 
	 */
	public List<User> getAll() throws Exception;
	/**
	 * @param user
	 * @return
	 * ����û�
	 */
	public int addUser(User user);
	/**
	 * @param userName
	 * @param userPassword
	 * @return
	 * ��¼�����ݷ���
	 */
	public User doLogin(String userName,String userPassword);
}
