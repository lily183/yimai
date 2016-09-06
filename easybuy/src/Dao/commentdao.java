package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Easybuy_news;
import Bean.comment;

public class commentdao {
	
	// ��ѯ����������Ϣ
	public ArrayList<comment> queryAll(){
		ArrayList<comment> list = new ArrayList<comment>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_comment;";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 	while(rs.next()){
		 		int    EC_ID = rs.getInt("EC_ID");  // EC_ID          int primary key not null auto_increment,--����ID
		 		String EC_TITLE = rs.getString("EC_TITLE"); // EC_TITLE       VARCHAR(200) not null,--���Ա���
		 		String EC_CONTENT = rs.getString("EC_CONTENT");// EC_CONTENT     VARCHAR(200) not null,--��������
		 		String EC_CREATE_TIME = rs.getString("EC_CREATE_TIME"); // EC_CREATE_TIME DATETIME not null,--���Դ���ʱ��
		 		String EC_REPLY = rs.getString("EC_REPLY"); // EC_REPLY       VARCHAR(200),--�ظ�����
		 		String EC_REPLY_TIME = rs.getString("EC_REPLY_TIME");// EC_REPLY_TIME  DATETIME,--�ظ�ʱ��
		 		String EC_NICK_NAME = rs.getString("EC_NICK_NAME");// EC_NICK_NAME   VARCHAR(10) not null--�������ǳ�
				 
			 	// �������Զ���
				comment cm= new comment();
				cm.setEC_ID(EC_ID);
			    cm.setEC_TITLE(EC_TITLE);
			    cm.setEC_CONTENT(EC_CONTENT);
			    cm.setEC_CREATE_TIME(EC_CREATE_TIME);
			    cm.setEC_REPLY(EC_REPLY);
			    cm.setEC_REPLY_TIME(EC_REPLY_TIME);
			    cm.setEC_NICK_NAME(EC_NICK_NAME);
				list.add(cm);
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ӳ�����");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}

	// ����ID��ѯ����
	public comment queryById(int EC_ID ){
		comment com =null;
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_comment where EC_ID=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EC_ID);
			rs = pstm.executeQuery();
			if(rs.next()) {
				com= new comment();
				com.setEC_ID(EC_ID);
				com.setEC_TITLE(rs.getString("EC_TITLE")); // EC_TITLE       VARCHAR(200) not null,--���Ա���
		 		com.setEC_CONTENT(  rs.getString("EC_CONTENT"));// EC_CONTENT     VARCHAR(200) not null,--��������
		 	    com.setEC_CREATE_TIME( rs.getString("EC_CREATE_TIME") ); // EC_CREATE_TIME DATETIME not null,--���Դ���ʱ��
		 		com.setEC_REPLY( rs.getString("EC_REPLY")); // EC_REPLY       VARCHAR(200),--�ظ�����
		 		com.setEC_REPLY_TIME( rs.getString("EC_REPLY_TIME"));// EC_REPLY_TIME  DATETIME,--�ظ�ʱ��
		 		com.setEC_NICK_NAME( rs.getString("EC_NICK_NAME"));// EC_NICK_NAME   VARCHAR(10) not null--�������ǳ�
		   }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return com;
	}

	// ��ҳ��ѯ
	public ArrayList<comment> queryByPage(int curPage, int size){
		ArrayList<comment> fcList = new ArrayList<comment>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_comment limit ?,?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
//			��һ������=(ҳ��-1) * ÿ��������ʾ�ĸ���
			pstm.setInt(1, (curPage-1) * size);
			pstm.setInt(2, size);
			rs = pstm.executeQuery();
			while(rs.next()) {
				// �������Զ��󱣴�������Ϣ
				comment com=new comment();
				com.setEC_ID(rs.getInt("EC_ID"));  // EC_ID          int primary key not null auto_increment,--����ID
		 		com.setEC_TITLE(rs.getString("EC_TITLE")); // EC_TITLE       VARCHAR(200) not null,--���Ա���
		 		com.setEC_CONTENT(  rs.getString("EC_CONTENT"));// EC_CONTENT     VARCHAR(200) not null,--��������
		 		com.setEC_CREATE_TIME(rs.getString("EC_CREATE_TIME") ) ; // EC_CREATE_TIME DATETIME not null,--���Դ���ʱ��
		 		com.setEC_REPLY(  rs.getString("EC_REPLY")); // EC_REPLY       VARCHAR(200),--�ظ�����
		 		com.setEC_REPLY_TIME( rs.getString("EC_REPLY_TIME")) ;// EC_REPLY_TIME  DATETIME,--�ظ�ʱ��
		 		com.setEC_NICK_NAME(  rs.getString("EC_NICK_NAME"));// EC_NICK_NAME   VARCHAR(10) not null--�������ǳ�
		 		fcList.add( com); 
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return fcList;
		
	}
	 
	// ��ѯ��������
	public int getCount(){
		int count = 0;
		Connection conn = ConnectionUtil.getConn();
		String sql = "select count(*) from easybuy_comment";
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
	
	//����idɾ������
	public void delete(int EC_ID ){
		Connection conn = 
			ConnectionUtil.getConn();
		String sql = "delete from easybuy_comment where EC_ID =?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EC_ID );
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	
	// �������
	public void insert(comment com){
		Connection conn = ConnectionUtil.getConn();
	    String sql = "insert into easybuy_comment (EC_TITLE,EC_CONTENT, EC_CREATE_TIME, EC_NICK_NAME)values (?,?,?,?);";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,com.getEC_TITLE());
		    pstm.setString(2,com.getEC_CONTENT());
		    pstm.setString(3,com.getEC_CREATE_TIME());
			pstm.setString(4,com.getEC_NICK_NAME()); 
		 	pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	
	// �޸�����
	public void update(comment com){
		Connection conn = ConnectionUtil.getConn();
		String sql = "update easybuy_comment set EC_REPLY=?,EC_REPLY_TIME=? where EC_ID=?";
		PreparedStatement pstm = null;
		 
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, com.getEC_REPLY());
			pstm.setString(2, com.getEC_REPLY_TIME());
		   	pstm.setInt(3, com.getEC_ID());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
}
