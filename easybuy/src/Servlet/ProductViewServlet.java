package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import Bean.Category;
import Bean.Product;
import Dao.CategoryDao;
import Dao.ProductDao;

/**
 * Servlet implementation class ProductViewServlet
 */
public class ProductViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category> clistParent = CategoryDao.queryParent();
		request.setAttribute("listP", clistParent);
		ArrayList<Category> clistSon = CategoryDao.querySon();
		request.setAttribute("listS", clistSon);
		ArrayList<Product> plistSpPrice = ProductDao.querySpecialPrice();
		request.setAttribute("plistSpPrice", plistSpPrice);
		ArrayList<Product> plistSpBuy = ProductDao.querySpecialBuy();
		request.setAttribute("plistSpBuy", plistSpBuy);
		String pidStr = request.getParameter("pid");
		int pid = Integer.parseInt(pidStr);
		Product pro = ProductDao.queryById(pid);
		ArrayList<Product> list = new ArrayList<Product>();
		list.add(pro);
		request.setAttribute("list", list);
		request.getRequestDispatcher("product-view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
