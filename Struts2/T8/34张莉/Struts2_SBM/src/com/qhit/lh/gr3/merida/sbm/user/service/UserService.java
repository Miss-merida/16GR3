/**
 * 
 */
package com.qhit.lh.gr3.merida.sbm.user.service;

import java.util.List;

import com.qhit.lh.gr3.merida.sbm.user.bean.User;

/**
 * @author ����
 * TODO
 * 2017��12��8������8:11:08
 */
public interface UserService {
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
