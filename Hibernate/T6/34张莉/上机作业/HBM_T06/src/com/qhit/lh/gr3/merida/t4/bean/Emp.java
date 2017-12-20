package com.qhit.lh.gr3.merida.t4.bean;
// default package



/**
 * Emp entity. @author MyEclipse Persistence Tools
 */

public class Emp  implements java.io.Serializable {


    // Fields    

     private Integer empId;
     private String empName;
     private String empSex;
     private String birthday;
     private Integer deptId;

   //一对一
 	private User user;
 	//多对一
 	private Dept dept;
 	
    // Constructors
	public Emp() {
	}
	
	public Emp(Integer empId, String empName, String empSex, String birthday, Integer deptId, User user, Dept dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
		this.user = user;
		this.dept = dept;
	}
    
	
	
	public Emp(String empName, String empSex, String birthday, Integer deptId) {
		super();
		this.empName = empName;
		this.empSex = empSex;
		this.birthday = birthday;
		this.deptId = deptId;
	}

	public Emp(String empName, String empSex) {
		super();
		this.empName = empName;
		this.empSex = empSex;
	}

	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpSex() {
		return empSex;
	}
	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}

   
}