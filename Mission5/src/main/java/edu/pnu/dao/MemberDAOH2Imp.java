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

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.pnu.domain.MemberVO;

@Repository
public class MemberDAOH2Imp implements MemberDAO {

	@Autowired
	DataSource ds; 
	
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	private MemberVO member;
	private String id;
	private String pass;
	private String name;
	private Date regidate;
	
	private String query;

	Map<String, Object> result = new HashMap<>();
	
	public MemberDAOH2Imp() {
		System.out.println("====> MemberDAOH2Imp 생성자 호출");
	}
	
	@Override
	public Map<String, Object> getMembers() {
		
		List<MemberVO> list = new ArrayList<>(); 
		
		try {
			query = "select * from member;";
			st = ds.getConnection().createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				
				id = rs.getString(1);
				pass = rs.getString(2);
				name = rs.getString(3);
				regidate = rs.getDate(4);
				
				member = new MemberVO(id, pass, name, regidate);
				list.add(member);
			}
			
			result.put("method", "GET");
			result.put("list", list);
			result.put("query", query);
			
		} catch (SQLException e) {
			result.put("errMsg", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Map<String, Object> getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> addMember(MemberVO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> updateMember(MemberVO m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> deleteMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
