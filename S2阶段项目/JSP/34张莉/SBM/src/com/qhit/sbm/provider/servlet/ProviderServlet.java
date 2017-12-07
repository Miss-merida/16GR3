package com.qhit.sbm.provider.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.provider.bean.Provider;
import com.qhit.sbm.provider.service.ProviderService;
import com.qhit.sbm.provider.service.impl.ProviderServiceImpl;

/**
 * Servlet implementation class ProviderServlet
 */
@WebServlet("/provider")
public class ProviderServlet extends HttpServlet {
	private ProviderService providerService = new ProviderServiceImpl();


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
		case "getAllProvider":
			getAllProvider(request, response);
			break;

		default:
			break;
		}
	}
    /*
     * 
     * 查询所有的供应商
     */
	private void getAllProvider(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		List<Provider> list = providerService.getAllProvider();
		
		request.setAttribute("providers", list);
		if(action.equals("add")){
			//查完之后:如果是添加账单，转发到添加账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/modify.jsp");
			rqDispatcher.forward(request, response);
		}else{
			//查完之后：如果是修改账单，那就转发到修改账单的页面
			RequestDispatcher rqDispatcher = request.getRequestDispatcher("jsp/updateAccount.jsp");
			rqDispatcher.forward(request, response);
		}
		
	}
	
}

