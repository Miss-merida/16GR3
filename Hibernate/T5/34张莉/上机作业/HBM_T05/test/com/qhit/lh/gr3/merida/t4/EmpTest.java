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
		//�¹�����
		Emp emp = new Emp();
		emp.setEmpName("rose");
		emp.setEmpSex("F");
		emp.setBirthday("1912-04-14");
		//�˻�����
		User user = new User();
		user.setUserName("forever");
		user.setUserPassword("999999");
		user.setAddress("Ӣ���ϰ��ն�");
		//����
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
		
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//n-1
		emp.setDept(dept);
		
		baseService.add(emp);
	}

}
