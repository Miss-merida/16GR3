package com.qhit.lh.gr3.merida.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.merida.exam.common.bean.User;
import com.qhit.lh.gr3.merida.exam.common.service.UserService;
import com.qhit.lh.gr3.merida.exam.common.service.UserServiceImpl;

/**
 * @author 张莉
 * 2018年1月3日上午11:09:03
 * TODO
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 *登录
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//登录成功
			System.out.println(user.toString());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("登录失败！用户名密码错误!");
			return "loginFail";
		}
	}
	/**
	 *退出
	 */
	public String logout(){
		//获取session对象，并销毁
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
		
}

