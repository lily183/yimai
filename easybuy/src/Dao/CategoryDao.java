package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Category;
import Bean.CategorySP;

public class CategoryDao {
	// 子类父类联合
	public static CategorySP querySP(int cid, int cpid) {
		Category cat = CategoryDao.queryById(cid);
		Category catP = CategoryDao.queryById(cpid);
		String cname = cat.getCname();
		String cpname = catP.getCname();
		CategorySP sp = new CategorySP();
		sp.setCid(cid);
		sp.setCpid(cpid);
		sp.setCname(cname);
		sp.setCpname(cpname);
		
		return sp;
	}
	// 查询所有父分类
	public static ArrayList<Category> queryParent() {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM easybuy_product_category WHERE EPC_PARENT_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, -1);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Category cat = new Category();
				int cid = rs.getInt("EPC_ID");
				String cname = rs.getString("EPC_NAME");
				int cpid = rs.getInt("EPC_PARENT_ID");
				
				cat.setCid(cid);
				cat.setCname(cname);
				cat.setCpid(cpid);
				
				list.add(cat);
			}
			System.out.println("查询父分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询父分类失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 查询所有子分类
	public static ArrayList<Category> querySon() {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Category> list = new ArrayList<Category>();
		ArrayList<Category> listParent = CategoryDao.queryParent();
		String sql = "SELECT * FROM easybuy_product_category WHERE EPC_PARENT_ID=?";
		try {
			int pid;
			for (int i =0; i < listParent.size(); i++) {
				pid = listParent.get(i).getCid();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, pid);
				rs = pstm.executeQuery();

				while (rs.next()) {
					Category cat = new Category();
					int cid = rs.getInt("EPC_ID");
					String cname = rs.getString("EPC_NAME");
					int cpid = pid;
					
					cat.setCid(cid);
					cat.setCname(cname);
					cat.setCpid(cpid);
					
					list.add(cat);
				}
			}
			System.out.println("查询子分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("查询子分类失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 根据ID查询
	public static Category queryById(int cid) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		Category cat = new Category();
		ResultSet rs = null;
		String sql = "SELECT * FROM easybuy_product_category WHERE EPC_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				String cname = rs.getString("EPC_NAME");
				int cpid = rs.getInt("EPC_PARENT_ID");
				
				cat.setCid(cid);
				cat.setCname(cname);
				cat.setCpid(cpid);
			}
			System.out.println("根据ID查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据ID查询失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cat;
	}
	// 根据父ID查询
	public static ArrayList<Category> queryByPid(int cpid) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM easybuy_product_category WHERE EPC_PARENT_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cpid);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				Category cat = new Category();
				int cid = rs.getInt("EPC_ID");
				String cname = rs.getString("EPC_NAME");
				cat.setCid(cid);
				cat.setCname(cname);
				cat.setCpid(cpid);
				
				list.add(cat);
			}
			System.out.println("根据父类ID查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据父类ID查询失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// 判断是否有父分类，如果有则返回父分类对象，无则将返回对象的id设置为-1
	public static Category havaPid(int cid) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Category cat = new Category();
		String sql = "SELECT * FROM easybuy_product_category WHERE EPC_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, cid);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				int cpid = rs.getInt("EPC_PARENT_ID");
				String cname = rs.getString("EPC_NAME");
				
				if (cpid != -1) {
					cat.setCid(cid);
					cat.setCname(cname);
					cat.setCpid(cpid);
				} else cat.setCid(-1);
			}
			System.out.println("查询成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("根据父类ID查询失败");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cat;
	}
	// 增加分类
	public static void add(Category cat) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "INSERT INTO easybuy_product_category(EPC_NAME,EPC_PARENT_ID) VALUES(?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cat.getCname());
			pstm.setInt(2, cat.getCpid());
			pstm.executeUpdate();
			System.out.println("增加分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("增加分类失败");
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// 修改分类
	public static void update(Category cat) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "UPDATE easybuy_product_category SET EPC_NAME=?,EPC_PARENT_ID=? WHERE " +
				"EPC_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cat.getCname());
			pstm.setInt(2, cat.getCpid());
			pstm.setInt(3, cat.getCid());
			pstm.executeUpdate();
			System.out.println("修改分类成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("修改分类失败");
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// 删除分类
	public static int delete(int id) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "DELETE FROM easybuy_product_category WHERE " +
				"EPC_ID=? OR EPC_PARENT_ID=?";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.setInt(2, id);
			pstm.executeUpdate();
			System.out.println("删除分类成功");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除分类失败");
			return -1;
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
}
