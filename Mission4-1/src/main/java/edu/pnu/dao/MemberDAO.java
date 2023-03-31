package edu.pnu.dao;

import java.util.Map;

import edu.pnu.domain.MemberVO;

public interface MemberDAO {

	Map<String, Object> getMembers();

	Map<String, Object> getMember(String id);

	Map<String, Object> addMember(MemberVO m);

	Map<String, Object> updateMember(MemberVO m);

	Map<String, Object> deleteMember(String id);

}