package com.qhit.lh.gr3.merida.t4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t4.bean.Dept;
import com.qhit.lh.gr3.merida.t4.bean.Emp;
import com.qhit.lh.gr3.merida.t4.bean.User;
import com.qhit.lh.gr3.merida.t4.service.BaseService;
import com.qhit.lh.gr3.merida.t4.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();

	
	@Test
	public void add() {
		//新官上任
		Emp emp = new Emp();
		emp.setEmpName("张莉莉l");
		emp.setEmpSex("F");
		emp.setBirthday("1998-08-01");
		//账户密码
		User user = new User();
		user.setUserName("leader");
		user.setUserPassword("123456");
		user.setAddress("北京");
		//部门
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 9);
		
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//n-1
		emp.setDept(dept);
		
		baseService.add(emp);
	}

}
