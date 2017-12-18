package com.qhit.lh.gr3.merida.t3.bean;

/**
 * @author 张莉
 * 2017年12月18日上午9:03:00
 * TODO
 */
public class Emp {
	private int eid;
	private String ename;
	private String esex;
	private String birthday;
	private int deptId;
	
	private User user;
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Emp(int eid, String ename, String esex, String birthday, int deptId) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esex = esex;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	public Emp(String ename, String esex, String birthday, int deptId) {
		super();
		this.ename = ename;
		this.esex = esex;
		this.birthday = birthday;
		this.deptId = deptId;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEsex() {
		return esex;
	}
	public void setEsex(String esex) {
		this.esex = esex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
