package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.pnu.dao.DBLogDAO;
import edu.pnu.dao.FileLogDAO;
import edu.pnu.dao.LogDAO;
import edu.pnu.dao.MemberDAOH2Imp;
import edu.pnu.dao.MemberDAOListImp;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	//MemberDAO memDao = new MemberDAOH2Imp();
	//LogDAO log = new DBLogDAO();

	MemberDAO memDao = new MemberDAOListImp();
	LogDAO log = new FileLogDAO();
	
	Map<String, Object> resp = new HashMap<>(); //String에 항목, Object에 멤버정보, 쿼리문 등등
	
	public MemberService() {
		System.out.println("service");
	}

	public List<MemberVO> getMembers() {
		System.out.println("memberlists");
		resp = memDao.getMembers();
		
		List<MemberVO> list = (List<MemberVO>) resp.get("list");
		log.addLog("GET", (String)resp.get("listquery")!=null?
				(String)resp.get("listquery"):(String)resp.get("listerror"), 
				resp.get("listerror")==null? true : false);
		
		return list;
	}

	public MemberVO getMember(String id) {
		System.out.println("getmember");
		
		resp = memDao.getMember(id);
		MemberVO m = (MemberVO) resp.get("get");
		log.addLog("GET", (String)resp.get("getquery")!=null?
				(String)resp.get("getquery"):(String)resp.get("geterror"), 
				resp.get("geterror")==null? true : false);
		
		return m;
	}

	public MemberVO addMember(MemberVO m) {
		System.out.println("addmember");
		
		resp = memDao.addMember(m);
		MemberVO addMem = (MemberVO) resp.get("add");
		log.addLog("POST", (String)resp.get("addquery")!=null?
				(String)resp.get("addquery"):(String)resp.get("adderror"), 
				resp.get("adderror")==null? true : false);
		
		return addMem;
	}
	
	public MemberVO updateMember(MemberVO m) {
		System.out.println("updatemember");
		
		resp = memDao.updateMember(m);
		MemberVO updMem = (MemberVO) resp.get("update");
		log.addLog("PUT", (String)resp.get("upquery")!=null?
				(String)resp.get("upquery"):(String)resp.get("uperror"), 
				resp.get("delerror")==null? true : false);
		
		return updMem;
	}

	public MemberVO deleteMember(String id) {
		System.out.println("deletemember");
		
		resp = memDao.deleteMember(id);
		MemberVO delMem = (MemberVO) resp.get("delete");
		log.addLog("DEL", (String)resp.get("delquery")!=null?
				(String)resp.get("delquery"):(String)resp.get("delerror"), 
				resp.get("delerror")==null? true : false);
		
		return delMem;
	}

}
