package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;



public class OrderqueryAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderqueryAll() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1����ȡ��ǰҳ��
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
		// 3����ҳ��ѯ��Ʒ
		OrderDao dao = new OrderDao();
		ArrayList<order> orlist = 
			dao.querycurPage(curPageInt, size);
		// 4�����ɷ�ҳ�ַ���
		String pageStr = "";
		// 4-1 ��ҳ ��һҳ
		if(curPageInt != 1){
			pageStr = pageStr + "<a href='OrderqueryAll?curPage=1'>��ҳ</a><a href='OrderqueryAll?curPage="+(curPageInt - 1)+"'>��һҳ</a>";
		}
		// ��ѯ��Ʒ����
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
			pageStr = pageStr + "<a href='OrderqueryAll?curPage="+i+"'>" + i + "</a>";
		}
		// 4-3��һҳ βҳ 
		if(curPageInt < pageNum){
			pageStr = pageStr + "<a href='OrderqueryAll?curPage="+(curPageInt + 1)+"'>��һҳ</a> <a href='OrderqueryAll?curPage="+pageNum+"'>βҳ</a>";
		}
		
		
		request.setAttribute("pageStr", pageStr);
		
		//����
		request.setAttribute("ord", orlist);
		//��ʾ
		request.getRequestDispatcher("order.jsp").forward(request, response);	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
