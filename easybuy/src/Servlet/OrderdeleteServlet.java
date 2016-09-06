package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;



public class OrderdeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public OrderdeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����ID
		String EO_IDStr=request.getParameter("EO_ID");
		int EO_ID = Integer.parseInt(EO_IDStr);
		//����ɾ������
		OrderDao dao=new OrderDao();
		dao.delete(EO_ID);
		//��ѯ����
		ArrayList<order> orlist = OrderDao.queryAll();
		//����
		request.setAttribute("ord", orlist);
		//��ʾ
		request.getRequestDispatcher("OrderqueryAll").
		forward(request, response);	
	
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
