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
		// 1����ȡ����ǰҳ��
		String curPageStr = request.getParameter("curPage");
		// �ж�curPage�Ƿ�Ϊ��
		// ���Ϊ�����ǵ�һ�ν���������ʾ��һҳ
		// ����Ĭ��curPage��ֵΪ1
		if(curPageStr == null || "".equals(curPageStr)){
			curPageStr = "1";
		}
		int curPage = Integer.parseInt(curPageStr);
		// 2������ÿҳ��ʾ�����ݵ�����
		int size = 5;
		// 3����ҳ��ѯѧ��
		ArrayList<Product> list = ProductDao.queryByPageAdmin(curPage, size);
		// 4�����ɷ�ҳ�ַ���
		String pageStr = "";
		// 4-1 ��ҳ ��һҳ
		if(curPage != 1){
			pageStr = pageStr + "<li><a href='ProductListServlet?curPage=1'>��ҳ</a></li><li><a href='ProductListServlet?curPage="+(curPage - 1)+"'>��һҳ</a></li>";
		}
		// ��ѯ��Ʒ
		int allCount = ProductDao.queryCntAll();
		// ������ҳ��
		int pageNum = 0;
		if (allCount % size != 0) {
			pageNum = allCount/size + 1;
		} else {
			pageNum = allCount/size;
		}
		// 4-2 ���ɶ�̬ҳ��
		for (int i = 1; i <= pageNum; i++) {
			pageStr = pageStr + "<li";
			if(i == curPage) {
				pageStr += " class='current'";
			}
			pageStr += "><a href='ProductListServlet?curPage="+i+"'>" + i + "</a></li>";
		}
		// 4-3��һҳ βҳ 
		if(curPage < pageNum){
			pageStr = pageStr + "<li><a href='ProductListServlet?curPage="+(curPage + 1)+"'>��һҳ</a></li> <li><a href='ProductListServlet?curPage="+pageNum+"'>βҳ</a></li>";
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
