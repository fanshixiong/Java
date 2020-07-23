package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dbutil.Dbconn;
import entity.staff;

public class UpdateStaff {
	public static boolean Update(staff s){
		boolean result=false;
		
		try {
			Connection connection=Dbconn.getConnection();
			String sql="update employee set name=?,sex=?,nation=?,birth=?,phone=?,idcard=?,depart=?,profe=?,email=?,school=?,educat=?,entry=? where id=?";
		
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, s.getName());
			statement.setString(2, s.getSex());
			statement.setString(3, s.getNation());
			statement.setString(4, s.getBirth());
			statement.setString(5, s.getPhone());
			statement.setString(6, s.getIdcard());
			statement.setString(7, s.getDepart());
			statement.setString(8, s.getProfe());
			statement.setString(9, s.getEmail());
			statement.setString(10, s.getSchool());
			statement.setString(11, s.getEducat());
			statement.setString(12, s.getEntry());
			statement.setInt(13, s.getId());
			
			result=statement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
