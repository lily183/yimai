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
            System.out.println("驱动加载失败");
        }
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/easybuy", "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("获取数据库连接对象失败");
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
            System.out.println("关闭对象错误");
        }
    }

    public static void main(String[] args){
        Connection conn = getConn();
        System.out.println(conn);
    }

}