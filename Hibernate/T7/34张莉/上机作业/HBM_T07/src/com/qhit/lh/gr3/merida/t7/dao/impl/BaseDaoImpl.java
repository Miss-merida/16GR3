package com.qhit.lh.gr3.merida.t7.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.merida.t7.bean.Emp;
import com.qhit.lh.gr3.merida.t7.dao.BaseDao;
import com.qhit.lh.gr3.merida.t7.utils.HibernateSessionFactory;

/**
 * @author 张莉
 * 2017年12月15日下午8:55:00
 * TODO
 */
public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		//1、获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2、开启事务
		Transaction ts = session.beginTransaction();
		//3、执行
		session.save(obj);
		//4、提交事务
		ts.commit();
		//5、释放资源
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.delete(obj);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Object obj) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，执行
		session.update(obj);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();

	}

	@Override
	public List<Object> getAll(String fromObject) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public Object getObjectById(Class clazz, int id) {
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Object obj = session.get(clazz, id);
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return obj;
	}

	@Override
	public List<Emp> getEmpByName(String name) {
		String hql = "select e from Emp e where e.empName like :name";
		//1,获取session对象
		Session session = HibernateSessionFactory.getSession();
		//2，开启事务
		Transaction ts = session.beginTransaction();
		//3，获取查询器对象
		Query query = session.createQuery(hql);
		query.setString("name", name);
		List<Emp> list = query.list();
		//4,提交事务
		ts.commit();
		//5，释放资源
		HibernateSessionFactory.closeSession();
		return list;
	}
}
