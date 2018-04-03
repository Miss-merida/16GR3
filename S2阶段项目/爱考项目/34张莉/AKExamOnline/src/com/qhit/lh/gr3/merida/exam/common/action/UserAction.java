package com.qhit.lh.gr3.merida.exam.common.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.qhit.lh.gr3.merida.exam.common.bean.User;
import com.qhit.lh.gr3.merida.exam.common.service.UserService;
import com.qhit.lh.gr3.merida.exam.common.service.UserServiceImpl;

/**
 * @author ����
 * 2018��1��3������11:09:03
 * TODO
 */
public class UserAction extends ActionSupport {
	private UserService userService = new UserServiceImpl();
	
	private User user;
	
	/**
	 *��¼
	 */
	public String login(){
		user = userService.login(user);
		if(user != null){
			//��¼�ɹ�
			System.out.println(user.toString());
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return "loginSuccess";
		}else{
			super.addActionError("��¼ʧ�ܣ��û����������!");
			return "loginFail";
		}
	}
	/**
	 *�˳�
	 */
	public String logout(){
		//��ȡsession���󣬲�����
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

