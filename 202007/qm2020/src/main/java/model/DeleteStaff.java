package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbutil.Dbconn;

public class DeleteStaff {
	public boolean Delete(int id) {
		// TODO Auto-generated method stub
		boolean result=false;
		try {
			Connection connection=Dbconn.getConnection();
			String sql="delete from employee where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			result= statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	};
}

