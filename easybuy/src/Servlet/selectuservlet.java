package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.user;
import Dao.userdao;

/**
 * Servlet implementation class selectuservlet
 */
public class selectuservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectuservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		userdao dao = new userdao();
		ArrayList<user> list = dao.querbypage(curPageInt, size);
			
		// 4、生成分页字符串
		String pageStr = "";
		// 4-1 首页 上一页
		if(curPageInt != 1){
			pageStr = pageStr + "<a href='../selectuservlet?curPage=1'>首页</a><a href='../selectuservlet?curPage="+(curPageInt - 1)+"'>上一页</a>";
		}
		// 查询学生总数
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
			pageStr = pageStr + "<a href='../selectuservlet?curPage="+i+"'>" + i + "</a>";
		}
		// 4-3下一页 尾页 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<a href='../selectuservlet?curPage="+(curPageInt + 1)+"'>下一页</a> <a href='../selectuservlet?curPage="+pageNum+"'>尾页</a>";
		}
		
		
		   request.getSession().setAttribute("pageStr", pageStr);
		   request.getSession().setAttribute("list", list);
		 // request.getRequestDispatcher("manage/user.jsp").forward(request, response);
		   response.sendRedirect("./manage/user.jsp");
		}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		doGet(request, response);
	}

}
