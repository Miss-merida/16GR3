package com.qhit.lh.gr3.merida.t3.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.merida.t3.dao.BaseDao;
import com.qhit.lh.gr3.merida.t3.utils.HibernateSessionFactory;

public class BaseDaoImpl implements BaseDao {

	@Override
	public void add(Object obj) {
		//1,��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		//2����������
		Transaction ts = session.beginTransaction();
		//3��ִ��
		session.save(obj);
		//4,�ύ����
		ts.commit();
		//5���ͷ���Դ
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Object obj) {
		//1,��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		//2����������
		Transaction ts = session.beginTransaction();
		//3��ִ��
		session.delete(obj);
		//4,�ύ����
		ts.commit();
		//5���ͷ���Դ
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Object obj) {
		//1,��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		//2����������
		Transaction ts = session.beginTransaction();
		//3��ִ��
		session.update(obj);
		//4,�ύ����
		ts.commit();
		//5���ͷ���Դ
		HibernateSessionFactory.closeSession();

	}

	@Override
	public List<Object> getAll(String fromObject) {
		//1,��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		//2����������
		Transaction ts = session.beginTransaction();
		//3����ȡ��ѯ������
		Query query = session.createQuery(fromObject);
		List<Object> list = query.list();
		//4,�ύ����
		ts.commit();
		//5���ͷ���Դ
		HibernateSessionFactory.closeSession();
		return list;
	}

	@Override
	public Object getObjectById(Object obj, int id) {
		//1,��ȡsession����
		Session session = HibernateSessionFactory.getSession();
		//2����������
		Transaction ts = session.beginTransaction();
		//3����ȡ��ѯ������
		obj = session.get(obj.getClass(), id);
		//4,�ύ����
		ts.commit();
		//5���ͷ���Դ
		HibernateSessionFactory.closeSession();
		return obj;
	}
}
