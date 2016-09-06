package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Bean.comment;
import Dao.commentdao;
import Dao.newsdao;

/**
 * Servlet implementation class comupdateServlet
 */
public class comupdateServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 //获取要回复的留言id
		 
		String pidstr=request.getParameter("id");
	    int EC_ID= Integer.parseInt(pidstr);
	    //System.out.println(EC_ID);
		//根据商品id查询新闻信息
		commentdao dao=new commentdao();
		comment com=dao.queryById(EC_ID);
		 System.out.println(com.getEC_ID());
		//保存新闻信息
		request.setAttribute("update", com);
		//跳转到页面显示新闻信息
		request.getRequestDispatcher( "guestbook-modify.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
