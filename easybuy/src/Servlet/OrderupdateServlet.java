package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Dao.OrderDao;

public class OrderupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҪ�޸ĵ���ƷID
		String EO_IDStr=request.getParameter("EO_ID");
		int EO_ID=Integer.parseInt(EO_IDStr);
		//����ID��ѯ��Ʒ��Ϣ
		OrderDao dao=new OrderDao();
		order ord=dao.queryByeo_id(EO_ID);
		//������Ʒ��Ϣ
		request.setAttribute("ord",ord);
		//��ת����Ʒ�޸�ҳ��
		request.getRequestDispatcher("order-modify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
