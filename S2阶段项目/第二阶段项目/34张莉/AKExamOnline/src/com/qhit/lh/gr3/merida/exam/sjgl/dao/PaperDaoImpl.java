package com.qhit.lh.gr3.merida.exam.sjgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Transaction;

import com.qhit.lh.gr3.merida.exam.bjgl.bean.ClassInfo;
import com.qhit.lh.gr3.merida.exam.common.bean.PageBean;
import com.qhit.lh.gr3.merida.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.merida.exam.sjgl.bean.Paper;
import com.qhit.lh.gr3.merida.exam.sjgl.bean.PaperClass;

public class PaperDaoImpl extends BaseDao implements PaperDao {

	@Override
	public void createByChoose(Paper paper) {
		// TODO 
		Transaction ts = getSession().beginTransaction();
        getSession().save(paper);
        ts.commit();
	}

	@Override
	public void startExam(List<PaperClass> paperClasses) {
		// TODO
		Transaction ts = getSession().beginTransaction();
		System.out.println("数据大小"+paperClasses.size());
		for (PaperClass paperClass : paperClasses) {
			//设置n-1关系
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//保存数据
			getSession().save(paperClass);
		}
		ts.commit();
	}

	@Override
	public void updateExam(Paper paper, String state) {
		// TODO 
		Transaction ts = getSession().beginTransaction();
		String hql = "update Paper paper set paper.pstate = ? where paper.pid = ?";
		Query queryUpdate = getSession().createQuery(hql);
		queryUpdate.setString(0, state);
		queryUpdate.setInteger(1, paper.getPid());
		//执行HQL的添加、修改、删除调用的是executeUpdate方法
		queryUpdate.executeUpdate();
		ts.commit();
	}

	@Override
	public void createPaperRandom(Paper paper) {
		// TODO 
		Transaction ts = getSession().beginTransaction();
		getSession().save(paper);
		ts.commit();
	}

	/* (non-Javadoc)
	 * @see com.qhit.lh.gr3.merida.exam.sjgl.dao.PaperDao#getPaperList(com.qhit.lh.gr3.merida.exam.common.bean.PageBean, java.util.Map, int)
	 */
	@Override
	public PageBean<Paper> getPaperList(PageBean<Paper> pageBean,
			Map<String, Object> parameter, int pageIndex) {
		// TODO 
		getSession().clear();
		StringBuffer hql = new StringBuffer();
		//StringBuffer类里面的方法更加偏重于对于字符串的变化，例如追加、插入和删除等，这个也是StringBuffer与String类的主要区别
		hql.append("select paper from Paper where 1 = 1");
		//拼接hql
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//获取查询器
		Query query = getSession().createQuery(hql.toString());
		//设置参数
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setInteger("csId", (Integer)parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String) parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState", (String) parameter.get("pState"));
		}
		//总记录数
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);//current index 当前指数的意思
		//当前页数据
		List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//设置pagebean的数据集合
		pageBean.setItems(items);
		//执行查询
		return pageBean;
	}

}
