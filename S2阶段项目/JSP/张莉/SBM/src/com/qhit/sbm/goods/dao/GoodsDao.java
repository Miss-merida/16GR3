package com.qhit.sbm.goods.dao;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsDao {
	/**
	 * 
	 * ������Ʒ����ȥ��ѯ��Ʒ��Ϣ
	 */
	public Goods getGoodsInfoByName(String goodsName);
	
	/**
	 * ���¿��
	 */
	public int updateStore(int num, int goodsId);
}
