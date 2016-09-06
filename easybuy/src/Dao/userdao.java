package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Bean.user;

public class userdao {
	//��ҳ��ѯ
	 public ArrayList<user> querbypage(int curPage, int size){
		Connection conn=ConnectionUtil.getConn();
		ArrayList<user> list=new ArrayList<user>();
		String sql=" select * from easybuy_user limit ?,?";
		PreparedStatement spm=null;
		ResultSet rs=null;
		try {
			spm=conn.prepareStatement(sql);
			spm.setInt(1, (curPage-1) * size);
			spm.setInt(2, size);
			  rs=spm.executeQuery();
			while(rs.next()){
                int id=rs.getInt("EU_USER_ID");//û�з���EU_USER_ID
				String usename=rs.getString("EU_USER_NAME");
				String name=rs.getString("EU_NAME");
				String password=rs.getString("EU_PASSWORD");
				String sex=rs.getString("EU_SEX");
				String birthday=rs.getString("EU_BIRTHDAY");
				String identitycode=rs.getString("EU_IDENTITY_CODE");
				String email=rs.getString("EU_EMAIL");
				String mobile=rs.getString("EU_MOBILE");
				String address=rs.getString("EU_ADDRESS");
				int status=rs.getInt("EU_STATUS");
				user use=new user();
				use.setId(id);
				use.setUsename(usename);
				use.setName(name);
				use.setSex(sex);
				use.setPassword(password);
				use.setStatus(status);
				use.setAddress(address);
				use.setBirthday(birthday);
				use.setEmail(email);
				use.setIdentitycode(identitycode);
				use.setMobil(mobile);
				list.add(use);
				System.out.println("�û���ҳ��ѯ�ɹ�");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("�û���ҳ��ѯʧ��");
		}finally{
			ConnectionUtil.closeAll(rs, spm, conn);
		}
		return list;
	  }
	 //��ѯ�û�������
	 public int getCount(){
			int count = 0;
			Connection conn = ConnectionUtil.getConn();
			String sql = "select count(*) from easybuy_user";
			PreparedStatement spm = null;
			ResultSet rs = null;
			try {
				spm = conn.prepareStatement(sql);
				rs = spm.executeQuery();
				if (rs.next()) {
					count = rs.getInt(1);
				}
				System.out.println("��ѯ�����ɹ�");
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("��ѯ����ʧ��");
			} finally {
				ConnectionUtil.closeAll(rs, spm, conn);
			}
			return count;
		}

	 //��¼ʱ�����ݿ��е��û������������ƥ��
	  public user login(String name,String password){
		Connection conn=ConnectionUtil.getConn();
		String sql="select * from easybuy_user where EU_USER_NAME=? and EU_PASSWORD=?;";
		 user loginuser=null;
		PreparedStatement psm=null;
		ResultSet rs=null;
		try {	
			psm=conn.prepareStatement(sql);
			 psm.setString( 1, name);
			 psm.setString( 2, password);
			 rs=psm.executeQuery();
			if(rs.next()){
				String usename1=rs.getString("EU_USER_NAME");
				String pwd1=rs.getString("EU_PASSWORD");
				int id = rs.getInt("EU_USER_ID");
				String address = rs.getString("EU_ADDRESS");
				int status=rs.getInt("EU_STATUS");
				 loginuser=new user();
				loginuser.setUsename(usename1);
				loginuser.setPassword(pwd1);
				loginuser.setStatus(status);
				System.out.println("user:"+status);
				loginuser.setId(id);
				loginuser.setAddress(address);
			}

			System.out.println("ƥ������ɹ�");
		} catch (Exception e) {
		   e.printStackTrace();
			System.out.println("ƥ������ʧ��");
		}finally{
			ConnectionUtil.closeAll(null, psm, conn);
		}
		return loginuser;
	}
	  //ע��
	  public void add( String name,String password,String sex,String birth, String address){
		  Connection conn=ConnectionUtil.getConn();
		  String sql=" insert into easybuy_user (EU_USER_NAME, EU_PASSWORD, EU_SEX, EU_BIRTHDAY,EU_ADDRESS,EU_STATUS)" +
		  		"values(?,?,?,?,?,1);";
	      PreparedStatement spm=null;
	      try {
	    	  spm=conn.prepareStatement(sql);
	    	  spm.setString(1,name);
	    	  spm.setString(2, password);
	    	  spm.setString(3, sex);
	    	  spm.setString(4, birth);
	    	  spm.setString(5, address);
	    	  spm.executeUpdate();
				System.out.println("���ݿ�ע��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�ע��ʧ��");
		}finally{
			ConnectionUtil.closeAll(null, spm, conn);
		}
	  }
	  //ɾ���û�
	  public void delete(int id){
		  Connection conn=ConnectionUtil.getConn();
		  String sql=" delete from  easybuy_user where EU_USER_ID =?;";
		  PreparedStatement spm=null;
		  try {
			  spm=conn.prepareStatement(sql);
			  spm.setInt(1,id);
			  spm.executeUpdate();
				System.out.println("���ݿ�ɾ���û��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�ɾ���û�ʧ��");
		}finally{
			ConnectionUtil.closeAll(null, spm, conn);
		}
	  }
	  //��̨����û�
	  public void insert(user use){
		  Connection conn=ConnectionUtil.getConn();
		  String sql=" insert into easybuy_user (EU_USER_NAME, EU_PASSWORD, EU_NAME , EU_SEX,EU_BIRTHDAY " +
		  		",EU_MOBILE,EU_ADDRESS ,EU_STATUS )values(?,?,?,?,?,?,?,?);";
		  PreparedStatement spm=null;
		  try {
			  spm=conn.prepareStatement(sql);
			  spm.setString(1, use.getUsename());
			  spm.setString(2, use.getPassword());
			  spm.setString(3, use.getName());
			  spm.setString(4, use.getSex());
			  spm.setString(5, use.getBirthday());
			  spm.setString(6, use.getMobil());
			  spm.setString(7, use.getAddress());
			  spm.setInt(8, use.getStatus());
			  spm.executeUpdate();
				System.out.println("���ݿ�����û��ɹ�");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����û�ʧ��");
		}finally{
			ConnectionUtil.closeAll(null, spm, conn);
		}
	  }
	  //��̨�޸��û�
	  public void update(user use){
		  Connection conn=ConnectionUtil.getConn();
		  String sql="update easybuy_user set EU_USER_NAME=?,EU_PASSWORD=?,EU_NAME=?," +
		  		"EU_SEX=?,EU_BIRTHDAY=?,EU_MOBILE=?,EU_ADDRESS=?,EU_STATUS=1  where EU_USER_ID=?";
		  PreparedStatement spm=null;
		  try {
			 spm=conn.prepareStatement(sql);
			  spm.setString(1, use.getUsename());
			  spm.setString(2, use.getPassword());
			  spm.setString(3, use.getName());
			  spm.setString(4, use.getSex());
			  spm.setString(5, use.getBirthday());
			  spm.setString(6, use.getMobil());
			  spm.setString(7, use.getAddress());
			  spm.setInt(8, use.getId());
			 int a= spm.executeUpdate();
			 System.out.println(a);
				System.out.println("���ݿ��޸��û��ɹ�");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ��޸��û�ʧ��");
		}finally{
			ConnectionUtil.closeAll(null, spm, conn);
		}
	  }
	  //����ID��ѯҪ�޸ĵ��û�
	  public user querybypid(int id){
			Connection conn=ConnectionUtil.getConn();
			String sql="select * from easybuy_user where EU_USER_ID =?;";
			PreparedStatement psm=null;
			ResultSet rs=null;
			user use=new user();
			try {
				psm=conn.prepareStatement(sql);
				psm.setInt(1, id);
			     rs=psm.executeQuery();
			     if(rs.next()){
			    	 String usename=rs.getString("EU_USER_NAME");
						String name=rs.getString("EU_NAME");
						String password=rs.getString("EU_PASSWORD");
						String sex=rs.getString("EU_SEX");
						String birthday=rs.getString("EU_BIRTHDAY");
						String identitycode=rs.getString("EU_IDENTITY_CODE");
						String email=rs.getString("EU_EMAIL");
						String mobile=rs.getString("EU_MOBILE");
						String address=rs.getString("EU_ADDRESS");
						int status=rs.getInt("EU_STATUS");
						use.setId(id);
						use.setUsename(usename);
						use.setName(name);
						use.setSex(sex);
						use.setPassword(password);
						use.setStatus(status);
						use.setAddress(address);
						use.setBirthday(birthday);
						use.setEmail(email);
						use.setIdentitycode(identitycode);
						use.setMobil(mobile);
						System.out.println("���ݿ��ѯ�û��ɹ�");
			     }
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("���ݿ��ѯ�û�ʧ��");
			}finally{
				ConnectionUtil.closeAll(null, psm, conn);
			}
			return use;
		}
	  
}

