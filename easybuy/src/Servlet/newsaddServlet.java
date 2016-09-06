package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Dao.newsdao;

/**
 * Servlet implementation class newsaddServlet
 */
public class newsaddServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPut(request, response);
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 解决中文乱码
		request.setCharacterEncoding("GBK");
		// 获取页面中传递过来的值
		String EN_TITLE = request.getParameter("title");
		String EN_CONTENT = request.getParameter("content");
		 // 获取系统当前时间
		Date date = new Date();
		// 将当前时间发送给浏览器
		// 2016年08月22日 14时29分01秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间格式化
		String EN_CREATE_TIME = sdf.format(date);
		System.out.println(EN_CREATE_TIME);
		
		//新建一个对象保存值
		Easybuy_news news=new Easybuy_news();
		news.setEN_TITLE(EN_TITLE);
		news.setEN_CONTENT(EN_CONTENT);
		news.setEN_CREATE_TIME(EN_CREATE_TIME);
		//进行添加操作
		newsdao dao=new newsdao();
		dao.insert(news);
		
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	 
	 
	}

}
