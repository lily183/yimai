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
		 //��ȡ����id
		 
		String pidstr=request.getParameter("pid");
	    int EN_ID= Integer.parseInt(pidstr);
	     
		//������Ʒid��ѯ������Ϣ
		newsdao dao=new newsdao();
		Easybuy_news news=dao.queryById(EN_ID);
		 
		//����������Ϣ
		request.setAttribute("update", news);
		//��ת��ҳ����ʾ������Ϣ
		request.getRequestDispatcher( "news-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
