package com.qhit.lh.gr3.merida.exam.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PageBean<T> implements Serializable {
	private static final long serialVersionUID = 3509375972998939764L;
	public static String CURRENT_INDEX = "currentIndex";
	public static String PAGE_SIZE = "pageSize";
	public static String INDEX="index";
	/**
	 * ��ǰҳ
	 */
	private int currentIndex;
	
	/**
	 * ÿҳ��¼��
	 */
	private int pageSize;
	
	/**
	 * �ܼ�¼��
	 */
	private int totalNumber;
	
	/**
	 * ��ҳ��
	 */
	private int totalPage;
	
	/**
	 * ��һҳ
	 */
	private int nextIndex;
	
	/**
	 * ��һҳ
	 */
	private int preIndex;
	
	/**
	 * ��ǰҳ�����ݼ�¼
	 */
	private List<T> Items;
	
	
	/**
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param totalNumber
	 * @param currentIndex
	 * @param pageSize
	 * @param items
	 */
	public PageBean(int totalNumber,int currentIndex,int pageSize,List<T> items){
		this.totalNumber = totalNumber;
		this.currentIndex = currentIndex;
		this.pageSize = pageSize;
		this.Items = items;
	}
	
	public PageBean() {
		this.pageSize = 10;
		this.Items = new ArrayList<>();
	}
	

	/**
	 * @param pageSize
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}
	
	/**
	 * @param currentIndex
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumber() {
		return totalNumber;
	}
	
	/**
	 * @param totalNumber
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		int size = this.totalNumber/this.pageSize;
		if(this.totalNumber%this.pageSize != 0){
			size = size + 1;
		}
		this.totalPage = size;
	}
	
	/**
	 * ��ҳ��
	 * @return
	 */
	public int getTotalPage() {
		return this.totalPage;
	}

	/**
	 * ��ǰҳ����һҳ�������ǰҳ���ڵ������һҳ
	 * ��ô��һҳ�������һҳ��
	 * 
	 * @return
	 */
	public int getNextIndex() {
		
		if(this.currentIndex >= this.getTotalPage()){
			this.nextIndex = this.currentIndex;
		}else{
			this.nextIndex = this.currentIndex + 1;
		}
		return nextIndex;
	}

	/**
	 * ��ǰҳ����һҳ�������ǰҳС�ڵ�һҳ��ô��һҳΪ1
	 * @return
	 */
	public int getPreIndex() {
		
		if(this.currentIndex <= 1){
			this.preIndex = 1;
		}else{
			this.preIndex = this.currentIndex -1;
		}
		
		return preIndex;
	}

	/**
	 * @return
	 */
	public List<T> getItems() {
		return Items;
	}
	
	/**
	 * @param items
	 */
	public void setItems(List<T> items) {
		Items = items;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.currentIndex+"|"+this.pageSize+"|"+this.totalNumber+"|"+this.totalPage;
	}
}
