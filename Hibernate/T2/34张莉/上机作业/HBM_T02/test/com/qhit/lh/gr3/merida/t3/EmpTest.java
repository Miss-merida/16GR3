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
	 * ���Ա����������һ���˻�
	 */
	@Test
	public void add() {
		//����Ա������
		Emp emp = new Emp();
		emp.setEname("pangpang");
		emp.setEsex("f");
		emp.setBirthday("2017-12-18");
		emp.setDeptId(1);
		//����һ���˻�
		User user = new User();
		user.setUname("pangpang");
		user.setPassword("123456");
		//����һ��һ��ϵ
		emp.setUser(user);//ָ����ǰԱ�����˻�
		user.setEmp(emp);//ָ����ǰ�˻�������Ա��

		//��������
		baseService.add(emp);

	}

	@Test
	public void delete() {
		Emp emp = new Emp();
		emp = (Emp) baseService.getObjectById(emp, 4);
		baseService.delete(emp);
	}

	@Test
	public void update() {
		//����Ա������
		Emp emp = new Emp();
		emp.setEid(1);
		emp.setEname("merida");
		emp.setEsex("F");
		emp.setBirthday("1998-08-01");
		emp.setDeptId(1);
		//����һ���˻�
		User user = new User();
		user.setUid(1);
		user.setUname("merida");
		user.setPassword("123456");
		//����һ��һ��ϵ
		emp.setUser(user);//ָ����ǰԱ�����˻�
		user.setEmp(emp);//ָ����ǰ�˻�������Ա��

		//��������
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
