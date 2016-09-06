package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Category;
import Bean.Easybuy_news;
import Dao.CategoryDao;
import Dao.newsdao;

/**
 * Servlet implementation class fnewsshowServlet
 */
public class fnewsshowServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 处理中文乱码
		request.setCharacterEncoding("GBK");
		newsdao dao=new newsdao();
	    ArrayList<Easybuy_news> nlist=dao.queryAll();
	    System.out.print(nlist);
	    if(nlist.size()==0){
		  //product p=plist.get(0);
		   request.setAttribute( "list", null);
		   request.getRequestDispatcher("index.jsp").forward(request, response);
	    }else{
		   request.setAttribute( "list", nlist);
		   request.getRequestDispatcher("index.jsp").forward(request, response);
	    } 
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
