package edu.pnu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.DBLogDAO;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {

	//Map<Boolean, Object> member = new HashMap<>(); //멤버 정보 저장 ("T/F", "MemberVO 또는 List<MemberVO>)
	//Map<String, String> query = new HashMap<>(); //쿼리 정보 저장("method", "query")	
	Map<Object, String> member = new HashMap<>(); //("멤버정보(MemberVO 또는 List<MemberVO>", "query"))
	MemberDAO memDao = new MemberDAO();

	public MemberService() {
		System.out.println("service");
	}

	public List<MemberVO> getMembers() {
		
		//호출리턴은 map으로 받아서
		member = memDao.getMembers();
		
		//controller return으로는 member의 key값을 넘겨주면 되고,
		List<MemberVO> mem = new ArrayList(member.keySet());
		System.out.println(member);
		System.out.println(mem);
		
		//query정보를 DBLogDAO에 매개변수로 넘겨주자!
		String query = member.values().toString();
		System.out.println(query);
		DBLogDAO logDao = new DBLogDAO("GET", query);
		
		return mem;
	}
	
}
