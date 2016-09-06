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
		// �����������
		request.setCharacterEncoding("GBK");
		// ��ȡҳ���д��ݹ�����ֵ
		String EN_TITLE = request.getParameter("title");
		String EN_CONTENT = request.getParameter("content");
		 // ��ȡϵͳ��ǰʱ��
		Date date = new Date();
		// ����ǰʱ�䷢�͸������
		// 2016��08��22�� 14ʱ29��01��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����ǰʱ���ʽ��
		String EN_CREATE_TIME = sdf.format(date);
		System.out.println(EN_CREATE_TIME);
		
		//�½�һ�����󱣴�ֵ
		Easybuy_news news=new Easybuy_news();
		news.setEN_TITLE(EN_TITLE);
		news.setEN_CONTENT(EN_CONTENT);
		news.setEN_CREATE_TIME(EN_CREATE_TIME);
		//������Ӳ���
		newsdao dao=new newsdao();
		dao.insert(news);
		
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	 
	 
	}

}
