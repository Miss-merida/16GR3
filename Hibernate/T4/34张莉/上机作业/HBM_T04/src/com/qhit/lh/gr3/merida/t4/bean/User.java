package com.qhit.lh.gr3.merida.t4.bean;
// default package



/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User  implements java.io.Serializable {


    // Fields    

     private Integer userId;
     private String userName;
     private String userPassword;
     private String address;

    //“ª∂‘“ª
     private Emp emp;
    // Constructors

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer userId, String userName, String userPassword, String address, Emp emp) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
		this.emp = emp;
	}
	public User(String userName, String userPassword, String address, Emp emp) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.address = address;
		this.emp = emp;
	}
	

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}


   

}