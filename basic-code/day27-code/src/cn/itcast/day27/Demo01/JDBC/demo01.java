package cn.itcast.day27.Demo01.JDBC;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class demo01 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/db1";
        Connection connection = DriverManager.getConnection(url,"root","root");
        System.out.println(connection);
    }
}
