package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBLogDAO {
	
	public DBLogDAO(String method, String sqlstring, boolean tf) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String query = "";
		
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
				
			query = "Insert into dblog(method, sqlstring, success) Values(?, ?, ?);";

			ps = con.prepareStatement(query);
			ps.setString(1, method);
			ps.setString(2, sqlstring);
			ps.setBoolean(3, tf);
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println("DBLogDAO 오류");
			e.printStackTrace();
		}
	}
}
