package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.userdao;

/**
 * Servlet implementation class registservlet
 */
public class registservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usename=request.getParameter("userName");
		String password=request.getParameter("passWord");
		String repassword=request.getParameter("rePassWord");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birth");
		try {
			if(repassword.equals(password)&&
					!password.equals("")&&!usename.equals("")&&
					!address.equals("")&&!sex.equals("")&&
					!birthday.equals("")){
				userdao dao=new userdao();
				dao.add(usename, password,sex,birthday,address);
				
				response.sendRedirect("reg-result.jsp");
			}else{
				request.setAttribute("regstatus", "1");
				response.sendRedirect("register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("regstatus", "1");
			response.sendRedirect("register.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		doGet(request, response);
	}

}
