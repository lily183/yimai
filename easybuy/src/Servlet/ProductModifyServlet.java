package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Category;
import Bean.Product;
import Dao.CategoryDao;
import Dao.ProductDao;

/**
 * Servlet implementation class ProductModifyServlet
 */
public class ProductModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pidStr = request.getParameter("pid");
		int pid = Integer.parseInt(pidStr);
		Product pro = ProductDao.queryById(pid);
		ArrayList<Product> plist = new ArrayList<Product>();
		plist.add(pro);
		ArrayList<Category> clist = CategoryDao.querySon();
		request.setAttribute("clist", clist);
		request.setAttribute("list", plist);
		request.getRequestDispatcher("product-modify.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
