package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Dao.newsdao;

/**
 * Servlet implementation class fnewsviewServlet
 */
public class fnewsviewServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ֹ����
		request.setCharacterEncoding("GBK");
		//��ȡid
		int EN_ID=Integer.parseInt(request.getParameter("EN_ID"));
		//int EN_ID = Integer.parseInt(request.getParameter("id"));
		
		//����������ϸ����
		newsdao dao=new newsdao();
		Easybuy_news news=dao.queryById(EN_ID);
	    request.setAttribute( "news", news);
	    
		 //�����������ţ�ʵ�������б�
		   ArrayList<Easybuy_news> nlist=dao.queryAll();
		    System.out.print(nlist);
		    if(nlist.size()==0){
			  //product p=plist.get(0);
			   request.setAttribute( "list", null);
			    
		    }else{
			   request.setAttribute( "list", nlist);
			  
		 } 
		 
	   
	    request.getRequestDispatcher("news-view.jsp").forward(request, response);
		  
	}

}
