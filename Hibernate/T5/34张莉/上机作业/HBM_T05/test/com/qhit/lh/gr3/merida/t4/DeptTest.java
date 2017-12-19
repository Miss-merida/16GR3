package com.qhit.lh.gr3.merida.t4;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t4.bean.Dept;
import com.qhit.lh.gr3.merida.t4.bean.Emp;
import com.qhit.lh.gr3.merida.t4.service.BaseService;
import com.qhit.lh.gr3.merida.t4.service.impl.BaseServiceImpl;

public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();
	
	@Test
	public void add() {
		//创建部门
		Dept dept = new Dept();
		dept.setDeptName("办公室");
		//没有员工
		
		//有新员工
		Emp zl = new Emp();
		zl.setEmpName("duoduo");
		zl.setEmpSex("f");
		zl.setBirthday("2018-08-01");

		dept.getEmps().add(zl);
		//do
		baseService.add(dept);
	}

	@Test
	public void delete(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 8);
		
		baseService.delete(dept);
	}
	
	@Test
	public void update(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 9);
		dept.setDeptName("蛋糕房");
		
		baseService.update(dept);
	}
	
	@Test
	public void query(){
		Dept dept = (Dept) baseService.getObjectById(Dept.class, 1);
		
		for(Emp emp:dept.getEmps()){
			System.out.println(dept.getDeptName()+":"+emp.getEmpName());
		}
	}
}
