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
		case "addUser":
			addUser(request, response);
			break;
		default:
			break;
		}
	}
		/**
	 * @param request
	 * @param response
		 * @throws IOException 
	 */
	private void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userName = (String)request.getAttribute("userName");
		String userPassword = (String)request.getAttribute("userPassword");
		String userSex = (String)request.getAttribute("userSex");
		String userAge = (String)request.getAttribute("userAge");//int
		String telephone = (String)request.getAttribute("telephone");
		String address = (String)request.getAttribute("address");
		String type = (String)request.getAttribute("type");//int
		//ͷ��������洢·����request.setAttribute("picPath", picPath);
		String pic = (String) request.getAttribute("pic");
		
		User user = new User(
				userName, 
				userPassword, 
				userSex, 
				Integer.parseInt(userAge), 
				telephone, 
				address,
				pic, 
				Integer.parseInt(type)
				);
		
		int row = usService.addUser(user);
		
		PrintWriter out = response.getWriter();
		if(row > 0){
			//��ӳɹ���Ӧ���ض���user���Ʋ����²�ѯ���е��û��б�
			//out.print("<script>alert('��ӳɹ�');</script>");
			response.sendRedirect("jsp/userinfo.jsp?pic="+pic);
		}else{
			//���ʧ��
			out.print("<script>alert('���ʧ��');</script>");
		}
	}




	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * �˳�����
	 */
	private void doExit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		request.getSession().invalidate();
		out.print("<script>window.top.location.href='"+basePath+"'</script>");
		
	}
		
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * ��¼����
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
