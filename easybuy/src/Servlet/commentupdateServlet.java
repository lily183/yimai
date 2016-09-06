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
		// �����������
		 
		request.setCharacterEncoding("GBK");
		// ��ȡҳ���д��ݹ�����ֵ
		int EC_ID=Integer.parseInt(request.getParameter("id"));
		String EC_REPLY = request.getParameter("replyContent");
	    // ��ȡϵͳ��ǰʱ��
		Date date = new Date();
		// ����ǰʱ�䷢�͸������
		// 2016��08��22�� 14ʱ29��01��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// ����ǰʱ���ʽ��
		String EC_REPLY_TIME = sdf.format(date);
		//System.out.println(EN_CREATE_TIME);
		
		//�½�һ�����󱣴�ֵ
		 comment com=new  comment();
		 com.setEC_ID(EC_ID);
		 com.setEC_REPLY(EC_REPLY);
		 com.setEC_REPLY_TIME(EC_REPLY_TIME);
		//System.out.println(news.getEN_TITLE());
		//������Ӳ���
		commentdao dao=new commentdao();
		dao.update(com);
		
		request.getRequestDispatcher("manage-result.jsp").forward(request, response);
	 
		
	}

}
