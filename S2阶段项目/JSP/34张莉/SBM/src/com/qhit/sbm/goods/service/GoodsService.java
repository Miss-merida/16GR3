package com.qhit.sbm.goods.service;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsService {
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
