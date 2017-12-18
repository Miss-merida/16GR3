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
		//声明并实例化对象
		User user = new User();
		user.setUname("daweiwei");
		user.setUpwd("123456");
		user.setBirthday("2017-12-12");
		user.setSex("f");
		user.setEnable(1);
		//数据操作
		baseService.add(user);
	}

	@Test
	public void deleteUser(){
		//声明并实例化对象
		User user = new User();
		user.setId(6);
		//操作对象
		baseService.delete(user);
	}
	@Test
	public void update(){
		//声明并实例化对象
		User user = new User();
		user.setId(4);
		user.setUname("zhangli");
		user.setUpwd("8888");
		user.setBirthday("2017-12-12");
		user.setSex("m");
		user.setEnable(1);
		//数据操作
		baseService.update(user);
	}
	
	/**
	 * User:类名
	 * user:对象名
	 * t_user:表名
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
