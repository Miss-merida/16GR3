package com.qhit.lh.gr3.merida.t3.bean;

/**
 * @author 张莉
 * 2017年12月18日上午9:02:47
 * TODO
 */
public class User {
	private int uid;
	private String uname;
	private String password;
	
	private Emp emp;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String password) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}
	public User(String uname, String password) {
		super();
		this.uname = uname;
		this.password = password;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Emp getEmp() {
		return emp;
	}
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
	
}
