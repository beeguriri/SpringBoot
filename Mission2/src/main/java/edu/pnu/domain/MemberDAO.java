package edu.pnu.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO  {
	
	Connection con = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	String id = "";
	String pass = "";
	String name = "";
	String regidate = "";

	//DB 접속
	public MemberDAO() {
		
		try {
			Class.forName("org.h2.Driver");
			System.out.println("드라이브 로드");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로드 오류");
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB접속");

		} catch (SQLException e) {
			System.out.println("DB접속오류");
			e.printStackTrace();
		}
	}
	
	public List<MemberVO> getMembers() {
		
		List<MemberVO> list = new ArrayList<>();

		try {

			String query = "Select * from member;";
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			int i = 0;
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getString(4);
				MemberVO member = new MemberVO(id, pass, name, regidate);
				list.add(i++, member);
			}
			
		} catch(SQLException e) {
			System.out.println("검색 시 예외 발생");
			e.printStackTrace();
		}
		
		return list;
	}

	public MemberVO getMember(String id) {
		
		try {
			
			String query = "Select * from member where id=?;";
			psmt = con.prepareStatement(query);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			MemberVO member=null;
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getString(4);
				member = new MemberVO(id, pass, name, regidate);
				
			}
			
			return member;
			
		} catch(SQLException e) {
			System.out.println("검색 시 예외 발생");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
								
		try {
			
			String pass = memberVO.getPass();
			String name = memberVO.getName();
			
			String query = "Insert into member(pass, name) values(?, ?);";
			psmt = con.prepareStatement(query);
			psmt.setString(1, pass);
			psmt.setString(2, name);
			psmt.executeUpdate();
			
			List<MemberVO> temp = getMembers();
			String newid = String.valueOf(temp.size());
			
			MemberVO addM = getMember(newid);

			return addM;
			
		} catch(SQLException e) {
			System.out.println("추가 시 예외 발생");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		
		try {
			
			String id = memberVO.getId();
			String pass = memberVO.getPass();
			String name = memberVO.getName();
			
			String data = getMember(id).getId();
			
			if(data.equals(id)) {
				
				String query = "update member Set pass=?, name=? where id=?;";
				
				psmt = con.prepareStatement(query);
				psmt.setString(1, pass);
				psmt.setString(2, name);
				psmt.setString(3, id);
				psmt.executeUpdate();
				
			}
			
			MemberVO updM = getMember(id);
			
			return updM;
			
		} catch(SQLException e) {
			System.out.println("수정 시 예외 발생");
			e.printStackTrace();
		}
			return null;
	}
	
	public MemberVO removeMember(String id) {
		

		try {
			String data = getMember(id).getId();
			
			if(data.equals(id)) {

				MemberVO delM = getMember(id);
				
				String query = "Delete from member where id=?;";
				
				psmt = con.prepareStatement(query);
				psmt.setString(1, id);
				psmt.executeUpdate();
				
				return delM;
			}
			
		} catch(SQLException e) {
			System.out.println("삭제 시 예외 발생");
			e.printStackTrace();
		}
		
		return null;
		
	}
	
}
