package edu.pnu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberDAO;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
		
	MemberDAO dao = new MemberDAO();
	
	public List<MemberVO> getMembers() {
		return dao.getMembers();
	}

	public MemberVO getMember(String id) {
		return dao.getMember(id);
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		return dao.addMember(memberVO);
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		
		return dao.updateMembers(memberVO);
	}
	
	public MemberVO removeMember(String id) {
		
		return dao.removeMember(id);
		
	}



}
