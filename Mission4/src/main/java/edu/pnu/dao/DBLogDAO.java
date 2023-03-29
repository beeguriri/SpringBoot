package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBLogDAO {
	
	public DBLogDAO(String method, String sqlstring) {
		
		try {
			Class.forName("org.h2.Driver");
			Connection con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			
			PreparedStatement ps;
			String query = "Insert into dblog(method, sqlstring) Values(?, ?);";

			ps = con.prepareStatement(query);
			ps.setString(1, method);
			ps.setString(2, sqlstring);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
