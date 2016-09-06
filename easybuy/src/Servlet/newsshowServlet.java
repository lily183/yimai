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
		// ������������
		request.setCharacterEncoding("GBK");
		
		//��ҳ��ѯ
		// 1����ȡ����ǰҳ��
		String curPage = request.getParameter("curPage");
		// �ж�curPage�Ƿ�Ϊ��
		// ���Ϊ�����ǵ�һ�ν���������ʾ��һҳ
		// ����Ĭ��curPage��ֵΪ1
		if(curPage == null || "".equals(curPage)){
			curPage = "1";
		}
		int curPageInt = Integer.parseInt(curPage);
		// 2������ÿҳ��ʾ�����ݵ�����
		int size = 5;
		// 3����ҳ��ѯѧ��
		newsdao dao = new  newsdao();
		ArrayList<Easybuy_news> list = 
			dao.queryByPage(curPageInt, size);
		// 4�����ɷ�ҳ�ַ���
		String pageStr = "<li><a href='newsshowServlet?curPage=1'>��ҳ</a></li>";
		// 4-1 ��ҳ ��һҳ
		if(curPageInt != 1){
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+(curPageInt - 1)+"'>��һҳ</a></li>";
		}
		// ��ѯ��������
		int allCount = dao.getCount();
		// ������ҳ��
		int pageNum = 0;
		if (allCount % size != 0) {
			pageNum = allCount/size + 1;
		} else {
			pageNum = allCount/size;
		}
		// 4-2 ���ɶ�̬ҳ��
		for (int i = 1; i <= pageNum; i++) {
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+i+"'>" + i + "</a></li>";
		}
		// 4-3��һҳ βҳ 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+(curPageInt + 1)+"'>��һҳ</a></li>";
		}
		//���βҳ
		pageStr = pageStr + "<li><a href='newsshowServlet?curPage="+pageNum+"'>βҳ</a></li>";
		if(list.size()==0){
			request.setAttribute("list", null);
		}
		request.setAttribute("pageStr", pageStr);
		request.setAttribute("list", list);
		request.getRequestDispatcher("news.jsp").forward(request, response);
	
	/*	// ������������
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
