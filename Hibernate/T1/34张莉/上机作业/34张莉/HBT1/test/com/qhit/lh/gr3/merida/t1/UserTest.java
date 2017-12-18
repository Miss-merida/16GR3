package com.qhit.lh.gr3.merida.t1;


import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t1.bean.User;
import com.qhit.lh.gr3.merida.t1.service.BaseService;
import com.qhit.lh.gr3.merida.t1.service.impl.BaseServiceImpl;

public class UserTest {
	private BaseService baseService = new BaseServiceImpl();
	
	@Test
	public void addUser() {
		//������ʵ��������
		User user = new User();
		user.setUname("daweiwei");
		user.setUpwd("123456");
		user.setBirthday("2017-12-12");
		user.setSex("f");
		user.setEnable(1);
		//���ݲ���
		baseService.add(user);
	}

	@Test
	public void deleteUser(){
		//������ʵ��������
		User user = new User();
		user.setId(6);
		//��������
		baseService.delete(user);
	}
	@Test
	public void update(){
		//������ʵ��������
		User user = new User();
		user.setId(4);
		user.setUname("zhangli");
		user.setUpwd("8888");
		user.setBirthday("2017-12-12");
		user.setSex("m");
		user.setEnable(1);
		//���ݲ���
		baseService.update(user);
	}
	
	/**
	 * User:����
	 * user:������
	 * t_user:����
	 */
	@Test
	public void getAll(){
		List<Object> list =  baseService.getAll("from User");
		for (Object object : list) {
			User user = (User) object;
			System.out.println(user.toString());
		}
	}
}
