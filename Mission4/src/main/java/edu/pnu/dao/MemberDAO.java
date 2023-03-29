package edu.pnu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.domain.MemberVO;

public class MemberDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private String id;
	private String pass;
	private String name;
	private Date regidate;
	
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
			e.printStackTrace();
		}
	}
	
	public Map<Object, String> getMembers() {
		
		Map<Object, String> member = new HashMap<>();
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
				
				MemberVO mem = new MemberVO(id, pass, name, regidate);
				list.add(mem);
			}
			
			member.put(list, query);
			
		} catch (SQLException e) {
			System.out.println("Select 오류");
			e.printStackTrace();
		}
		return member;
	}
	
	
}
