package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbutil.Dbconn;
import entity.pay;
import entity.staff;


@SuppressWarnings("unused")
public class Function {

			public static boolean Update(pay s){
				boolean result=false;
				
				try {
					Connection connection=Dbconn.getConnection();
					String sql="UPDATE employee INNER JOIN pay ON employee.id=pay.id SET  pay.leave=?,pay.belate=?,pay.absent=?,pay.basepay=?,pay.bonus=?,pay.depay=?,pay.rpay=? WHERE pay.id=? ";
					
					PreparedStatement statement=connection.prepareStatement(sql);
					statement.setString(1, s.getLeave());
					statement.setString(2, s.getBelate());
					statement.setString(3, s.getAbsent());
					statement.setString(4, s.getBasepay());
					statement.setString(5, s.getBonus());
					statement.setString(6, s.getDepay());
					statement.setString(7, s.getRpay());	
					statement.setInt(8, s.getId());
					
					result=statement.execute();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return result;
			}
}
