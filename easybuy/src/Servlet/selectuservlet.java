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
		userdao dao = new userdao();
		ArrayList<user> list = dao.querbypage(curPageInt, size);
			
		// 4�����ɷ�ҳ�ַ���
		String pageStr = "";
		// 4-1 ��ҳ ��һҳ
		if(curPageInt != 1){
			pageStr = pageStr + "<a href='../selectuservlet?curPage=1'>��ҳ</a><a href='../selectuservlet?curPage="+(curPageInt - 1)+"'>��һҳ</a>";
		}
		// ��ѯѧ������
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
			pageStr = pageStr + "<a href='../selectuservlet?curPage="+i+"'>" + i + "</a>";
		}
		// 4-3��һҳ βҳ 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<a href='../selectuservlet?curPage="+(curPageInt + 1)+"'>��һҳ</a> <a href='../selectuservlet?curPage="+pageNum+"'>βҳ</a>";
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
