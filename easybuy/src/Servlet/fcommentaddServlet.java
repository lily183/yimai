package Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Easybuy_news;
import Bean.comment;
import Dao.commentdao;
import Dao.newsdao;

/**
 * Servlet implementation class fcommentaddServlet
 */
public class fcommentaddServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  doPost(request, response);
	}
 
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 解决中文乱码
		request.setCharacterEncoding("GBK");
		// 获取页面中传递过来的值
		String EC_NICK_NAME = request.getParameter("guestName");
		String EC_TITLE = request.getParameter("guestTitle");
		String EC_CONTENT = request.getParameter("guestContent");
	 	// 获取系统当前时间
		Date date = new Date();
		// 将当前时间发送给浏览器
		// 2016年08月22日 14时29分01秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间格式化
		String EC_CREATE_TIME = sdf.format(date);
		System.out.println(EC_CREATE_TIME);
		
		//新建一个对象保存值
		comment com=new comment();
		com.setEC_NICK_NAME(EC_NICK_NAME);
		com.setEC_TITLE(EC_TITLE);
		com.setEC_CONTENT(EC_CONTENT);
		com.setEC_CREATE_TIME(EC_CREATE_TIME);
		System.out.println(com.getEC_CREATE_TIME());
		//进行添加操作
		commentdao dao=new commentdao();
		dao.insert(com);
		
		request.getRequestDispatcher("fcommentshowServlet").forward(request, response);
	 
	 
	}

}
