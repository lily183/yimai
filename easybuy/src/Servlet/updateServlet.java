package Servlet;

 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Dao.newsdao;

/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //获取新闻id
		 
		String pidstr=request.getParameter("pid");
	    int EN_ID= Integer.parseInt(pidstr);
	     
		//根据商品id查询新闻信息
		newsdao dao=new newsdao();
		Easybuy_news news=dao.queryById(EN_ID);
		 
		//保存新闻信息
		request.setAttribute("update", news);
		//跳转到页面显示新闻信息
		request.getRequestDispatcher( "news-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
