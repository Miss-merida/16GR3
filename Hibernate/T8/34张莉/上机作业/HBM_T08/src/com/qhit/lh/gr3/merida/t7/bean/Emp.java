package com.qhit.lh.gr3.merida.t7.bean;
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

     //1-1
     private User user;
     //n-1
     private Dept dept;

    // Constructors

    /** default constructor */
    public Emp() {
    }

	/** minimal constructor */
    public Emp(String empName, String empSex, String birthday) {
        this.empName = empName;
        this.empSex = empSex;
        this.birthday = birthday;
    }
    
    /** full constructor */
    public Emp(String empName, String empSex, String birthday, Integer deptId) {
        this.empName = empName;
        this.empSex = empSex;
        this.birthday = birthday;
        this.deptId = deptId;
    }

   
    // Property accessors

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

	public Integer getEmpId() {
        return this.empId;
    }
    
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return this.empName;
    }
    
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpSex() {
        return this.empSex;
    }
    
    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public String getBirthday() {
        return this.birthday;
    }
    
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptId() {
        return this.deptId;
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

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSex=" + empSex + ", birthday=" + birthday
				+ ", deptId=" + deptId;
	}
   


    





}