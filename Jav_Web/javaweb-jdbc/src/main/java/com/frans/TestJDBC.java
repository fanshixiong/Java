package com.frans;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    @Test
    public void test()throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8";
        String username = "root";
        String password = "123456";

        //1.加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.向数据库发送sql的对象
        Statement statement = connection.createStatement();

        //4.编写sql
        String sql = "select * from users";

        //5.执行sql, 返回结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id="+resultSet.getObject("id"));
            System.out.println("name="+resultSet.getObject("name"));
            System.out.println("password="+resultSet.getObject("password"));
            System.out.println("address="+resultSet.getObject("address"));
        }

        //6. 关闭连接释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
