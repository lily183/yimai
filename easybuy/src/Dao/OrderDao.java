package Dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.order;
import Bean.orderDetail;

public class OrderDao {
	// 添加订单详情
	public static void addDetail(orderDetail od){
		Connection conn=ConnectionUtil.getConn();
		String sql="INSERT INTO easybuy_order_detail(EO_ID,EP_ID,EOD_QUANTITY,EOD_COST) " +
				"VALUES(?,?,?,?)";
		PreparedStatement pstm=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, od.getEO_ID());
			pstm.setInt(2, od.getEP_ID());
			pstm.setInt(3, od.getEOD_QUANTITY());
			pstm.setDouble(4, od.getEO_COST());
			
			pstm.execute();
			System.out.println("添加订单详情成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加订单详情失败");
		}finally{
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// 增加记录并查询订单ID
	public int add(order ord){
		Connection conn=ConnectionUtil.getConn();
		String sql="INSERT INTO easybuy_order(EO_USER_ID,EO_USER_NAME,EO_USER_ADDRESS," +
				"EO_CREATE_TIME,EO_COST,EO_STATUS,EO_TYPE) VALUES(?,?,?,?,?,?,?)";
		String sql1="SELECT * FROM easybuy_order WHERE EO_USER_NAME=? AND EO_CREATE_TIME=?";
		PreparedStatement pstm=null;
		PreparedStatement pstm1=null;
		ResultSet rs=null;
		int oid=0;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, ord.getEO_USER_ID());
			pstm.setString(2, ord.getEO_USER_NAME());
			pstm.setString(3, ord.getEO_USER_ADDRESS());
			pstm.setString(4, ord.getEO_CREATE_TIME());
			pstm.setDouble(5, ord.getEO_COST());
			pstm.setInt(6, ord.getEO_STATUS());
			pstm.setInt(7, ord.getEO_TYPE());
			
			pstm.execute();
			pstm1=conn.prepareStatement(sql1);
			pstm1.setString(1, ord.getEO_USER_NAME());
			pstm1.setString(2, ord.getEO_CREATE_TIME());
			rs = pstm1.executeQuery();
			if(rs.next()){
				oid = rs.getInt("EO_ID");
			}
			System.out.println("添加订单成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加订单失败");
		}finally{
			ConnectionUtil.closeAll(null, pstm, conn);
		}
		return oid;
	}
//根据订单ID
	public order queryByeo_id(int EO_ID){
		order ord=null;
		//System.out.println(EO_ID + " " + EO_USER_NAME);
		Connection conn=ConnectionUtil.getConn();
		String sql="select *from easybuy_order where EO_ID =? ;";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, EO_ID);
			//pstm.setString(2, EO_USER_NAME);
			rs = pstm.executeQuery();
			if (rs.next()) {
				int EO_ID1=rs.getInt("EO_ID");
				String EO_USER_NAME1=rs.getString("EO_USER_NAME");
				String EO_USER_ADDRESS=rs.getString("EO_USER_ADDRESS");
				int EO_STATUS=rs.getInt("EO_STATUS");
				
				ord=new order();
				ord.setEO_ID(EO_ID1);
				ord.setEO_USER_NAME(EO_USER_NAME1);
				ord.setEO_USER_ADDRESS(EO_USER_ADDRESS);
				ord.setEO_STATUS(EO_STATUS);
				
				System.out.println("根据ID查询成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据ID查询失败");
		}finally{
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
	return ord;
	}
//根据用户名字查询订单信息
	public ArrayList<order> queryByeo_user_name(String EO_USER_NAME){
		System.out.println(EO_USER_NAME);
		ArrayList<order> orlist=new ArrayList<order>(); orlist=new ArrayList<order>();
		order ord=null;
		//System.out.println(EO_ID + " " + EO_USER_NAME);
		Connection conn=ConnectionUtil.getConn();
		String sql="select *from easybuy_order where EO_USER_NAME =? ;";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, EO_USER_NAME);
			rs = pstm.executeQuery();
			while (rs.next()) {
				int EO_ID1=rs.getInt("EO_ID");
				String EO_USER_NAME1=rs.getString("EO_USER_NAME");
				String EO_USER_ADDRESS=rs.getString("EO_USER_ADDRESS");
				int EO_STATUS=rs.getInt("EO_STATUS");
				
				ord=new order();
				ord.setEO_ID(EO_ID1);
				ord.setEO_USER_NAME(EO_USER_NAME1);
				ord.setEO_USER_ADDRESS(EO_USER_ADDRESS);
				ord.setEO_STATUS(EO_STATUS);
				orlist.add(ord);
				System.out.println("根据用户名查询成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据用户名查询失败");
		}finally{
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
	return orlist;
	}
//查询订单中所有的信息
	//查询所有
	public static ArrayList<order> queryAll(){
		ArrayList<order> orlist=new ArrayList<order>();
		Connection conn=ConnectionUtil.getConn();
		String sql="select * from easybuy_order ";
		PreparedStatement pstm = null;
	    ResultSet rs = null;
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				int EO_ID=rs.getInt("EO_ID");
				int EO_USER_ID=rs.getInt("EO_USER_ID");
				String 	EO_USER_NAME=rs.getString("EO_USER_NAME");
				String EO_USER_ADDRESS=rs.getString("EO_USER_ADDRESS");
				String EO_CREATE_TIME=rs.getString("EO_CREATE_TIME");
				double EO_COST=rs.getDouble("EO_COST");
				int EO_STATUS=rs.getInt("EO_STATUS");
				int EO_TYPE=rs.getInt("EO_TYPE");
				
				order ord=new order();
				ord.setEO_ID(EO_ID);
				ord.setEO_USER_ID(EO_USER_ID);
				ord.setEO_USER_NAME(EO_USER_NAME);
				ord.setEO_USER_ADDRESS(EO_USER_ADDRESS);
				ord.setEO_CREATE_TIME(EO_CREATE_TIME);
				ord.setEO_COST(EO_COST);
				ord.setEO_STATUS(EO_STATUS);
				ord.setEO_TYPE(EO_TYPE);
				orlist.add(ord);		
				
			}
			
		} catch (Exception e) {
				e.printStackTrace();
		}finally{
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return orlist;
	}
	//删除
	 public   void delete (int EO_ID) {
	        Connection conn = ConnectionUtil.getConn();
	        String sql = "delete from easybuy_order where EO_ID =?; ";
	        PreparedStatement pstm = null;
	        try {
	            pstm = conn.prepareStatement(sql);
	            pstm.setInt(1,EO_ID);
	            pstm.executeUpdate();
	            System.out.println("删除成功！");
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("sorry，删除失败！");
	        } finally {
	            ConnectionUtil.closeAll(null, pstm, conn);
	        }
	 }
//修改商品的信息
	 public void update(order ord){
			Connection conn=ConnectionUtil.getConn();
			String sql="update easybuy_order set EO_USER_NAME=?,EO_USER_ADDRESS=?,EO_STATUS=? where EO_ID=?;";
			PreparedStatement pstm=null;
			try {
				 pstm=conn.prepareStatement(sql);
				 pstm.setString(1,ord.getEO_USER_NAME());
				 pstm.setString(2,ord.getEO_USER_ADDRESS());
				 pstm.setInt(3,ord.getEO_STATUS());
				 pstm.setInt(4, ord.getEO_ID());
				 pstm.executeUpdate();
				 System.out.println("修改成功");
				 
			} catch (Exception e) {
				e.printStackTrace();
				 System.out.println("修改失败");
			}finally{
				ConnectionUtil.closeAll(null, pstm, conn);
			}
			
			
		}
	//分页查询
		public ArrayList<order> querycurPage(int curPage,int size){
			ArrayList<order> cslist=new ArrayList<order>();
			Connection conn=ConnectionUtil.getConn();
			String sql="select * from easybuy_order  limit ?,?;";
			PreparedStatement pstm = null;
		    ResultSet rs = null;
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setInt(1, (curPage-1)*size);
				pstm.setInt(2, size);
				rs=pstm.executeQuery();
				while(rs.next()){
					int EO_ID=rs.getInt("EO_ID");
					int EO_USER_ID=rs.getInt("EO_USER_ID");
					String 	EO_USER_NAME=rs.getString("EO_USER_NAME");
					String EO_USER_ADDRESS=rs.getString("EO_USER_ADDRESS");
					String EO_CREATE_TIME=rs.getString("EO_CREATE_TIME");
					double EO_COST=rs.getDouble("EO_COST");
					int EO_STATUS=rs.getInt("EO_STATUS");
					int EO_TYPE=rs.getInt("EO_TYPE");
					
					order ord=new order();
					ord.setEO_ID(EO_ID);
					ord.setEO_USER_ID(EO_USER_ID);
					ord.setEO_USER_NAME(EO_USER_NAME);
					ord.setEO_USER_ADDRESS(EO_USER_ADDRESS);
					ord.setEO_CREATE_TIME(EO_CREATE_TIME);
					ord.setEO_COST(EO_COST);
					ord.setEO_STATUS(EO_STATUS);
					ord.setEO_TYPE(EO_TYPE);
					cslist.add(ord);
					
				}
				
			} catch (Exception e) {
					e.printStackTrace();
			}finally{
				ConnectionUtil.closeAll(rs, pstm, conn);
			}
			return cslist;
		}
//查询商品总数		
		public int getCount(){
			int count = 0;
			Connection conn = ConnectionUtil.getConn();
			String sql = "select count(*) from easybuy_order";
			PreparedStatement pstm = null;
			ResultSet rs = null;
			try {
				pstm = conn.prepareStatement(sql);
				rs = pstm.executeQuery();
				if (rs.next()) {
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				ConnectionUtil.closeAll(rs, pstm, conn);
			}
			return count;
		}	 
}
