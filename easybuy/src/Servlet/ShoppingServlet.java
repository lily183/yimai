package Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.order;
import Bean.orderDetail;
import Dao.OrderDao;

/**
 * Servlet implementation class ShoppingServlet
 */
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK");
		String pcntStr = request.getParameter("pcnt");
		String username = request.getParameter("username");
		String addr = request.getParameter("addr");
		String uidStr = request.getParameter("userid");
		int uid = Integer.parseInt(uidStr);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime=null;
		nowTime = df.format(new Date());
		order ord = new order();
		ord.setEO_USER_ID(uid);
		ord.setEO_USER_NAME(username);
		ord.setEO_USER_ADDRESS(addr);
		ord.setEO_CREATE_TIME(nowTime);
		ord.setEO_STATUS(2);
		ord.setEO_TYPE(1);
		
		
		int pcnt = Integer.parseInt(pcntStr);
		int[] pid = new int[pcnt];
		int[] cnt = new int[pcnt];
		double[] pcost = new double[pcnt];

		String pidStr, cntStr, pcostStr;
		int pidI, cntI;
		double pcostD, totalCost=0;
		for (int i=0; i < pcnt; i++){
			pcostStr = request.getParameter("pcost"+i);
			cntStr = request.getParameter("cnt"+i);
			pcostD = Double.parseDouble(pcostStr);
			cntI = Integer.parseInt(cntStr);
			pcost[i] = pcostD*cntI;
			cnt[i] = cntI;
			totalCost+=pcost[i];
		}
		ord.setEO_COST(totalCost);
		OrderDao od = new OrderDao();
		int oid = od.add(ord);
		System.out.println(oid);
		
		
		for (int j =0; j < pcnt; j++){
			pidStr = request.getParameter("pid"+j);
			pidI = Integer.parseInt(pidStr);
			pid[j] = pidI;
			
			orderDetail oDetail = new orderDetail();
			oDetail.setEO_ID(oid);
			oDetail.setEP_ID(pid[j]);
			oDetail.setEOD_QUANTITY(cnt[j]);
			oDetail.setEO_COST(pcost[j]);
			OrderDao.addDetail(oDetail);
		}
		
		request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
	}

}
