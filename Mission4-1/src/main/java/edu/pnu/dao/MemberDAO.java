package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDAO {
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private String id;
	private String pass;
	private String name;
	private Date regidate;
	
	Map<String, Object> resp = new HashMap<>();
	
	public String query;
	
	public MemberDAO() {
		System.out.println("memberDAO");
		try {
			Class.forName("org.h2.Driver");
			System.out.println("드라이브 로드");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB접속");
			
		} catch (Exception e) {
			System.out.println("DB접속오류");
		}
	}
	
	public Map<String, Object> getMembers() {
		
		List<MemberVO> list = new ArrayList<>();
		
		try {
			query = "Select * from member";
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getDate(4);
				
				MemberVO mem = new MemberVO(id, pass, name, regidate);
				list.add(mem);
			}
			
			resp.put("list", list);			
			resp.put("query", query);

			return resp;
			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			resp.put("error", e.getMessage());
			e.printStackTrace();
			return resp;
		}
	}
	
	public Map<String, Object> getMember(String id) {
				
		try {
			
			MemberVO mem = null;
			
			query = String.format("Select * from member where id=%s", id);
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getDate(4);
				
				mem = new MemberVO(id, pass, name, regidate);
			}
			
			resp.put("get", mem);
			resp.put("query", query);
			
			return resp;
			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			resp.put("error", e.getMessage());
			e.printStackTrace();
			
			return resp;
		}
	}
	
	public Map<String, Object> addMember(MemberVO m) {
		
		pass = m.getPass();
		name = m.getName();

		try {
			
			query = String.format("Insert into member(pass, name) Values ('%s', '%s');", pass, name);
			
			st = con.createStatement();
			st.executeUpdate(query);
			
			MemberVO memAdd = new MemberVO(pass, name);
			resp.put("add", memAdd);
			resp.put("query", query);
			
			return resp;

		} catch (SQLException e) {
			System.out.println("Insert 오류");
			resp.put("error", e.getMessage());
			e.printStackTrace();
			
			return resp;
		}
	}

}
