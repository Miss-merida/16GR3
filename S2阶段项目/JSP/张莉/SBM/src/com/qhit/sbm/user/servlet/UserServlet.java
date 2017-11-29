package com.qhit.sbm.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.service.impl.AccountServiceImpl;
import com.qhit.sbm.provider.service.impl.ProviderServiceImpl;
import com.qhit.sbm.user.bean.User;
import com.qhit.sbm.user.service.UserService;
import com.qhit.sbm.user.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private UserService usService = new UserServiceImpl();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "login":
			doLogin(request,response);
			break;
		case "exit":
			doExit(request,response);
			break;
		default:
			break;
		}
	}
		/*
		 * 
		 * �˳�����
		 */
	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		System.out.println(basePath);
		request.getSession().invalidate();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}
		/*
		 * ��¼����
		 * 
		 */
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		boolean isOnline = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
		User user = usService.doLogin(userName, userPassword); 
		
		if(user != null){
			/**
			 * ��½�ɹ�
			 * */
			//�����û���Ϣ���Ự��
			request.getSession().setAttribute("user", user);
			//��ȡ�����û�����
			List<User> users = (List<User>) request.getServletContext().getAttribute("online");
			for (User user2 : users) {
				if(user2.getUserId() == user.getUserId()){
					//˵����ǰ�û��Ѿ�����,ֱ����ת�Ϳ���
					isOnline = true;
					break;
				}
			}
			if(isOnline){
				response.sendRedirect("jsp/admin_index.jsp");
			}else{
				//��ӵ�ǰ�û��������û�����
				users.add(user);
				//���������û�����
				request.getServletContext().setAttribute("online", users);
				//��תҳ��/cmd
				response.sendRedirect("account?cmd=getPageBean");
			}
		}else{
			//��¼ʧ��
			response.sendRedirect("index.jsp?loginMsg=failed");
		}
	}

}
