package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
    private static String url = "jdbc:mysql://localhost:3306/bookstore?serverTimezone=UTC";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String username = "root";
    private static String password = "123456" ;
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
            e.printStackTrace();
        }catch (SQLException e){
            System.out.println("连接数据库异常");
            e.printStackTrace();
        }
        return connection;

    }
    public static void closeConnection(Connection connection) throws SQLException {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

