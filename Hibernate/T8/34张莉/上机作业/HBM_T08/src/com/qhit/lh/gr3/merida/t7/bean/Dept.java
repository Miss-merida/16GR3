package com.qhit.lh.gr3.merida.t7.bean;

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

     //1-n
     private Set<Emp> emp = new HashSet<>();

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(Integer deptId, String deptName, Set<Emp> emps) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.emp = emp;
	}

	public Dept(Integer deptId, String deptName) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
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

	public Set<Emp> getEmp() {
		return emp;
	}

	public void setEmp(Set<Emp> emp) {
		this.emp = emp;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptName=" + deptName + ", emp=" + emp + "]";
	}

	
   

}