package com.qhit.lh.gr3.merida.t4.bean;

import java.util.HashSet;
import java.util.Set;

// default package


/**
 * Dept entity. @author MyEclipse Persistence Tools
 */

public class Dept  implements java.io.Serializable {


    // Fields    

     private Integer deptId;
     private String deptName;
    //Ò»¶Ô¶à
     private Set<Emp> emps = new HashSet<Emp>();
     
     
	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Dept(Integer deptId, String deptName, Set<Emp> emps) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.emps = emps;
	}

	

	public Dept(String deptName, Set<Emp> emps) {
		super();
		this.deptName = deptName;
		this.emps = emps;
	}


	public Integer getDeptId() {
		return deptId;
	}


	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public Set<Emp> getEmps() {
		return emps;
	}


	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}


	
    // Constructors

    /** default constructor */
 

}