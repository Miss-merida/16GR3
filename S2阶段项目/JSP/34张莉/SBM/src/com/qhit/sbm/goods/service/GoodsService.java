package com.qhit.sbm.goods.service;

import com.qhit.sbm.goods.bean.Goods;

public interface GoodsService {
	/**
	 * 
	 * 根据商品名称去查询商品信息
	 */
	public Goods getGoodsInfoByName(String goodsName);
	
	/**
	 * 更新库存
	 */
	public int updateStore(int num, int goodsId);
}
