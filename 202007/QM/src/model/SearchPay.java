package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.pay;
import dbutil.Dbconn;

public class SearchPay {
	public List<pay> getAllPay() {
		List<pay> listPay = new ArrayList<pay>();
		try {
			Connection connection = Dbconn.getConnection();
			String sql = "select * from pay";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				pay p = new pay();
				p.setId(rs.getInt("id"));
				p.setLeave(rs.getString("leave"));
				p.setBelate(rs.getString("belate"));
				p.setAbsent(rs.getString("absent"));
				p.setBasepay(rs.getString("basepay"));
				p.setBonus(rs.getString("bonus"));
				p.setDepay(rs.getString("depay"));
				p.setRpay(rs.getString("rpay"));
				listPay.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listPay;
	}
	public pay load(int pararmId) {
		pay apay = null;
		Connection connection = Dbconn.getConnection();
		String sql = "select* from pay where id=?";
		try {
			PreparedStatement st1 = connection.prepareStatement(sql);
			st1.setInt(1, pararmId);
			ResultSet rsa = st1.executeQuery();
			if (rsa.next()) {
				apay = new pay();
				apay.setId(rsa.getInt("id"));
				apay.setLeave(rsa.getString("leave"));
				apay.setBelate(rsa.getString("belate"));
				apay.setAbsent(rsa.getString("absent"));
				apay.setBasepay(rsa.getString("basepay"));
				apay.setBonus(rsa.getString("bonus"));
				apay.setDepay(rsa.getString("depay"));
				apay.setRpay(rsa.getString("rpay"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return apay;
	}
}
