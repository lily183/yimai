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
		int size = 8;
		// 3����ҳ��ѯѧ��
		ArrayList<Product> list = ProductDao.queryByPage(cid, curPage, size);
		// 4�����ɷ�ҳ�ַ���
		String pageStr = "";
		// 4-1 ��ҳ ��һҳ
		if(curPage != 1){
			pageStr = pageStr + "<li><a href='FrontendProList?curPage=1&cid="+cid+"'>��ҳ</a></li><li><a href='FrontendProList?curPage="+(curPage - 1)+"&cid="+cid+"'>��һҳ</a></li>";
		}
		// ��ѯ��Ʒ
		int allCount = ProductDao.queryCntByCid(cid);
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
			pageStr += "><a href='FrontendProList?curPage="+i+"&cid="+cid+"'>" + i + "</a></li>";
		}
		// 4-3��һҳ βҳ 
		if(curPage < pageNum){
			pageStr = pageStr + "<li><a href='FrontendProList?curPage="+(curPage + 1)+"&cid="+cid+"'>��һҳ</a></li> <li><a href='FrontendProList?curPage="+pageNum+"&cid="+cid+"'>βҳ</a></li>";
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
