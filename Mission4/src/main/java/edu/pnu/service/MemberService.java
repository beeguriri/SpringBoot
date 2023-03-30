package edu.pnu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.DBLogDAO;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {

	Map<Object, String> member = new HashMap<>(); //("멤버정보(MemberVO 또는 List<MemberVO>", "query"))

	MemberDAO memDao = new MemberDAO();
	DBLogDAO logDao;	

	public MemberService() {
		System.out.println("service영역 진입");
	}

	public List<MemberVO> getMembers() {
		
		//호출리턴은 map으로 받아서
		member = memDao.getMembers();
		List<MemberVO> mem = new ArrayList(member.keySet());
		
		//member.keySet().toArray()
		
		if(!mem.contains("error")) {
		
			//controller return으로는 member의 key값을 넘겨주면 되고,
//			System.out.println(member);
//			System.out.println(mem);
			
			//query정보를 DBLogDAO에 매개변수로 넘겨주자!
			String query = member.values().toString();
			System.out.println(query);
			
			logDao = new DBLogDAO("GET", query, true);
			
			return mem;
			
		} else {
			
			String errMsg = member.get("error");
			logDao = new DBLogDAO("GET", errMsg, false);
			
			return null;
		}
	}

	public MemberVO getMember(String id) {
		
		member = memDao.getMember(id);
		List<MemberVO> mem = new ArrayList(member.keySet());
		
		if(!mem.contains("error")) {
			
			MemberVO memGet = mem.get(mem.size()-1);
			
			String query = member.values().toString();
			logDao = new DBLogDAO("GET", query, true);
			
			return memGet;
			
		} else {
		
			String errMsg = member.get("error");
			logDao = new DBLogDAO("GET", errMsg, false);
			
			return null;
		}
		
		
	}

	public MemberVO addMember(MemberVO m) {
		
		member = memDao.addMember(m);
		List<MemberVO> mem = new ArrayList(member.keySet());
		
		if(!mem.contains("error")) {
			MemberVO memAdd = mem.get(mem.size()-1);
			
			String query = member.values().toString();
			logDao = new DBLogDAO("POST", query, true);
			
			return memAdd;
			
		} else {
			String errMsg = member.get("error");
			logDao = new DBLogDAO("POST", errMsg, false);
			
			return null;

		}
	}

	public MemberVO updateMember(MemberVO m) {

		member = memDao.updateMember(m);
		List<MemberVO> mem = new ArrayList(member.keySet());
		
		if(!mem.contains("error")) {
			
			MemberVO memUp = mem.get(mem.size()-1);
			
			String query = member.values().toString();
			logDao = new DBLogDAO("PUT", query, true);
			
			return memUp;
			
		} else {
			
			String errMsg = member.get("error");
			logDao = new DBLogDAO("PUT", errMsg, false);
			
			return null;
		}
	}

	public MemberVO deleteMember(String id) {

		//삭제할 멤버정보
		Map<Object, String> delMemMap = memDao.getMember(id);
		List<MemberVO> delMemList = new ArrayList(delMemMap.keySet());

		//정보가 있으면 삭제
		if(!delMemList.contains("error")) {
			MemberVO memDel = delMemList.get(delMemList.size()-1);
			
			member = memDao.deleteMember(id);
			String query = member.get("del");
			logDao = new DBLogDAO("DELETE", query, true);
			return memDel;
		} else {
			String errMsg = member.get("error");
			logDao = new DBLogDAO("DELETE", errMsg, false);
			
			return null;
		}
		
	}
	
}
