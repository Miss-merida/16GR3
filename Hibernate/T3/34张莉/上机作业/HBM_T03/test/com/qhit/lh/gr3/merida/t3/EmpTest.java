package com.qhit.lh.gr3.merida.t3;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t3.bean.Emp;
import com.qhit.lh.gr3.merida.t3.bean.User;
import com.qhit.lh.gr3.merida.t3.service.BaseService;
import com.qhit.lh.gr3.merida.t3.service.impl.BaseServiceImpl;

public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	/**
	 * 添加员工，并分配一个账户
	 */
	@Test
	public void add() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEname("zhangli");
		emp.setEsex("m");
		emp.setBirthday("2016-12-18");
		emp.setDeptId(2);
		
		//分配一个账户
		User user = new User();
		user.setUname("zhangli");
		user.setPassword("123123");
		//员工
		//emp = (Emp) baseService.getObjectById(Emp.class, 2);
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工

		//级联操作
		baseService.add(emp);

	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(Emp.class, 2);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		//声明员工对象
		Emp emp = new Emp();
		emp.setEid(1);
		emp.setEname("merida");
		emp.setEsex("F");
		emp.setBirthday("1998-08-01");
		emp.setDeptId(1);
		//分配一个账户
		User user = new User();
		user.setUid(1);
		user.setUname("merida");
		user.setPassword("123456");
		//建立一对一关系
		emp.setUser(user);//指定当前员工的账户
		user.setEmp(emp);//指定当前账户所属的员工

		//级联操作
		baseService.update(emp);
	}

	@Test
	public void query() {
		List<Object> list = baseService.getAll("from Emp");
		
		for (Object object : list) {
			Emp emp = (Emp) object;
			System.out.println(emp.toString());
		}
	}

}
