package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Category;
import Bean.Easybuy_news;
import Bean.Product;
import Dao.CategoryDao;
import Dao.ProductDao;
import Dao.newsdao;

/**
 * Servlet implementation class FrontendCatPro
 */
public class Frontend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Frontend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 处理中文乱码
		request.setCharacterEncoding("GBK");
		ArrayList<Category> clistParent = CategoryDao.queryParent();
		request.setAttribute("listP", clistParent);
		ArrayList<Category> clistSon = CategoryDao.querySon();
		request.setAttribute("listS", clistSon);
		ArrayList<Product> plistSpPrice = ProductDao.querySpecialPrice();
		request.setAttribute("plistSpPrice", plistSpPrice);
		ArrayList<Product> plistSpBuy = ProductDao.querySpecialBuy();
		request.setAttribute("plistSpBuy", plistSpBuy);
		
		newsdao dao=new newsdao();
	    ArrayList<Easybuy_news> nlist=dao.queryAll();
	    if(nlist.size()==0){
		  //product p=plist.get(0);
		   request.setAttribute( "list", null);
		   request.setAttribute( "slider", 1);
		   request.getRequestDispatcher("index.jsp").forward(request, response);
	    }else{
		   request.setAttribute( "list", nlist);
		   request.setAttribute( "slider", 1);
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
