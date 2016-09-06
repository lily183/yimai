package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Category;
import Dao.CategoryDao;

/**
 * Servlet implementation class CatAddServlet
 */
public class CatAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatAddServlet() {
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
		String cpidStr = request.getParameter("cpid");
		int cpid = Integer.parseInt(cpidStr);
		String cname = request.getParameter("cname");
		Category cat = new Category();
		cat.setCname(cname);
		cat.setCpid(cpid);
		CategoryDao.add(cat);
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	}

}
