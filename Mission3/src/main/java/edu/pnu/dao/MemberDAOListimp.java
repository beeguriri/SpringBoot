package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.pnu.domain.MemberVO;

public class MemberDAOListimp implements MemberDAOInterface {

	List<MemberVO> list = new ArrayList<>();

	private String id;
	private String pass;
	private String name;
	private Date regidate;
	
	public MemberDAOListimp() {
		System.out.println("MemberDAOListimp 객체 생성");
		System.out.println("Test용 기본 데이터 생성");
		
		for(int i = 0; i <=4; i++) {
			MemberVO temp = new MemberVO(String.valueOf(i+1), "init_data", "init_data", new Date());
			list.add(temp);
		}
	}
	
	@Override
	public List<MemberVO> getMembers() {

		return list;
	}

	@Override
	public MemberVO getMember(String id) {

		for(MemberVO m : list) { 
			if(m.getId().equals(id))
				return m;
		}
		
		System.out.println("찾는 아이디가 없습니다.");
		return null;
	}

	@Override
	public MemberVO addMember(MemberVO memberVO) {

		id = String.valueOf(Integer.parseInt(getMembers().get(getMembers().size()-1).getId())+1);
		pass = memberVO.getPass();
		name = memberVO.getName();
		regidate = new Date();
		
		MemberVO memAdd = new MemberVO(id, pass, name, regidate);
		list.add(memAdd);
		System.out.println("멤버추가완료");
		
		return memAdd;
	}

	@Override
	public MemberVO updateMember(MemberVO memberVO) {
		
		id = memberVO.getId();
		pass = memberVO.getPass();
		name = memberVO.getName();
		
		for(MemberVO m : list) {
			if(m.getId().equals(id)) {
				if(pass!=null && name!=null) {
					m.setPass(pass);
					m.setName(name);	
				} else if(pass!=null)
					m.setPass(pass);
			}
		}
		
		return getMember(id);
	}

	@Override
	public MemberVO removeMember(String id) {
		
		for(MemberVO m : list) {
			if(m.getId().equals(id)) {
				MemberVO memDel = getMember(id);
				list.remove(Integer.parseInt(id)-1);
				return memDel;
			}
		}
		System.out.println("삭제할 데이터가 없습니다.");
		return null;
	}

}
