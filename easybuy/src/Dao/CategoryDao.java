package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Category;
import Bean.CategorySP;

public class CategoryDao {
	// ���ุ������
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
	// ��ѯ���и�����
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
			System.out.println("��ѯ������ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ������ʧ��");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// ��ѯ�����ӷ���
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
			System.out.println("��ѯ�ӷ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ѯ�ӷ���ʧ��");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// ����ID��ѯ
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
			System.out.println("����ID��ѯ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("����ID��ѯʧ��");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cat;
	}
	// ���ݸ�ID��ѯ
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
			System.out.println("���ݸ���ID��ѯ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݸ���ID��ѯʧ��");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	// �ж��Ƿ��и����࣬������򷵻ظ�����������򽫷��ض����id����Ϊ-1
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
			System.out.println("��ѯ�ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݸ���ID��ѯʧ��");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return cat;
	}
	// ���ӷ���
	public static void add(Category cat) {
		Connection conn = ConnectionUtil.getConn();
		PreparedStatement pstm = null;
		String sql = "INSERT INTO easybuy_product_category(EPC_NAME,EPC_PARENT_ID) VALUES(?,?)";
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cat.getCname());
			pstm.setInt(2, cat.getCpid());
			pstm.executeUpdate();
			System.out.println("���ӷ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ӷ���ʧ��");
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// �޸ķ���
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
			System.out.println("�޸ķ���ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�޸ķ���ʧ��");
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	// ɾ������
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
			System.out.println("ɾ������ɹ�");
			return 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("ɾ������ʧ��");
			return -1;
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
}
