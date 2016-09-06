package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ConnectionUtil{
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("��������ʧ��");
        }
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy", "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("��ȡ���ݿ����Ӷ���ʧ��");
        }
        return conn;
    }

    public static void closeAll(ResultSet rs, PreparedStatement pstm, Connection conn){
        try {
            conn.close();
            pstm.close();
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("�رն������");
        }
    }

    public static void main(String[] args){
        Connection conn = getConn();
        System.out.println(conn);
    }

}