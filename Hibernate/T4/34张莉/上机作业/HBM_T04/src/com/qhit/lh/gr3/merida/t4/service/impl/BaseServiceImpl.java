package com.qhit.lh.gr3.merida.t4.service.impl;

import java.util.List;

import com.qhit.lh.gr3.merida.t4.dao.BaseDao;
import com.qhit.lh.gr3.merida.t4.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.merida.t4.service.BaseService;

/**
 * @author ����
 * 2017��12��15������8:55:47
 * TODO
 */
public class BaseServiceImpl implements BaseService {
	private BaseDao baseDao = new BaseDaoImpl();
	
	@Override
	public void add(Object obj) {
		// TODO Auto-generated method stub
		baseDao.add(obj);
	}

	@Override
	public void delete(Object obj) {
		// TODO Auto-generated method stub
		baseDao.delete(obj);
	}

	@Override
	public void update(Object obj) {
		// TODO Auto-generated method stub
		baseDao.update(obj);
	}

	@Override
	public List<Object> getAll(String fromObject) {
		// TODO Auto-generated method stub
		return baseDao.getAll(fromObject);
	}

	@Override
	public Object getObjectById(Class clazz, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(clazz, id);
	}

}
