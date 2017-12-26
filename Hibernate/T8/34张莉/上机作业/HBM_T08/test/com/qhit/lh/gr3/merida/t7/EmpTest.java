package com.qhit.lh.gr3.merida.t7;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.merida.t7.bean.Dept;
import com.qhit.lh.gr3.merida.t7.bean.Emp;
import com.qhit.lh.gr3.merida.t7.bean.User;
import com.qhit.lh.gr3.merida.t7.service.BaseService;
import com.qhit.lh.gr3.merida.t7.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.merida.t7.utils.HibernateSessionFactory;


/**
 * @author ����
 * 2017��12��24������11:07:31
 * TODO
 */
public class EmpTest {
	private BaseService baseService = new BaseServiceImpl();
	
	@Test
	public void add() {
		
		//����
		Emp emp = new Emp();
		emp.setEmpName("����");
		emp.setEmpSex("m");
		emp.setBirthday("2017-12-25");
		
		//���ʻ�
		User user = new User();
		user.setUserName("tiantian");
		user.setUserPassword("222222");
		user.setAddress("�Ͼ�");
		
		//����
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
	 * ����������ѯ
	 * 
	 */
	@Test
	public void getEmpByName(){
		List<Emp> list = baseService.getEmpByName("%��%");
		
		for(Emp emp : list){
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}
	
	@Test
	public void getEmpLikeName(){
		//��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		
		//ͨ��session���󴴽�criteria������ѯ��
		Criteria criteria = session.createCriteria(Emp.class)
				.add(Restrictions.like("empName", "%��"));
		
		//ͨ��criteria������ѯ�����в�ѯ
		List<Emp> list = criteria.list();
		
		//�������
		for (Emp emp : list) {
			System.out.println(emp.getEmpId()+":"+emp.getEmpName());
		}
	}

	
}
