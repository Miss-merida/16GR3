package com.qhit.lh.gr3.merida.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import com.qhit.lh.gr3.merida.exam.common.bean.PageBean;
import com.qhit.lh.gr3.merida.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.merida.exam.sjgl.bean.PaperClass;

public interface PaperDao {

	/**
	 * @param paper
	 */
	public void createByChoose(Paper paper);
	
	/**
	 * @param paperClasses
	 * 开始考试
	 */
	public void startExam(List<PaperClass> paperClasses);
	
	/**
	 * @param paper
	 * @param state
	 * 结束考试
	 */
	public void updateExam(Paper paper,String state);
	
	/**
	 * @param paper
	 * 随机组卷
	 */
	public void createPaperRandom(Paper paper);
	
	/**
	 * @param pageBean
	 * @param parameter
	 * @param pageIndex
	 * @return
	 */
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,Map<String,Object> parameter,int pageIndex);
}
