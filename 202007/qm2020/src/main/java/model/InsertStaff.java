package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbutil.Dbconn;
import entity.staff;

public class InsertStaff {
	public boolean Insert(staff s){
		try{
			Connection connection=Dbconn.getConnection();
			String sql="insert into employee (id,name,sex,nation,birth,phone,idcard,depart,profe,email,school,educat,entry) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, s.getId());
			statement.setString(2, s.getName());
			statement.setString(3, s.getSex());
			statement.setString(4, s.getNation());
			statement.setString(5, s.getBirth());
			statement.setString(6, s.getPhone());
			statement.setString(7, s.getIdcard());
			statement.setString(8, s.getDepart());
			statement.setString(9, s.getProfe());
			statement.setString(10, s.getEmail());
			statement.setString(11, s.getSchool());
			statement.setString(12, s.getEducat());
			statement.setString(13, s.getEntry());
			
			int result= statement.executeUpdate();
			if(result>0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
			
		}
		
	}

}
