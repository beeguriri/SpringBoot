package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	
	private List<MemberVO> list = new ArrayList<>();
	
	public MemberService() {
		System.out.println("===> MemberService 생성");
		
		list.add(new MemberVO(1, "1234", "홍길동", new Date()));
		list.add(new MemberVO(2, "5678", "홍이동", new Date()));
		list.add(new MemberVO(3, "0000", "홍삼동", new Date()));
		
	}
	
	public List<MemberVO> getMembers() {
		return list;
	}

	public MemberVO getMember(Integer id) {
		
		for(MemberVO m : list) 
			if(m.getId()==id) 
				return m;
		
		return null;
	}
	
	public MemberVO addMember(MemberVO memberVO) {
		int id = memberVO.getId();
		String pass = memberVO.getPass();
		String name = memberVO.getName();
		memberVO =new MemberVO(id, pass, name, new Date()); 
		list.add(memberVO);
		
		return memberVO;
	}
	
	public MemberVO updateMembers(MemberVO memberVO) {
		
		for(MemberVO m : list) {
			if(m.getId()==memberVO.getId()) {

				m.setPass(memberVO.getPass());
				m.setName(memberVO.getName());
				
				break;
			}
		}
		return null;
	}
	
	public MemberVO removeMember(Integer id) {
		
		for(MemberVO m : list) 
			if(m.getId() == id) 
				return list.remove(id-1);
		
		return null;
	}



}
