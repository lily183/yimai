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
 * Servlet implementation class ProductListServlet
 */
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、获取当当前页码
		String curPageStr = request.getParameter("curPage");
		// 判断curPage是否为空
		// 如果为空则是第一次进来，则显示第一页
		// 所有默认curPage的值为1
		if(curPageStr == null || "".equals(curPageStr)){
			curPageStr = "1";
		}
		int curPage = Integer.parseInt(curPageStr);
		// 2、设置每页显示的数据的条数
		int size = 5;
		// 3、分页查询学生
		ArrayList<Product> list = ProductDao.queryByPageAdmin(curPage, size);
		// 4、生成分页字符串
		String pageStr = "";
		// 4-1 首页 上一页
		if(curPage != 1){
			pageStr = pageStr + "<li><a href='ProductListServlet?curPage=1'>首页</a></li><li><a href='ProductListServlet?curPage="+(curPage - 1)+"'>上一页</a></li>";
		}
		// 查询商品
		int allCount = ProductDao.queryCntAll();
		// 计算总页数
		int pageNum = 0;
		if (allCount % size != 0) {
			pageNum = allCount/size + 1;
		} else {
			pageNum = allCount/size;
		}
		// 4-2 生成动态页面
		for (int i = 1; i <= pageNum; i++) {
			pageStr = pageStr + "<li";
			if(i == curPage) {
				pageStr += " class='current'";
			}
			pageStr += "><a href='ProductListServlet?curPage="+i+"'>" + i + "</a></li>";
		}
		// 4-3下一页 尾页 
		if(curPage < pageNum){
			pageStr = pageStr + "<li><a href='ProductListServlet?curPage="+(curPage + 1)+"'>下一页</a></li> <li><a href='ProductListServlet?curPage="+pageNum+"'>尾页</a></li>";
		}
		
		
		request.setAttribute("pageStr", pageStr);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("product.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
