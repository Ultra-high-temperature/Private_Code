package javaTest;

import java.sql.*;

public class jdbcTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://116.62.159.13:3306/LLDHL?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "81234567";
        Connection connection = null;
        Statement statement = null;
        Statement statement2 = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            statement2 = connection.createStatement();
            String sql = "Select * from adminOperateLog";
            String sql2 = "Insert into adminOperateLog (adminId) values (258)";

            statement.executeUpdate(sql2);

            ResultSet resultSet = statement2.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + resultSet.getString(3));
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            statement.close();
            connection.close();
        }
    }

}
