package Dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Product;

public class ProductDao {
	// 查询商品总数
	public static int queryCntAll() {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT COUNT(*) FROM easybuy_product";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int cnt=0;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
			
			pstm.executeQuery();
			System.out.println("根据分类ID查询商品数量成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据分类ID查询商品数量失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cnt;
	}
	// 根据分类ID查询商品总数
	public static int queryCntByCid(int cid) {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT COUNT(*) FROM easybuy_product WHERE EPC_ID=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int cnt=0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();
			while(rs.next()) {
				cnt = rs.getInt("COUNT(*)");
			}
			
			pstm.executeQuery();
			System.out.println("根据分类ID查询商品数量成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据分类ID查询商品数量失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cnt;
	}
	// 分页查询，所有分类
	public static ArrayList<Product> queryByPageAdmin (int curPage, int size) {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product ORDER BY EP_ID DESC LIMIT ?,?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, (curPage-1)*size);
			pstm.setInt(2, size);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("EP_ID");
				int cid = rs.getInt("EPC_ID");
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				double pprice = rs.getDouble("EP_PRICE");
				int pstock = rs.getInt("EP_STOCK");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = cid;
				String pfileName = rs.getString("EP_FILE_NAME");
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				Product pro = new Product();
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPprice(pprice);
				pro.setPstock(pstock);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
				
				list.add(pro);
			}
			
			pstm.executeQuery();
			System.out.println("查询最新特价信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询最新特价信息失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 分页查询
	public static ArrayList<Product> queryByPage (int cid, int curPage, int size) {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product WHERE EPC_ID=? ORDER BY EP_ID DESC LIMIT ?,?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			pstm.setInt(2, (curPage-1)*size);
			pstm.setInt(3, size);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("EP_ID");
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				double pprice = rs.getDouble("EP_PRICE");
				int pstock = rs.getInt("EP_STOCK");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = cid;
				String pfileName = rs.getString("EP_FILE_NAME");
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				Product pro = new Product();
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPprice(pprice);
				pro.setPstock(pstock);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
				
				list.add(pro);
			}
			
			pstm.executeQuery();
			System.out.println("查询最新特价信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询最新特价信息失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 查询最近八个特价商品
	public static ArrayList<Product> querySpecialPrice() {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product WHERE EP_SPECIAL_PRICE=1 ORDER BY EP_ID DESC LIMIT 0, 8";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("EP_ID");
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				double pprice = rs.getDouble("EP_PRICE");
				int pstock = rs.getInt("EP_STOCK");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = rs.getInt("EPC_ID");
				String pfileName = rs.getString("EP_FILE_NAME");
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				Product pro = new Product();
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPprice(pprice);
				pro.setPstock(pstock);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
				
				list.add(pro);
			}
			
			pstm.executeQuery();
			System.out.println("查询最新特价信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询最新特价信息失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 查询最近八个特卖商品
	public static ArrayList<Product> querySpecialBuy() {
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product WHERE EP_SPECIAL_BUY=1 ORDER BY EP_ID DESC LIMIT 0, 12";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("EP_ID");
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				double pprice = rs.getDouble("EP_PRICE");
				int pstock = rs.getInt("EP_STOCK");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = rs.getInt("EPC_ID");
				String pfileName = rs.getString("EP_FILE_NAME");
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				Product pro = new Product();
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPprice(pprice);
				pro.setPstock(pstock);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
				
				list.add(pro);
			}
			
			pstm.executeQuery();
			System.out.println("查询最新特价信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询最新特价信息失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 新增商品
	public static int insert (Product pro) {	
		Connection conn = ConnectionUtil.getConn();
		String sql = "INSERT INTO easybuy_product(EP_NAME,EP_DESCRIPTION,EP_PRICE," +
				"EP_STOCK,EP_BRAND,EP_CODE,EPC_ID,EP_FILE_NAME,EP_SPECIAL_PRICE,EP_SPECIAL_BUY)" +
				" VALUES(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getPname());
			pstm.setString(2, pro.getPdesc());
			pstm.setDouble(3, pro.getPprice());
			pstm.setInt(4, pro.getPstock());
			pstm.setString(5, pro.getPbrand());
			pstm.setInt(6, pro.getPcode());
			pstm.setInt(7, pro.getPcatId());
			pstm.setString(8, pro.getPfileName());
			pstm.setInt(9, pro.getPspecPrice());
			pstm.setInt(10, pro.getPspecBuy());
			
			pstm.executeUpdate();
			System.out.println("添加商品成功");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加商品失败");
			return -1;
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// 修改商品信息
	public static int update (Product pro) {	
		Connection conn = ConnectionUtil.getConn();
		String sql = "UPDATE easybuy_product SET EP_NAME=?,EP_DESCRIPTION=?," +
			"EP_PRICE=?,EP_STOCK=?,EP_BRAND=?,EP_CODE=?,EPC_ID=?,EP_FILE_NAME=?," +
			"EP_SPECIAL_PRICE=?,EP_SPECIAL_BUY=? WHERE EP_ID=?;";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, pro.getPname());
			pstm.setString(2, pro.getPdesc());
			pstm.setDouble(3, pro.getPprice());
			pstm.setInt(4, pro.getPstock());
			pstm.setString(5, pro.getPbrand());
			pstm.setInt(6, pro.getPcode());
			pstm.setInt(7, pro.getPcatId());
			pstm.setString(8, pro.getPfileName());
			pstm.setInt(9, pro.getPspecPrice());
			pstm.setInt(10, pro.getPspecBuy());
			pstm.setInt(11, pro.getPid());
			System.out.println(pro.getPid());
			
			pstm.executeUpdate();
			System.out.println("修改商品信息成功");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改商品信息失败");
			return -1;
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// 查询商品信息
	public static ArrayList<Product> query () {	
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				int pid = rs.getInt("EP_ID");
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				double pprice = rs.getDouble("EP_PRICE");
				int pstock = rs.getInt("EP_STOCK");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = rs.getInt("EPC_ID");
				String pfileName = rs.getString("EP_FILE_NAME");
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				Product pro = new Product();
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPprice(pprice);
				pro.setPstock(pstock);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
				
				list.add(pro);
			}
			
			pstm.executeQuery();
			System.out.println("查询商品信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询商品信息失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 根据ID查询商品信息
	public static Product queryById (int pid) {	
		Connection conn = ConnectionUtil.getConn();
		String sql = "SELECT * FROM easybuy_product WHERE EP_ID=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Product pro = new Product();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pid);
			rs = pstm.executeQuery();
			while(rs.next()) {
				String pname = rs.getString("EP_NAME");
				String pdesc = rs.getString("EP_DESCRIPTION");
				int pstock = rs.getInt("EP_STOCK");
				double pprice = rs.getDouble("EP_PRICE");
				String pbrand = rs.getString("EP_BRAND");
				int pcode = rs.getInt("EP_CODE");
				int pcatId = rs.getInt("EPC_ID");
				String pfileName = rs.getString("EP_FILE_NAME");
				System.out.println("数据库："+pfileName);
				int pspecPrice = rs.getInt("EP_SPECIAL_PRICE");
				int pspecBuy = rs.getInt("EP_SPECIAL_BUY");
				
				pro.setPid(pid);
				pro.setPname(pname);
				pro.setPdesc(pdesc);
				pro.setPstock(pstock);
				pro.setPprice(pprice);
				pro.setPbrand(pbrand);
				pro.setPcode(pcode);
				pro.setPcatId(pcatId);
				pro.setPfileName(pfileName);
				pro.setPspecPrice(pspecPrice);
				pro.setPspecBuy(pspecBuy);
			}
			
			pstm.executeQuery();
			System.out.println("查询商品信息成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询商品信息失败");
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
		return pro;
	}
	// 删除商品信息
	public static int delete(int pid) {
		Connection conn = ConnectionUtil.getConn();
		String sql = "DELETE FROM easybuy_product WHERE EP_ID=?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, pid);
			pstm.executeUpdate();
			System.out.println("删除商品信息成功");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除商品信息失败");
			return -1;
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
}
