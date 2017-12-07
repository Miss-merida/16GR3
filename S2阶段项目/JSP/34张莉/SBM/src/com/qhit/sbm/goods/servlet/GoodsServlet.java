package com.qhit.sbm.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.sbm.goods.bean.Goods;
import com.qhit.sbm.goods.service.GoodsService;
import com.qhit.sbm.goods.service.impl.GoodsServiceImpl;

/**
 * Servlet implementation class GoodsServlet
 */
@WebServlet("/goods")
public class GoodsServlet extends HttpServlet {
	private GoodsService goodsService = new GoodsServiceImpl();
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd = request.getParameter("cmd");
		switch (cmd) {
		case "getGoodsInfo":
			getGoodsInfo(request, response);
			break;
		case "updateStore":
			doUpdateStore(request, response);
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
	private void doUpdateStore(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		Goods goods = (Goods) request.getAttribute("goods");
		String businessNum = request.getParameter("businessNum");
		int num = goods.getGoodsNum() + Integer.parseInt(businessNum);
		int row = goodsService.updateStore(num, goods.getGoodsId());
		response.sendRedirect("account?cmd=getPageBean&p=1");
	}

	/**
	 * @param request
	 * @param response
	 * 查询商品信息
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void getGoodsInfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String goodsName = request.getParameter("goodsName");
		Goods goods = goodsService.getGoodsInfoByName(goodsName);
		if(goods != null){
			//有商品，直接添加
			request.setAttribute("goods", goods);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("account?cmd=addAccount");
			requestDispatcher.forward(request, response);
		}else{
			//提醒没有商品，请先添加商品
			PrintWriter out = response.getWriter();
			out.print("<script>alert('商品查询失败，请先添加商品！');</script>");
		}
	}
	
}
