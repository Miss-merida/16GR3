package com.qhit.sbm.common.dao;

import java.util.List;

public interface CommonDao {
	/**
	 * 
	 * �ܼ�¼����ҵ��
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
