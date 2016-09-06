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
 * Servlet implementation class FrontendProList
 */
public class FrontendProList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontendProList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cidStr = request.getParameter("cid");
		int cid = Integer.parseInt(cidStr);
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
		int size = 8;
		// 3、分页查询学生
		ArrayList<Product> list = ProductDao.queryByPage(cid, curPage, size);
		// 4、生成分页字符串
		String pageStr = "";
		// 4-1 首页 上一页
		if(curPage != 1){
			pageStr = pageStr + "<li><a href='FrontendProList?curPage=1&cid="+cid+"'>首页</a></li><li><a href='FrontendProList?curPage="+(curPage - 1)+"&cid="+cid+"'>上一页</a></li>";
		}
		// 查询商品
		int allCount = ProductDao.queryCntByCid(cid);
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
			pageStr += "><a href='FrontendProList?curPage="+i+"&cid="+cid+"'>" + i + "</a></li>";
		}
		// 4-3下一页 尾页 
		if(curPage < pageNum){
			pageStr = pageStr + "<li><a href='FrontendProList?curPage="+(curPage + 1)+"&cid="+cid+"'>下一页</a></li> <li><a href='FrontendProList?curPage="+pageNum+"&cid="+cid+"'>尾页</a></li>";
		}
		
		
		request.setAttribute("pageStr", pageStr);
		request.setAttribute("plist", list);
		
		ArrayList<Category> clistParent = CategoryDao.queryParent();
		request.setAttribute("listP", clistParent);
		ArrayList<Category> clistSon = CategoryDao.querySon();
		request.setAttribute("listS", clistSon);
		request.getRequestDispatcher("product-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
