package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import Dao.userdao;


public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String usename=request.getParameter("userName");
		String name=request.getParameter("name");
		String password=request.getParameter("passWord");
		String sex=request.getParameter("sex");
		String birth=request.getParameter("birth");
		//String birthmonth=request.getParameter("birthmonth");
		//String birthday=request.getParameter("birthday");
		//birthday=birthyear+"-"+birthmonth+"-"+birthday;
		System.out.println("birth"+birth);
		String mobile=request.getParameter("mobile");
		String address=request.getParameter("address");
		String id=request.getParameter("id");
		//System.out.println(address);
		System.out.println("要修改的名字是"+name);
		user use=new user();
		use.setId(Integer.parseInt(id));
		use.setUsename(usename);
		use.setAddress(address);
		use.setMobil(mobile);
		use.setName(name);
		use.setPassword(password);
		use.setSex(sex);
		use.setBirthday(birth);
		userdao dao=new userdao();
		dao.update(use);
		///System.out.println(use);
		request.getRequestDispatcher("selectuservlet").forward(request, response);
			
	}

}
