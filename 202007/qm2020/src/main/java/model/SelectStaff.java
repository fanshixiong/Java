package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbutil.Dbconn;
import entity.staff;
public class SelectStaff {
	public static staff selectById(int id){
		staff s=null;
		try {
			Connection connection=Dbconn.getConnection();
			String sql="select * from employee where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs=statement.executeQuery();
			if(rs.next()){
				s=new staff();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setSex(rs.getString("sex"));
				s.setNation(rs.getString("nation"));
				s.setBirth(rs.getString("birth"));
				s.setPhone(rs.getString("phone"));
				s.setIdcard(rs.getString("idcard"));
				s.setDepart(rs.getString("depart"));
				s.setProfe(rs.getString("profe"));
				s.setEmail(rs.getString("email"));
				s.setSchool(rs.getString("school"));
				s.setEducat(rs.getString("educat"));
				s.setEntry(rs.getString("entry"));
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}
}
