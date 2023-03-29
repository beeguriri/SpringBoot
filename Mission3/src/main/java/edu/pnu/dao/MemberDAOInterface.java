package edu.pnu.dao;

import java.util.List;

import edu.pnu.domain.MemberVO;

public interface MemberDAOInterface {

	List<MemberVO> getMembers();

	MemberVO getMember(String id);

	MemberVO addMember(MemberVO memberVO);

	MemberVO updateMember(MemberVO memberVO);

	MemberVO removeMember(String id);

}