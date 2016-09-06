package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.Easybuy_news;
import Bean.comment;

 

public class newsdao {
    
	// 查询所有新闻信息
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
				 
				int EN_ID = rs.getInt("EN_ID");// 新闻ID
				String EN_TITLE = rs.getString("EN_TITLE");// EN_TITLE       VARCHAR(40) not null,--新闻标题
			    String EN_CONTENT = rs.getString("EN_CONTENT");// EN_CONTENT     VARCHAR(1000) not null,--新闻内容
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");  // EN_CREATE_TIME DATEtime not null--新闻创建时间
				// 创建新闻对象
				Easybuy_news en= new Easybuy_news();
				en.setEN_ID(EN_ID);
			    en.setEN_TITLE(EN_TITLE);
			    en.setEN_CONTENT(EN_CONTENT);
			    en.setEN_CREATE_TIME(EN_CREATE_TIME);
				list.add(en);
				 
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("链接出错了");
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return list;
	}
	
	// 根据ID查询新闻
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
				String EN_TITLE = rs.getString("EN_TITLE");//新闻标题
				String EN_CONTENT = rs.getString("EN_CONTENT");//新闻内容
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");// 新闻时间
			 
				
				// 创建学生对象保存学生信息
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
	

	// 分页查询
	public ArrayList<Easybuy_news> queryByPage(int curPage, int size){
		ArrayList<Easybuy_news> fcList = new ArrayList<Easybuy_news>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from easybuy_news limit ?,?";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			pstm = conn.prepareStatement(sql);
//			第一个参数=(页码-1) * 每个界面显示的个数
			pstm.setInt(1, (curPage-1) * size);
			pstm.setInt(2, size);
			rs = pstm.executeQuery();
			while(rs.next()) {
				
				int EN_ID = rs.getInt("EN_ID");// 新闻ID
				String EN_TITLE = rs.getString("EN_TITLE");// EN_TITLE       VARCHAR(40) not null,--新闻标题
			    String EN_CONTENT = rs.getString("EN_CONTENT");// EN_CONTENT     VARCHAR(1000) not null,--新闻内容
				String EN_CREATE_TIME = rs.getString("EN_CREATE_TIME");  // EN_CREATE_TIME DATEtime not null--新闻创建时间
				// 创建新闻对象
				Easybuy_news en= new Easybuy_news();
				en.setEN_ID(EN_ID);
			    en.setEN_TITLE(EN_TITLE);
			    en.setEN_CONTENT(EN_CONTENT);
			    en.setEN_CREATE_TIME(EN_CREATE_TIME);
			    fcList.add(en);
				/*// 创建留言对象保存留言信息
				Easybuy_news com=new comment();
				com.setEC_ID(rs.getInt("EC_ID"));  // EC_ID          int primary key not null auto_increment,--留言ID
		 		com.setEC_TITLE(rs.getString("EC_TITLE")); // EC_TITLE       VARCHAR(200) not null,--留言标题
		 		com.setEC_CONTENT(  rs.getString("EC_CONTENT"));// EC_CONTENT     VARCHAR(200) not null,--留言内容
		 		com.setEC_CREATE_TIME(rs.getString("EC_CREATE_TIME") ) ; // EC_CREATE_TIME DATETIME not null,--留言创建时间
		 		com.setEC_REPLY(  rs.getString("EC_REPLY")); // EC_REPLY       VARCHAR(200),--回复内容
		 		com.setEC_REPLY_TIME( rs.getString("EC_REPLY_TIME")) ;// EC_REPLY_TIME  DATETIME,--回复时间
		 		com.setEC_NICK_NAME(  rs.getString("EC_NICK_NAME"));// EC_NICK_NAME   VARCHAR(10) not null--留言人昵称
		 		fcList.add( com); */
			 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.closeAll(rs, pstm, conn);
		}
		return fcList;
		
	}
	 
	// 查询新闻总数
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
	
	
	// 添加新闻
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
	
	// 修改新闻
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
	//根据id删除新闻
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
