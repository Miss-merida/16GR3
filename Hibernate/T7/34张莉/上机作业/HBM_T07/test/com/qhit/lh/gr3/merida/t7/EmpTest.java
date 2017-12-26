package com.qhit.lh.gr3.merida.t7;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.qhit.lh.gr3.merida.t7.bean.Dept;
import com.qhit.lh.gr3.merida.t7.bean.Emp;
import com.qhit.lh.gr3.merida.t7.bean.User;
import com.qhit.lh.gr3.merida.t7.service.BaseService;
import com.qhit.lh.gr3.merida.t7.service.impl.BaseServiceImpl;


/**
 * @author 张莉
 * 2017年12月24日下午11:07:31
 * TODO
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	
	@Test
	public void add() {
		
		//招人
		Emp emp = new Emp();
		emp.setEmpName("天天");
		emp.setEmpSex("m");
		emp.setBirthday("2017-12-25");
		
		//分帐户
		User user = new User();
		user.setUserName("tiantian");
		user.setUserPassword("222222");
		user.setAddress("南京");
		
		//部门
	    Dept dept = (Dept) baseService.getObjectById(Dept.class, 14);
		//1-1
		emp.setUser(user);
		user.setEmp(emp);
		//n-1
		emp.setDept(dept);
		
		baseService.add(emp);
	}
	
	@Test
	public void query(){
		List<Object> list = baseService.getAll("from Emp");
		Emp emp ;
		for(Object object : list){
			emp =  (Emp) object;
			System.out.println(emp.toString());
		}
	}
	/**
	 * 根据姓名查询
	 * 
	 */
	@Test
	public void getEmpByName(){
		List<Emp> list = baseService.getEmpByName("%京%");
		
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}

}
