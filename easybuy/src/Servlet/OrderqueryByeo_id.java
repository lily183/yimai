package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;




public class OrderqueryByeo_id extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderqueryByeo_id() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		//获取订单ID
		String EO_IDStr=request.getParameter("EO_ID");
		String EO_USER_NAME=request.getParameter("EO_USER_NAME");
		//查询
		ArrayList<order> ord = new ArrayList<order>();
		OrderDao dao=new OrderDao();
		order e=new order();
		
		
		
		if (!"".equals(EO_IDStr)) {
			e=dao.queryByeo_id(Integer.parseInt(EO_IDStr));
			ord.add(e);
		}
		else if(!"".equals(EO_USER_NAME)){
			ord=dao.queryByeo_user_name(EO_USER_NAME);
			
			System.out.println("名字查询成功");
			
		}
		
		//System.out.println();
		request.setAttribute("ord",ord);
		//显示
		request.getRequestDispatcher("order.jsp").
		forward(request, response);
	
	}

}
