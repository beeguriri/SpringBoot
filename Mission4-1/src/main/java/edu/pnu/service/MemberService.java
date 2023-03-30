package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.DBLogDAO;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	MemberDAO memDao = new MemberDAO();
	DBLogDAO log;
	
	Map<String, Object> resp = new HashMap<>(); //String에 항목, Object에 멤버정보, 쿼리문 등등
	
	public MemberService() {
		System.out.println("service");
	}

	public List<MemberVO> getMembers() {
		System.out.println("memberlists");
		resp = memDao.getMembers();
		
		List<MemberVO> list = (List<MemberVO>) resp.get("list");
		log = new DBLogDAO("GET", (String)resp.get("query")!=null?(String)resp.get("query"):"Error", resp.get("error")==null? true : false);
		
		return list;
	}

	public MemberVO getMember(String id) {
		System.out.println("getmember");
		resp = memDao.getMember(id);
		
		MemberVO m = (MemberVO) resp.get("get");
		log = new DBLogDAO("GET", (String)resp.get("query")!=null?(String)resp.get("query"):"Error", resp.get("error")==null? true : false);

		return m;
	}

	public MemberVO addMember(MemberVO m) {
		System.out.println("addmember");
		
		resp = memDao.addMember(m);
		MemberVO addMem = (MemberVO) resp.get("add");
		log = new DBLogDAO("POST", (String)resp.get("query")!=null?(String)resp.get("query"):"Error", resp.get("error")==null? true : false);
		
		return addMem;
	}
	
	public MemberVO updateMember(MemberVO m) {
		System.out.println("updatemember");
		return null;
	}

	public MemberVO deleteMember(String id) {
		System.out.println("deletemember");
		return null;
	}

}
