package com.qhit.sbm.common.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.qhit.sbm.user.bean.User;

public class UserExitListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session��ʼ��");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("session����");
		HttpSession session = arg0.getSession();
		User user = (User) session.getAttribute("user");
		//�Ȼ�ȡapplication����
		ServletContext application = session.getServletContext();
		//��ȡ�����û�����
		List<User> users = (List<User>) application.getAttribute("online");
		//�������û��������Ƴ���ǰ�˳����û�
		users.remove(user);
		//����application�����������û�����
		application.setAttribute("online", users);
	}

}
