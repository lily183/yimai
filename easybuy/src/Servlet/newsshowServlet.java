package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Bean.comment;
import Dao.commentdao;
import Dao.newsdao;

/**
 * Servlet implementation class newsshowServlet
 */
public class newsshowServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doPost(request, response);
		 
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 处理中文乱码
		request.setCharacterEncoding("GBK");
		
		//分页查询
		// 1、获取当当前页码
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
		// 3、分页查询学生
		newsdao dao = new  newsdao();
		ArrayList<Easybuy_news> list = 
			dao.queryByPage(curPageInt, size);
		// 4、生成分页字符串
		String pageStr = "<li><a href='newsshowServlet?curPage=1'>首页</a></li>";
		// 4-1 首页 上一页
		if(curPageInt != 1){
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+(curPageInt - 1)+"'>上一页</a></li>";
		}
		// 查询留言总数
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
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+i+"'>" + i + "</a></li>";
		}
		// 4-3下一页 尾页 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+(curPageInt + 1)+"'>下一页</a></li>";
		}
		//添加尾页
		pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+pageNum+"'>尾页</a></li>";
		if(list.size()==0){
			request.setAttribute("list", null);
		}
		request.setAttribute("pageStr", pageStr);
		request.setAttribute("list", list);
		request.getRequestDispatcher("news.jsp").forward(request, response);
	
	/*	// 处理中文乱码
		request.setCharacterEncoding("GBK");
		newsdao dao=new newsdao();
	    ArrayList<Easybuy_news> nlist=dao.queryAll();
	    System.out.print(nlist);
	    if(nlist.size()==0){
		  //product p=plist.get(0);
		   request.setAttribute( "list", null);
		   request.getRequestDispatcher("news.jsp").forward(request, response);
	    }else{
		   request.setAttribute( "list", nlist);
		   request.getRequestDispatcher("news.jsp").forward(request, response);
	 } */
	}

}
