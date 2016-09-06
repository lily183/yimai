package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;



public class OrderqueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderqueryAll() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1、获取当前页码
		String curPage = request.getParameter("curPage");
		// 判断curPage是否为空
		// 如果为空则是第一次进来，则显示第一页
		// 所有默认curPage的值为1
		if(curPage == null || "".equals(curPage)){
			curPage = "1";
		}
		int curPageInt = Integer.parseInt(curPage);
		// 2、设置每页显示的数据的条数
		int size = 5;
		// 3、分页查询商品
		OrderDao dao = new OrderDao();
		ArrayList<order> orlist = 
			dao.querycurPage(curPageInt, size);
		// 4、生成分页字符串
		String pageStr = "";
		// 4-1 首页 上一页
		if(curPageInt != 1){
			pageStr = pageStr + "<a href='OrderqueryAll?curPage=1'>首页</a><a href='OrderqueryAll?curPage="+(curPageInt - 1)+"'>上一页</a>";
		}
		// 查询商品总数
		int allCount = dao.getCount();
		// 计算总页数
		int pageNum = 0;
		if (allCount % size != 0) {
			pageNum = allCount/size + 1;
		} else {
			pageNum = allCount/size;
		}
		// 4-2 生成动态页面
		for (int i = 1; i <= pageNum; i++) {
			pageStr = pageStr + "<a href='OrderqueryAll?curPage="+i+"'>" + i + "</a>";
		}
		// 4-3下一页 尾页 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<a href='OrderqueryAll?curPage="+(curPageInt + 1)+"'>下一页</a> <a href='OrderqueryAll?curPage="+pageNum+"'>尾页</a>";
		}
		
		
		request.setAttribute("pageStr", pageStr);
		
		//保存
		request.setAttribute("ord", orlist);
		//显示
		request.getRequestDispatcher("order.jsp").forward(request, response);	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
