package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.staff;
import dbutil.Dbconn;
public class SearchStaff {
public List<staff> getAllStaff() {
	List<staff>listStaff = new ArrayList<staff>();
	try {
		Connection connection=Dbconn.getConnection();
		String sql="select * from employee";
		PreparedStatement statement=connection.prepareStatement(sql);
		ResultSet rs= statement.executeQuery();
		while(rs.next()){
			staff staffs=new staff();
			staffs.setId(rs.getInt("id"));
			staffs.setName(rs.getString("name"));
			staffs.setSex(rs.getString("sex"));
			staffs.setNation(rs.getString("nation"));
			staffs.setPhone(rs.getString("phone"));
			staffs.setIdcard(rs.getString("idcard"));
			staffs.setDepart(rs.getString("depart"));
			staffs.setProfe(rs.getString("profe"));
			staffs.setEmail(rs.getString("email"));
			staffs.setEntry(rs.getString("entry"));
			staffs.setSchool(rs.getString("school"));
			staffs.setEducat(rs.getString("educat"));
			staffs.setBirth(rs.getString("birth"));
			listStaff.add(staffs);
			
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	return listStaff;
}


public staff load(int pararmId) {
	staff astaff = null;
	Connection connection=Dbconn.getConnection();
	String sql = "select* from employee where id=?";
	try {
		PreparedStatement st = connection.prepareStatement(sql);
		st.setInt(1, pararmId);
		ResultSet rs = st.executeQuery();
		if(rs.next()){
			astaff=new staff();
			astaff.setId(rs.getInt("id"));
			astaff.setName(rs.getString("name"));
			astaff.setSex(rs.getString("sex"));
			astaff.setNation(rs.getString("nation"));
			astaff.setPhone(rs.getString("phone"));
			astaff.setIdcard(rs.getString("idcard"));
			astaff.setDepart(rs.getString("depart"));
			astaff.setProfe(rs.getString("profe"));
			astaff.setEmail(rs.getString("email"));
			astaff.setEntry(rs.getString("entry"));
			astaff.setSchool(rs.getString("school"));
			astaff.setEducat(rs.getString("educat"));
			astaff.setBirth(rs.getString("birth"));
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return astaff;
	
}
}
