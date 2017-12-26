package com.qhit.lh.gr3.merida.t7;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.qhit.lh.gr3.merida.t7.bean.Dept;
import com.qhit.lh.gr3.merida.t7.bean.Emp;
import com.qhit.lh.gr3.merida.t7.service.BaseService;
import com.qhit.lh.gr3.merida.t7.service.impl.BaseServiceImpl;
import com.qhit.lh.gr3.merida.t7.utils.HibernateSessionFactory;

public class DeptTest {
	private BaseService baseService = new BaseServiceImpl();

	@Test
	public void add() {
		//��������
		Dept dept = new Dept();
		dept.setDeptName("��ʳ��");
		
		baseService.add(dept);
	}

	@Test
	public void getDeptInfo(){
		//1.��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		
		//2.ͨ��session���󴴽�criteria������ѯ��
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emp", FetchMode.JOIN)
				.createAlias("emp", "e");
		
		//3.���÷��������Ͳ�ѯ���
		ProjectionList projectionList = Projections.projectionList()
				                   .add(Projections.groupProperty("deptId"))
				                   .add(Projections.groupProperty("deptName"))
				                   .add(Projections.count("e.deptId"));
		
		criteria.setProjection(projectionList);
		//ͨ��criteria������ѯ�����в�ѯ
		List<Object[]> list = criteria.list();
		
		//�������
		for (Object[] obj : list) {
			System.out.println(obj[0]+","+obj[1]+","+obj[2]);
		}
	}
}
