package com.qhit.lh.gr3.merida.t7;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t7.bean.Dept;
import com.qhit.lh.gr3.merida.t7.service.BaseService;
import com.qhit.lh.gr3.merida.t7.service.impl.BaseServiceImpl;

public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		//��������
		Dept dept = new Dept();
		dept.setDeptName("��ʳ��");
		
		baseService.add(dept);
	}

}
