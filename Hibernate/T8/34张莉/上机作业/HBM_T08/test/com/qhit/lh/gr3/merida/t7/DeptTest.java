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
		//创建部门
		Dept dept = new Dept();
		dept.setDeptName("零食部");
		
		baseService.add(dept);
	}

	@Test
	public void getDeptInfo(){
		//1.获取session对象
		Session session = HibernateSessionFactory.getSession();
		
		//2.通过session对象创建criteria条件查询器
		Criteria criteria = session.createCriteria(Dept.class)
				.setFetchMode("emp", FetchMode.JOIN)
				.createAlias("emp", "e");
		
		//3.设置分组条件和查询结果
		ProjectionList projectionList = Projections.projectionList()
				                   .add(Projections.groupProperty("deptId"))
				                   .add(Projections.groupProperty("deptName"))
				                   .add(Projections.count("e.deptId"));
		
		criteria.setProjection(projectionList);
		//通过criteria条件查询器进行查询
		List<Object[]> list = criteria.list();
		
		//遍历输出
		for (Object[] obj : list) {
			System.out.println(obj[0]+","+obj[1]+","+obj[2]);
		}
	}
}
