package com.qhit.sbm.user.bean;

public class User {
	private int userId;
	private String userName="";
	private String userPassword="";
	private String userSex="";
	private int userAge;
	private String telephone="";
	private String address="";
	private String pic="";
	private int type;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int userId, String userName, String userPassword, String userSex, int userAge, String telephone,
			String address, String pic, int type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}
	
	public User(String userName, String userPassword, String userSex, int userAge, String telephone, String address,
			String pic, int type) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userAge = userAge;
		this.telephone = telephone;
		this.address = address;
		this.pic = pic;
		this.type = type;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public String getUserSex() {
		return userSex;
	}
	public int getUserAge() {
		return userAge;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getAddress() {
		return address;
	}
	public String getPic() {
		return pic;
	}
	public int getType() {
		return type;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
}
