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
		 //��ȡҪ�ظ�������id
		 
		String pidstr=request.getParameter("id");
	    int EC_ID= Integer.parseInt(pidstr);
	    //System.out.println(EC_ID);
		//������Ʒid��ѯ������Ϣ
		commentdao dao=new commentdao();
		comment com=dao.queryById(EC_ID);
		 System.out.println(com.getEC_ID());
		//����������Ϣ
		request.setAttribute("update", com);
		//��ת��ҳ����ʾ������Ϣ
		request.getRequestDispatcher( "guestbook-modify.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
