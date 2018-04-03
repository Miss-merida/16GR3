package com.qhit.lh.gr3.merida.exam.common.dao;

import org.hibernate.Session;

import com.qhit.lh.gr3.merida.exam.common.utils.HibernateSessionFactory;

/**
 * @author 张莉
 * 2018年1月3日上午11:12:19
 * TODO
 */
public class BaseDao {

	public Session getSession(){
		return HibernateSessionFactory.getSession();
	}
}
