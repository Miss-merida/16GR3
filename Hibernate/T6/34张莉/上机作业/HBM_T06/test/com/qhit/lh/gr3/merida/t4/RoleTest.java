package com.qhit.lh.gr3.merida.t4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t4.bean.Emp;
import com.qhit.lh.gr3.merida.t4.bean.Role;
import com.qhit.lh.gr3.merida.t4.bean.User;
import com.qhit.lh.gr3.merida.t4.service.BaseService;
import com.qhit.lh.gr3.merida.t4.service.impl.BaseServiceImpl;

public class RoleTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		//新建一个角色
		Role role = new Role();
		role.setRoleName("高级翻译官");
		role.setMemo("外交");
		//获取账户
		User user = (User) baseService.getObjectById(User.class, 4);
		//建立角色和账户的关系
		role.getUser().add(user);
		
		baseService.add(role);
	}
	@Test
	public void delete(){
		Role role = (Role) baseService.getObjectById(Role.class, 3);
		
		baseService.delete(role);
	}
	@Test
	public void update(){
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		role.setMemo("代言人1");
		
		baseService.update(role);
	}
	
	@Test
	public void query(){
		Role role = (Role) baseService.getObjectById(Role.class, 1);
		
		for(User user:role.getUser()){
			System.out.println(role.getRoleName()+":"+user.getUserName());
		}
	}
	
}
