package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAOH2imp implements MemberDAOInterface {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String id;
	private String pass;
	private String name;
	private Date regidate;
	
	private String query;
	
	public MemberDAOH2imp() {
		try {
			Class.forName("org.h2.Driver");
			System.out.println("드라이브 로드");
			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/springboot", "sa", "");
			System.out.println("DB접속");
			
		} catch (Exception e) {
			System.out.println("DB접속오류");
			e.printStackTrace();
		}
	}
	
	@Override
	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		
		try {
			query = "Select * from member";
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getDate(4);
				
				MemberVO member = new MemberVO(id, pass, name, regidate);
				list.add(member);
			}
			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public MemberVO getMember(String id) {

		MemberVO member = null;
		
		try {
			query = "Select * From member Where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getDate(4);
				
				member = new MemberVO(id, pass, name, regidate);
			}			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public MemberVO addMember(MemberVO memberVO) {

		pass = memberVO.getPass();
		name = memberVO.getName();

		try {
			query = "Insert into member(pass, name) Values (?, ?)";
			ps = con.prepareStatement(query);
			ps.setString(1, pass);
			ps.setString(2, name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Insert 오류");
			e.printStackTrace();
		}
		
		List<MemberVO> temp = getMembers();
		String newid = String.valueOf(temp.get(temp.size()-1).getId());
		MemberVO memAdd = getMember(newid);

		return memAdd;
	}

	@Override
	public MemberVO updateMember(MemberVO memberVO) {
		
		id = memberVO.getId();
		pass = memberVO.getPass();
		name = memberVO.getName();
		try {

			if(pass!=null && name!=null) {
				
				query = "Update member Set pass=?, name=? Where id=?";
				ps = con.prepareStatement(query);
				ps.setString(1, pass);
				ps.setString(2, name);
				ps.setString(3, id);
				ps.executeUpdate();
				
			} else if(pass!=null) {
				
				query = "Update member Set pass=? Where id=?";
				ps = con.prepareStatement(query);
				ps.setString(1, pass);
				ps.setString(2, id);
				ps.executeUpdate();
				
			}
			
		} catch (SQLException e) {
			System.out.println("Update 오류");
			e.printStackTrace();
		}
		
		return getMember(id);
	}

	@Override
	public MemberVO removeMember(String id) {

		MemberVO memDel = getMember(id);
		
		try {
			query = "Delete from member where id=?";
			ps = con.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Delete 오류");
			e.printStackTrace();
		}
		
		return memDel;
	}

}
