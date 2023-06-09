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
	
	Map<Object, String> member = new HashMap<>();
	Map<Object, String> errMsg = new HashMap<>();
	
	private String query;	
	
	public MemberDAO() {
		System.out.println("memberDAO");
		try {
			Class.forName("org.h2.Driver");
			System.out.println("드라이브 로드");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB접속");
			
		} catch (Exception e) {
			System.out.println("DB접속오류");
			errMsg.put(query, e.getMessage());
		}
	}
	
	public Map<Object, String> getMembers() {
		
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
			
			member.put(list, query);
			
			return member;
			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			errMsg.put("error", e.getMessage());
			e.printStackTrace();
			return errMsg;

		}
	}
	
	
	public Map<Object, String> getMember(String id) {
		
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
			
			member.put(mem, query);
			
			return member;

			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			e.printStackTrace();
			errMsg.put("error", e.getMessage());
			
			return errMsg;

		}
	}

	public Map<Object, String> addMember(MemberVO m) {
		
		pass = m.getPass();
		name = m.getName();
		
		try {
			
			query = String.format("Insert into member(pass, name) Values ('%s', '%s');", pass, name);
			System.out.println(query);
			st = con.createStatement();
			st.executeUpdate(query);
			
			MemberVO memAdd = new MemberVO(pass, name);
			
			member.put(memAdd, query);
			
			return member;
			
		} catch (SQLException e) {
			System.out.println("add 오류");
			errMsg.put("error", e.getMessage());
			e.printStackTrace();
			return errMsg;
		}
	}
	
	public Map<Object, String> updateMember(MemberVO m) {
		
		id = m.getId();
		pass = m.getPass();
		name = m.getName();
		regidate = m.getRegidate();
		
		try {
			
			if(pass!=null && name!=null) {
				
				query = String.format("Update member Set pass='%s', name='%s' Where id=%s;", pass, name, id);
				System.out.println(query);
				st = con.createStatement();
				st.executeUpdate(query);
				
			} else if (pass!=null) {
				
				query = String.format("Update member Set pass='%s' Where id=%s;", pass, id);
				System.out.println(query);
				st = con.createStatement();
				st.executeUpdate(query);
				
			}			
			
			MemberVO memUp = new MemberVO(id, pass, name, regidate);
			member.put(memUp, query);
			
			return member;
						
		} catch(Exception e) {
			System.out.println("update 오류");
			errMsg.put("error", e.getMessage());
			e.printStackTrace();

			return errMsg;
		}
	}
	
	public Map<Object, String> deleteMember(String id) {
		
		try {
			
			query = String.format("Delete from member where id=%s;", id);

			st = con.createStatement();
			st.executeUpdate(query);
			
			member.put("del", query);
			
			return member;

			
		} catch (SQLException e) {
			
			System.out.println("Delete 오류");
			errMsg.put("error", e.getMessage());
			e.printStackTrace();			
			return errMsg;
		}
				
	}
	
	
}
