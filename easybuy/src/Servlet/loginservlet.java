package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.user;
import Dao.userdao;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String usename=request.getParameter("userName");
		String password=request.getParameter("passWord");
		userdao dao=new userdao();
		user loguser=dao.login(usename, password);
		//System.out.println(loguser.getName());
		if(loguser==null){
			System.out.println("该用户不存在");
			response.sendRedirect("register.jsp");
			//request.getRequestDispatcher("register.jsp").forward(request, response);
		}else if(loguser.getStatus()==1){
			int userid = loguser.getId();
			String addr = loguser.getAddress();
			int status = loguser.getStatus();
			request.getSession().setAttribute("name", usename);
			request.getSession().setAttribute("userid", userid);
			request.getSession().setAttribute("addr", addr);
			request.getSession().setAttribute("status", status);
			response.sendRedirect("Frontend");
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(loguser.getStatus()==2){//request.getRequestDispatcher("manage/index.jsp").forward(request, response);
			int userid = loguser.getId();
			String addr = loguser.getAddress();
			int status = loguser.getStatus();
			request.getSession().setAttribute("name", usename);
			request.getSession().setAttribute("userid", userid);
			request.getSession().setAttribute("addr", addr);
			request.getSession().setAttribute("status", status);
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String nowTime=null;
			nowTime = df.format(new Date());
			request.getSession().setAttribute("time",nowTime);
			response.sendRedirect("manage/index.jsp");
		}
		}
			
	}

