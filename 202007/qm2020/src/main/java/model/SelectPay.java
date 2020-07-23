package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbutil.Dbconn;
import entity.pay;

public class SelectPay {
	public static pay selectById(int id){
		pay s=null;
		try {
			Connection connection=Dbconn.getConnection();
			String sql="select * from pay where id=?";
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs=statement.executeQuery();
			if(rs.next()){
				s=new pay();
				s.setId(rs.getInt("id"));
				s.setLeave(rs.getString("leave"));
				s.setBelate(rs.getString("belate"));
				s.setAbsent(rs.getString("absent"));
				s.setBasepay(rs.getString("basepay"));
				s.setBonus(rs.getString("bonus"));
				s.setDepay(rs.getString("depay"));
				s.setRpay(rs.getString("rpay"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return s;
	}

}
