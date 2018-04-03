package com.qhit.lh.gr3.merida.exam.tkgl.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.qhit.lh.gr3.merida.exam.common.bean.PageBean;
import com.qhit.lh.gr3.merida.exam.common.dao.BaseDao;
import com.qhit.lh.gr3.merida.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.merida.exam.tkgl.bean.WrittenQuestion;

public class QuestionDaoImpl extends BaseDao implements QuestionDao {


	@Override
	public List<Course> getCourseInfo(Map parameter) {
		StringBuffer hql = new StringBuffer();
		hql.append("select course from Course course where 1 = 1");
		//ƴ��HQL
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			hql.append(" and course.major = :major");
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			hql.append(" and course.stage = :stage");
		}
		//��ȡ��ѯ��
		Query query = getSession().createQuery(hql.toString());
		//���ò���
		if(parameter.get("major") != null && !"".equals(parameter.get("major"))){
			query.setString("major", (String) parameter.get("major"));
		}
		if(parameter.get("stage") != null && !"".equals(parameter.get("stage"))){
			query.setString("stage", (String) parameter.get("stage"));
		}
		//ִ�в�ѯ
		return query.list();
	}

	@Override
	public PageBean<WrittenQuestion> getWrittenList(
			PageBean<WrittenQuestion> pageBean, 
			Course course,
			int pageIndex) {
		// TODO Auto-generated method stub
		//hql���
		StringBuffer hql = new StringBuffer();
		hql.append("select w from WrittenQuestion w where w.csId = :csId");
		//��ȡ��ѯ��
		Query query = getSession().createQuery(hql.toString());
		//���÷�ҳ��ѯ����
		query.setInteger("csId", course.getCsId());
		//�ܼ�¼��
		int count = query.list().size();
		pageBean.setTotalNumber(count);
		pageBean.setCurrentIndex(pageIndex);
		System.out.println(pageBean.toString());
		//��ǰҳ����
		List<WrittenQuestion> items = query.setFirstResult((pageBean.getCurrentIndex()-1)*pageBean.getPageSize())
				.setMaxResults(pageBean.getPageSize())
				.list();
		//����pagebean�����ݼ���
		pageBean.setItems(items);
		
		return pageBean;
	}

	@Override
	public void addWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		//��������
		Transaction ts = getSession().beginTransaction();
		//ִ����ӣ������¼�¼������
		long id = (Integer) getSession().save(writtenQuestion);
		//�ύ����
		ts.commit();
	}

	@Override
	public WrittenQuestion getWrittenQuestionById(
			WrittenQuestion writtenQuestion) {
		
		return (WrittenQuestion) getSession().get(WrittenQuestion.class, writtenQuestion.getQid());
	}

	@Override
	public void updateWrittenQuestion(WrittenQuestion writtenQuestion) {
		// TODO Auto-generated method stub
		//���session�л������:http://blog.csdn.net/jayliu1989/article/details/78979022
		getSession().clear();
		Transaction ts = getSession().beginTransaction();
		getSession().update(writtenQuestion);
		ts.commit();
	}
	
	@Override
	public void inportWrittenQuestions(List<WrittenQuestion> listWQuestions) {
		// TODO Auto-generated method stub
		//��������
		Transaction ts = getSession().beginTransaction();
		for (WrittenQuestion writtenQuestion : listWQuestions) {
			//ִ����ӣ������¼�¼������
			getSession().save(writtenQuestion);
		}
		//�ύ����
		ts.commit();
	}

	@Override
	public int getQuestionsMax(int csId, String qtype, String degree) {
		// TODO Auto-generated method stub
		Criteria criteria = getSession().createCriteria(WrittenQuestion.class)
				.add(Restrictions.eq("csId", csId))
				.add(Restrictions.eq("qtype", qtype))
				.add(Restrictions.eq("degree", degree));
		
		ProjectionList projectionList = Projections.projectionList()
				.add(Projections.count("qid"));
		
		criteria.setProjection(projectionList);
		long num = (long) criteria.list().get(0);
		return (int)num;
	}

}
