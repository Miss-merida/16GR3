package com.qhit.sbm.account.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.account.service.AccountService;
import com.qhit.sbm.account.service.impl.AccountServiceImpl;
import com.qhit.sbm.common.bean.PageBean;
import com.qhit.sbm.common.service.CommonService;
import com.qhit.sbm.common.service.impl.CommonServiceImpl;
import com.qhit.sbm.goods.bean.Goods;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private CommonService commonService = new CommonServiceImpl();
	private AccountService accountService = new AccountServiceImpl();


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
		case "getPageBean":
			getPageBean(request,response);
			break;
		case "addAccount":
			addAccount(request,response);
			break;
		case "getAccountByParam":
			getAccountByParam(request,response);
			break;
		case "deleteAcount":
			deleteAcount(request,response);
			break;
		case "updateAccount":
			updateAccount(request,response);
			break;
		default:
			break;
		}
	}

	private void updateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed"); 
		
		int row = accountService.upDateAccountById(
				Integer.valueOf(accountId),
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));
		System.out.println(row);
		System.out.println(888);	
		if(row > 0){
			//更新成功
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else{
			//更新失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('更新失败');</script>");
		}
	}

	
	private void deleteAcount(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String accountId = request.getParameter("accountId");
		int row = accountService.deleteAccountById(Integer.parseInt(accountId));
		
		if (row > 0) {
			//删除成功
			response.sendRedirect("account?cmd=getPageBean&&p=1");
		}else {
			//删除失败
			PrintWriter out = response.getWriter();
			out.println("<script>alert('删除失败');</script>");
		}
	}
    /*
     * 根据条件查询
     */
	private void getAccountByParam(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String goodsName = request.getParameter("goodsName");
		String isPayed = request.getParameter("isPayed");
		List<String> wheres = new ArrayList<>();
		List<String> values = new ArrayList<>();
		if(goodsName != null && goodsName != ""){
			wheres.add("g.goodsName");
			values.add(goodsName);
		}
		if(isPayed != null && isPayed != ""){
			wheres.add("a.isPayed");
			values.add(isPayed);
		}
		
		PageBean pageBean = accountService.getPageBeanByParam(wheres, values);
		
		request.getSession().setAttribute("pageBean", pageBean);
		
		PrintWriter out = response.getWriter();
		out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
	}
	/**
	 * 添加账单：
	 * 1，进入页面之前需要先查询所有的供应商：供应商模块（已完成）
	 * 2，根据提交的商品名称查询商品信息:商品模块(已完成)
	 * 3，根据商品信息和提交的交易数量来计算交易总额：账单模块
	 * 4,更新商品库存（可选）
	 *  
	 */
	private void addAccount(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		String providerId = request.getParameter("providerId");
		String isPayed = request.getParameter("isPayed");
		
		int row = accountService.addAccount(
				goods, 
				Integer.parseInt(businessNum), 
				Integer.parseInt(providerId), 
				Integer.parseInt(isPayed));
		
		if(row > 0){
			//更新库存
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("goods?cmd=updateStore");
			requestDispatcher.forward(request, response);
			
		}else{
			//添加失败
			PrintWriter out = response.getWriter();
			out.print("<script>alert('添加失败');</script>");
		}
	}

	/**
	 * 
	 * 分页查询账单列表数据
	 * @throws IOException 
	 */
	private void getPageBean(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		/**
		 * pagesize=5
		 * data:实例化
		 * count：1
		 * pagetotal:2
		 * p:3
		 * */
		PageBean pageBean = new PageBean();
		int count = commonService.getCount("tb_account", null, null);
		pageBean.setCount(count);
		
		String p = request.getParameter("p");
		if(p != null && p != ""){
			//有参数p
			pageBean.setP(Integer.parseInt(p));
		}else{
			//没有参数，第一次进入
			pageBean.setP(1);
		}
		
		pageBean = accountService.getPageBean(pageBean);
		//保存数据
		System.out.println(pageBean.getData().size());
		request.getSession().setAttribute("pageBean", pageBean);
		//重定向
		//response.sendRedirect("jsp/admin_index.jsp");
		if(p != null && p != ""){
			//有参数p
			PrintWriter out = response.getWriter();
			out.print("<script>location.href = 'jsp/admin_bill_list.jsp'</script>");
		}else{
			response.sendRedirect("jsp/admin_index.jsp");
		}
		
	}
}
