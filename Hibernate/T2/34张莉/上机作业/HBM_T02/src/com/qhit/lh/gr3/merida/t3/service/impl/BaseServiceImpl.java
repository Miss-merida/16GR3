package com.qhit.lh.gr3.merida.t3.service.impl;

import java.util.List;

import com.qhit.lh.gr3.merida.t3.dao.BaseDao;
import com.qhit.lh.gr3.merida.t3.dao.impl.BaseDaoImpl;
import com.qhit.lh.gr3.merida.t3.service.BaseService;

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
	public Object getObjectById(Object obj, int id) {
		// TODO Auto-generated method stub
		return baseDao.getObjectById(obj, id);
	}
}
