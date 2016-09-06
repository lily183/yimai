package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Easybuy_news;
import Bean.comment;

 

public class newsdao {
    
	// ��ѯ����������Ϣ
	public ArrayList<Easybuy_news> queryAll(){
		ArrayList<Easybuy_news> list = new ArrayList<Easybuy_news>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_news;";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
		 	while(rs.next()){
				 
				int EN_ID = rs.getInt("EN_ID");// ����ID
				String EN_TITLE = rs.getString("EN_TITLE");// EN_TITLE       VARCHAR(40) not null,--���ű���
			    String EN_CONTENT = rs.getString("EN_CONTENT");// EN_CONTENT     VARCHAR(1000) not null,--��������
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");  // EN_CREATE_TIME DATEtime not null--���Ŵ���ʱ��
				// �������Ŷ���
				Easybuy_news en= new Easybuy_news();
				en.setEN_ID(EN_ID);
			    en.setEN_TITLE(EN_TITLE);
			    en.setEN_CONTENT(EN_CONTENT);
			    en.setEN_CREATE_TIME(EN_CREATE_TIME);
				list.add(en);
				 
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
	public Easybuy_news queryById(int EN_ID){
		Easybuy_news news =null;
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_news where EN_ID=?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EN_ID);
			rs = pstm.executeQuery();
			if(rs.next()) {
				news = new Easybuy_news();
				String EN_TITLE = rs.getString("EN_TITLE");//���ű���
				String EN_CONTENT = rs.getString("EN_CONTENT");//��������
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");// ����ʱ��
			 
				
				// ����ѧ�����󱣴�ѧ����Ϣ
			    news.setEN_ID(EN_ID);
			    news.setEN_TITLE(EN_TITLE);
			    news.setEN_CONTENT(EN_CONTENT);
			    news.setEN_CREATE_TIME(EN_CREATE_TIME);
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return news;
	}
	

	// ��ҳ��ѯ
	public ArrayList<Easybuy_news> queryByPage(int curPage, int size){
		ArrayList<Easybuy_news> fcList = new ArrayList<Easybuy_news>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_news limit ?,?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
//			��һ������=(ҳ��-1) * ÿ��������ʾ�ĸ���
			pstm.setInt(1, (curPage-1) * size);
			pstm.setInt(2, size);
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				int EN_ID = rs.getInt("EN_ID");// ����ID
				String EN_TITLE = rs.getString("EN_TITLE");// EN_TITLE       VARCHAR(40) not null,--���ű���
			    String EN_CONTENT = rs.getString("EN_CONTENT");// EN_CONTENT     VARCHAR(1000) not null,--��������
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");  // EN_CREATE_TIME DATEtime not null--���Ŵ���ʱ��
				// �������Ŷ���
				Easybuy_news en= new Easybuy_news();
				en.setEN_ID(EN_ID);
			    en.setEN_TITLE(EN_TITLE);
			    en.setEN_CONTENT(EN_CONTENT);
			    en.setEN_CREATE_TIME(EN_CREATE_TIME);
			    fcList.add(en);
				/*// �������Զ��󱣴�������Ϣ
				Easybuy_news com=new comment();
				com.setEC_ID(rs.getInt("EC_ID"));  // EC_ID          int primary key not null auto_increment,--����ID
		 		com.setEC_TITLE(rs.getString("EC_TITLE")); // EC_TITLE       VARCHAR(200) not null,--���Ա���
		 		com.setEC_CONTENT(  rs.getString("EC_CONTENT"));// EC_CONTENT     VARCHAR(200) not null,--��������
		 		com.setEC_CREATE_TIME(rs.getString("EC_CREATE_TIME") ) ; // EC_CREATE_TIME DATETIME not null,--���Դ���ʱ��
		 		com.setEC_REPLY(  rs.getString("EC_REPLY")); // EC_REPLY       VARCHAR(200),--�ظ�����
		 		com.setEC_REPLY_TIME( rs.getString("EC_REPLY_TIME")) ;// EC_REPLY_TIME  DATETIME,--�ظ�ʱ��
		 		com.setEC_NICK_NAME(  rs.getString("EC_NICK_NAME"));// EC_NICK_NAME   VARCHAR(10) not null--�������ǳ�
		 		fcList.add( com); */
			 
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
		String sql = "select count(*) from easybuy_news";
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
	
	
	// �������
	public void insert( Easybuy_news news){
		Connection conn = ConnectionUtil.getConn();
		String sql = "insert into easybuy_news(EN_TITLE,EN_CONTENT,EN_CREATE_TIME) values(?,?,?)";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,news.getEN_TITLE());
			pstm.setString(2,news.getEN_CONTENT());
			pstm.setString(3,news.getEN_CREATE_TIME());
			 
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	
	// �޸�����
	public void update(Easybuy_news news){
		Connection conn = ConnectionUtil.getConn();
		String sql = "update easybuy_news set EN_TITLE=?,EN_CONTENT=?,EN_CREATE_TIME=? where EN_ID=?";
		PreparedStatement pstm = null;
		 
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, news.getEN_TITLE());
			pstm.setString(2, news.getEN_CONTENT());
		    pstm.setString(3, news.getEN_CREATE_TIME());
			pstm.setInt(4, news.getEN_ID());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}
	//����idɾ������
	public void delete(int EN_ID){
		Connection conn = 
			ConnectionUtil.getConn();
		String sql = "delete from easybuy_news where EN_ID=?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, EN_ID);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(null, pstm, conn);
		}
	}

}
