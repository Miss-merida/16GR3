package com.qhit.lh.gr3.merida.exam.tkgl.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.merida.exam.common.bean.PageBean;
import com.qhit.lh.gr3.merida.exam.kmgl.bean.Course;
import com.qhit.lh.gr3.merida.exam.tkgl.bean.WrittenQuestion;
import com.qhit.lh.gr3.merida.exam.tkgl.service.QuestionService;
import com.qhit.lh.gr3.merida.exam.tkgl.service.QuestionServiceImpl;
import com.qhit.lh.gr3.merida.exam.tkgl.utils.PoiReaderExcel;

/**
 * @author ����
 * 2018��1��4������4:54:07
 * TODO
 */
public class QuestionAction extends ActionSupport {
	private QuestionService questionService = new QuestionServiceImpl();
	private Course course;//�γ�
	private String major;//רҵ����
	private String stage;//�׶�
	private WrittenQuestion writtenQuestion;//���������
	private List<Course> listCourses = new ArrayList<>();
	//�����б��ҳ����
	private PageBean<WrittenQuestion> pageBean = new PageBean<>();
	private int pageIndex = 1;//ָ��ҳ,��ʼ��Ϊ1
	//�������⼯��
	private List<WrittenQuestion> listWQuestions = new ArrayList<>();
	//�����ļ�����
	private File questionfile;
	
	//private int 
	/**
	 * @return
	 * ����б�
	 */
	public String getCourseInfo(){
		//���ò���
		Map<String, String> parameter = new HashMap<>();
		if(major != null && !"".equals(major)){
			parameter.put("major", major);
		}
		if(stage != null && !"".equals(stage)){
			parameter.put("stage", stage);
		}
		//��ѯ����б�����
		listCourses = questionService.getCourseInfo(parameter);
		System.out.println(listCourses.size());
		return "listCourse";
	}
	
	/**
	 * @return
	 * ��ȡ�����б�
	 */
	public String getWrittenList(){
		pageBean = questionService.getWrittenList(pageBean, course, pageIndex);
		System.out.println("���ݴ�С:"+pageBean.getItems().size());
		return "listWritten";
	}
	
/*	public String getQuestionMax(){
		radioEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "��");
		radioNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "һ��");
		radioDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "����");
		cbEasyMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "��");
		cbNormalMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "һ��");
		cbDiffMax = questionService.getQuestionsMax(writtenQuestion.getCsId(), "��ѡ", "����");
		
		return "getQuestionMax";
	}*/
	
	/**
	 * @return
	 * ��ӱ�����
	 */
	public String addWrittenQuestion(){
		System.out.println(writtenQuestion.getQsId());
		//���ÿγ�����Ĺ���
		writtenQuestion.setCourse(course);
		
		questionService.addWrittenQuestion(writtenQuestion);
		return "addWrittenQuestion";
	}
	
	/**
	 * @return
	 * ���������Ų�ѯ�������
	 */
	public String getWrittenQuestionById(){
		writtenQuestion = questionService.getWrittenQuestionById(writtenQuestion);
		return "getWrittenQuestionById";
	}
	
	/**
	 * @return
	 * ����
	 */
	public String updateWrittenQuestion(){
		//���ù���
		writtenQuestion.setCourse(course);
		
		questionService.updateWrittenQuestion(writtenQuestion);
		return "updateWrittenQuestion";
	}
	
	/**
	 * @return
	 * �������������
	 * @throws FileNotFoundException 
	 */
	public String inportWrittenQuestions() throws FileNotFoundException{
		
		if(questionfile != null){
			//1,�ϴ�����������struts2��(1,jsp���ύ�ؼ���2��action)
			FileInputStream fis = new FileInputStream(questionfile);
			//2,��ȡexcel�ļ��е�����,��ȡ������󼯺ϣ�POI:1,������2����ȡ��������ȡ���ݼ��ϣ�
			listWQuestions = PoiReaderExcel.readerExcel(fis, course);
			//3,������ӵ����ݿ�(hibernate)
			questionService.inportWrittenQuestions(listWQuestions);
		}else{
			//�ϴ��ļ�ʧ�ܵ��жϣ���ʱ����
		}
		return "inportWrittenQuestions";
	}
	
	public PageBean<WrittenQuestion> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<WrittenQuestion> pageBean) {
		this.pageBean = pageBean;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}



	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public List<Course> getListCourses() {
		return listCourses;
	}

	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public WrittenQuestion getWrittenQuestion() {
		return writtenQuestion;
	}

	public void setWrittenQuestion(WrittenQuestion writtenQuestion) {
		this.writtenQuestion = writtenQuestion;
	}

	public List<WrittenQuestion> getListWQuestions() {
		return listWQuestions;
	}

	public void setListWQuestions(List<WrittenQuestion> listWQuestions) {
		this.listWQuestions = listWQuestions;
	}

	public File getQuestionfile() {
		return questionfile;
	}

	public void setQuestionfile(File questionfile) {
		this.questionfile = questionfile;
	}
}
