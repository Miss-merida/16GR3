package com.qhit.sbm.common.service;

import java.util.List;

public interface CommonService {

	/**
	 * 
	 * �ܼ�¼����ҵ��
	 */
	public int getCount(String tableName, List<String> wheres, List<String> values);
}
