package edu.pnu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDAO;
import edu.pnu.dao.MemberDAOH2Imp;
import edu.pnu.domain.MemberVO;

@Service
public class MemberService {

	@Autowired
	MemberDAO memberDao;
	
	Map <String,Object> result = new HashMap<>();

	public MemberService() {
		System.out.println("====> MemberService 생성자 호출");
	}
	
	public List<MemberVO> getMembers() {
		
		result = memberDao.getMembers();
		
		return (List<MemberVO>) result.get("list");
	}

}
