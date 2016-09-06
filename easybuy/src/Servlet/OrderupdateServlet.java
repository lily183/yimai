package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;

public class OrderupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取要修改的商品ID
		String EO_IDStr=request.getParameter("EO_ID");
		int EO_ID=Integer.parseInt(EO_IDStr);
		//根据ID查询商品信息
		OrderDao dao=new OrderDao();
		order ord=dao.queryByeo_id(EO_ID);
		//保存商品信息
		request.setAttribute("ord",ord);
		//跳转到商品修改页面
		request.getRequestDispatcher("order-modify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
