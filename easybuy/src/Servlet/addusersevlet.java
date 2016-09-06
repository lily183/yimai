package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import Dao.userdao;

/**
 * Servlet implementation class addusersevlet
 */
public class addusersevlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String usename=request.getParameter("userName");
	String name=request.getParameter("name");
	String password=request.getParameter("passWord");
	String sex=request.getParameter("sex");
	String birthyear=request.getParameter("birthyear");
	String birthday=birthyear;
	String mobile=request.getParameter("mobile");
	String address=request.getParameter("address");
	int status=Integer.parseInt(request.getParameter("status"));
	//System.out.println(address);
	user use=new user();
	use.setUsename(usename);
	use.setAddress(address);
	use.setMobil(mobile);
	use.setName(name);
	use.setStatus(status);
	use.setPassword(password);
	use.setSex(sex);
	use.setBirthday(birthday);
	userdao dao=new userdao();
	dao.insert(use);
	request.getRequestDispatcher("selectuservlet").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		doGet(request, response);
		
	}

}
