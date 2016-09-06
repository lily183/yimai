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
		// �����������
		request.setCharacterEncoding("GBK");
		// ��ȡҳ���д��ݹ�����ֵ
		String EC_NICK_NAME = request.getParameter("guestName");
		String EC_TITLE = request.getParameter("guestTitle");
		String EC_CONTENT = request.getParameter("guestContent");
	 	// ��ȡϵͳ��ǰʱ��
		Date date = new Date();
		// ����ǰʱ�䷢�͸������
		// 2016��08��22�� 14ʱ29��01��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����ǰʱ���ʽ��
		String EC_CREATE_TIME = sdf.format(date);
		System.out.println(EC_CREATE_TIME);
		
		//�½�һ�����󱣴�ֵ
		comment com=new comment();
		com.setEC_NICK_NAME(EC_NICK_NAME);
		com.setEC_TITLE(EC_TITLE);
		com.setEC_CONTENT(EC_CONTENT);
		com.setEC_CREATE_TIME(EC_CREATE_TIME);
		System.out.println(com.getEC_CREATE_TIME());
		//������Ӳ���
		commentdao dao=new commentdao();
		dao.insert(com);
		
		request.getRequestDispatcher("fcommentshowServlet").forward(request, response);
	 
	 
	}

}
