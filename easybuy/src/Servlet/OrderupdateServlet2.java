package Servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;



public class OrderupdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderupdateServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		//从页面获取要更新的信息
		String EO_IDStr=request.getParameter("EO_ID");
		String EO_USER_NAME=request.getParameter("EO_USER_NAME");
		String EO_USER_ADDRESS=request.getParameter("EO_USER_ADDRESS");
		String EO_STATUSStr=request.getParameter("EO_STATUS");
		int EO_STATUS = Integer.parseInt(EO_STATUSStr);
		int EO_ID = Integer.parseInt(EO_IDStr);
		
		//更新信息
		OrderDao dao=new OrderDao();
		order ord=new order();
		ord.setEO_ID(EO_ID);
		ord.setEO_USER_NAME(EO_USER_NAME);
		ord.setEO_USER_ADDRESS(EO_USER_ADDRESS);
		ord.setEO_STATUS(EO_STATUS);	
		dao.update(ord);
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);

	}

}
