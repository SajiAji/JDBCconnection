package org.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	
	public static void main(String[] args) throws SQLException {
		Connection connect = null;
		try {
//			1
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2
			connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
//			3
			String code = "select * from login";
//			4
			CallableStatement ps = connect.prepareCall(code);
//			5
			ResultSet rs = ps.executeQuery();
//			6
			while (rs.next()) {
				String uname = rs.getString("USERNAME");
				String pwd = rs.getString("PASSWORD");
				
				System.out.println(uname);
				System.out.println(pwd);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			
			
		
			e.printStackTrace();
		}
		finally {
//			7
			connect.close();
		}
		
	}

}
