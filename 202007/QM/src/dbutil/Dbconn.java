package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconn {
	public static Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydatebase?useSSL=true&characterEncoding=UTF-8&serverTimezone=UTC";
			String user="root";
			String password="123";
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("找不到服务");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("找不到服务");
			e.printStackTrace();
		}
		return connection;
	}
}
