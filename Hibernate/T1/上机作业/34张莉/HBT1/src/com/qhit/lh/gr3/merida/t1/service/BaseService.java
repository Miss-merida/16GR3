package com.qhit.lh.gr3.merida.t1.service;

import java.util.List;

/**
 * @author ����
 * TODO
 * 2017��12��11������9:44:58
 */
public interface BaseService {
	/**
	 * @param obj
	 * ��
	 */
	public void add(Object obj);
	
	/**
	 * @param obj
	 * ɾ
	 */
	public void delete(Object obj);
	
	/**
	 * @param obj
	 * ��
	 */
	public void update(Object obj);
	
	/**
	 * ��
	 */
	public List<Object> getAll(String fromObject);
}
