package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDAOH2imp;
import edu.pnu.dao.MemberDAOInterface;
import edu.pnu.dao.MemberDAOListimp;
import edu.pnu.domain.MemberVO;

public class MemberService {
	
	private MemberDAOInterface memberDao; 
	
	public MemberService() {
		memberDao = new MemberDAOH2imp();	//H2 클래스 객체
		//memberDao = new MemberDAOListimp();	//list 클래스 객체
	}

	public List<MemberVO> getMembers() {		
		return memberDao.getMembers();
	}

	public MemberVO getMember(String id) {
		return memberDao.getMember(id);
	}

	public MemberVO addMember(MemberVO member) {
		return memberDao.addMember(member);
	}

	public MemberVO updateMember(MemberVO member) {
		return memberDao.updateMember(member);
	}

	public MemberVO removeMember(String id) {
		return memberDao.removeMember(id);
	}
}
