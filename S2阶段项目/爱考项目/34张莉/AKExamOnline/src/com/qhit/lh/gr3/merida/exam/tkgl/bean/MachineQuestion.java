package com.qhit.lh.gr3.merida.exam.tkgl.bean;

import com.qhit.lh.gr3.merida.exam.kmgl.bean.Course;

/**
 * MachineTest entity. @author MyEclipse Persistence Tools
 */

public class MachineQuestion implements java.io.Serializable {


    // Fields    

     private Integer qid;
     private String qtitle;
     private String degree;
     private Integer csId;
     private String chapter;


    //n-1
 	private Course course;
    // Constructors

    /** default constructor */
    public MachineQuestion() {
    }
    

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	/** minimal constructor */
    public MachineQuestion(String qtitle, String degree, Integer qsId) {
        this.qtitle = qtitle;
        this.degree = degree;
        this.csId = qsId;
    }
    
    /** full constructor */
    public MachineQuestion(String qtitle, String degree, Integer qsId, String chapter) {
        this.qtitle = qtitle;
        this.degree = degree;
        this.csId = qsId;
        this.chapter = chapter;
    }

   
    // Property accessors

    public Integer getQid() {
        return this.qid;
    }
    
    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getQtitle() {
        return this.qtitle;
    }
    
    public void setQtitle(String qtitle) {
        this.qtitle = qtitle;
    }

    public String getDegree() {
        return this.degree;
    }
    
    public void setDegree(String degree) {
        this.degree = degree;
    }


    public Integer getCsId() {
		return csId;
	}


	public void setCsId(Integer csId) {
		this.csId = csId;
	}


	public String getChapter() {
        return this.chapter;
    }
    
    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

}