package com.qhit.lh.gr3.merida.t4.bean;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private int roleId;
	private String roleName;
	private String memo;
	
	private Set<User> user = new HashSet<>();

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(int roleId, String roleName, String memo, Set<User> user) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
		this.user = user;
	}

	public Role(int roleId, String roleName, String memo) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.memo = memo;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", memo=" + memo + ", user=" + user + "]";
	}
	
	
}
