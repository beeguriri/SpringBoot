package edu.pnu.dao;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBLogDAO implements LogDAO {

	Connection con;
	PreparedStatement ps;
	
	public DBLogDAO() {

		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");

		} catch (Exception e) {
			System.out.println("DB접속 오류");
			e.printStackTrace();
		}
	}
	
	@Override
	public void addLog(String method, String sqlstring, boolean tf) {
		
		try {
			
			String query = "Insert into dblog(method, sqlstring, success) Values(?, ?, ?);";
			
			ps = con.prepareStatement(query);
			ps.setString(1, method);
			ps.setString(2, sqlstring);
			ps.setBoolean(3, tf);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("addLog 오류");
			e.printStackTrace();
		}


	}
	
	
}
