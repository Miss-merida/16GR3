package com.qhit.lh.gr3.merida.t1.dao;

import java.util.List;

/**
 * @author 张莉
 * TODO
 * 2017年12月11日下午9:46:07
 */
public interface BaseDao {
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
}
