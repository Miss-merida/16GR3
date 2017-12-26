package com.qhit.lh.gr3.merida.t7.dao;

import java.util.List;

import com.qhit.lh.gr3.merida.t7.bean.Emp;

/**
 * @author 张莉
 * 2017年12月15日下午8:54:27
 * TODO
 */
public interface BaseDao {
	
	public List<Emp> getEmpByName(String name);
	/**
	 * @param obj
	 * 增
	 */
	public void add(Object obj);
	
	/**
	 * @param obj
	 * 删
	 */
	public void delete(Object obj);
	
	/**
	 * @param obj
	 * 改
	 */
	public void update(Object obj);
	
	/**
	 * 查
	 */
	public List<Object> getAll(String fromObject);
	
	/**
	 * @param obj
	 * @param id
	 * @return
	 * 根据id去查
	 */
	public Object getObjectById(Class clazz, int id);
}
