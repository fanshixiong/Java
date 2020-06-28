package com.frans;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
    @Test
    public void test() throws ClassNotFoundException, SQLException {
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

        //通知数据库开启事务
        connection.setAutoCommit(false); //start transaction

        String sql1 = "update account set money = money-10 where name = 'A'";
        connection.prepareStatement(sql1).executeUpdate();

        try {
            //制造错误
            //int i = 1 / 0;

            String sql2 = "update account set money = money+10 where name = 'B'";
            connection.prepareStatement(sql2).executeUpdate();

            connection.commit();
        } catch (Exception e) {
            connection.rollback();

            e.printStackTrace();
        }

    }
}
