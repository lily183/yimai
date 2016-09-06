package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Dao.newsdao;

/**
 * Servlet implementation class newsdeleteServlet
 */
public class newsdeleteServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 解决中文乱码
	    request.setCharacterEncoding("GBK");
		// 获取页面中传递过来的值
		int EN_ID = Integer.parseInt(request.getParameter("id"));
		newsdao dao=new newsdao();
		dao.delete(EN_ID);
		
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
		
	}

}
