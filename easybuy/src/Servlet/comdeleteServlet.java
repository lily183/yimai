package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.commentdao;
import Dao.newsdao;

/**
 * Servlet implementation class comdeleteServlet
 */
public class comdeleteServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 request.setCharacterEncoding("GBK");
			// 获取页面中传递过来的值
			int EC_ID  = Integer.parseInt(request.getParameter("id"));
			commentdao dao=new commentdao();
			dao.delete(EC_ID );
			
			request.getRequestDispatcher("manage-result.jsp").forward(request, response);
			
	}

}
