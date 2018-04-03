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
		System.out.println("���ݴ�С"+paperClasses.size());
		for (PaperClass paperClass : paperClasses) {
			//����n-1��ϵ
			Paper paper = (Paper) getSession().get(Paper.class, paperClass.getPid());
			ClassInfo classInfo = (ClassInfo) getSession().get(ClassInfo.class, paperClass.getCcode());
			paperClass.setPaper(paper);
			paperClass.setClassInfo(classInfo);
			//��������
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
		//ִ��HQL����ӡ��޸ġ�ɾ�����õ���executeUpdate����
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
		//StringBuffer������ķ�������ƫ���ڶ����ַ����ı仯������׷�ӡ������ɾ���ȣ����Ҳ��StringBuffer��String�����Ҫ����
		hql.append("select paper from Paper where 1 = 1");
		//ƴ��hql
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			hql.append(" and paper.csId = :csId");
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			hql.append(" and paper.ptype = :pType");
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			hql.append(" and paper.pstate = :pState");
		}
		//��ȡ��ѯ��
		Query query = getSession().createQuery(hql.toString());
		//���ò���
		if(parameter.get("csId") != null && (Integer)parameter.get("csId") > 0){
			query.setInteger("csId", (Integer)parameter.get("csId"));
		}
		if(parameter.get("pType") != null && !"".equals(parameter.get("pType"))){
			query.setString("pType", (String) parameter.get("pType"));
		}
		if(parameter.get("pState") != null && !"".equals(parameter.get("pState"))){
			query.setString("pState", (String) parameter.get("pState"));
		}
		//�ܼ�¼��
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);//current index ��ǰָ������˼
		//��ǰҳ����
		List<Paper> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//����pagebean�����ݼ���
		pageBean.setItems(items);
		//ִ�в�ѯ
		return pageBean;
	}

}
