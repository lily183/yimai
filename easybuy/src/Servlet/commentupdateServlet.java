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
 * Servlet implementation class commentupdateServlet
 */
public class commentupdateServlet extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub replyContent
		// 解决中文乱码
		 
		request.setCharacterEncoding("GBK");
		// 获取页面中传递过来的值
		int EC_ID=Integer.parseInt(request.getParameter("id"));
		String EC_REPLY = request.getParameter("replyContent");
	    // 获取系统当前时间
		Date date = new Date();
		// 将当前时间发送给浏览器
		// 2016年08月22日 14时29分01秒
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 将当前时间格式化
		String EC_REPLY_TIME = sdf.format(date);
		//System.out.println(EN_CREATE_TIME);
		
		//新建一个对象保存值
		 comment com=new  comment();
		 com.setEC_ID(EC_ID);
		 com.setEC_REPLY(EC_REPLY);
		 com.setEC_REPLY_TIME(EC_REPLY_TIME);
		//System.out.println(news.getEN_TITLE());
		//进行添加操作
		commentdao dao=new commentdao();
		dao.update(com);
		
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	 
		
	}

}
