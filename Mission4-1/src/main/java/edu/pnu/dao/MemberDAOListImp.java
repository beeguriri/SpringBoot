package edu.pnu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.integration.IntegrationAutoConfiguration;

import edu.pnu.domain.MemberVO;

public class MemberDAOListImp implements MemberDAO {
	
	private String id;
	private String pass;
	private String name;
	private Date regidate;
		
	Map<String, Object> resp = new HashMap<>();
	
	public MemberDAOListImp() {
		
		System.out.println("MemberDAOListimp 객체 생성");
		System.out.println("Test용 기본 데이터 생성");
		
		List<MemberVO> list = new ArrayList<>();
		
		for(int i = 1; i <=5; i++) {
			MemberVO temp = new MemberVO(String.valueOf(i), "init_data", "init_data", new Date());
			list.add(temp);
		}
		resp.put("list", list);
		resp.put("listquery", "list_success");
	}
	
	@Override
	public Map<String, Object> getMembers() {
		
		return resp;
	}

	@Override
	public Map<String, Object> getMember(String id) {

		List<MemberVO> list = (List<MemberVO>) getMembers().get("list"); 

		for(MemberVO o : list) {
			if(o.getId().equals(id)) {
				resp.put("get", o);
				resp.put("getquery", "get_success");
			}
			else 
				resp.put("geterror", "get_fail");
			
		}
		
		
		return resp;
	}

	@Override
	public Map<String, Object> addMember(MemberVO m) {

		List<MemberVO> list = (List<MemberVO>) getMembers().get("list");  
		
		id = String.valueOf(Integer.parseInt(list.get(list.size()-1).getId())+1);
		pass = m.getPass();
		name = m.getName();
		regidate = new Date();
		
		if(pass==null || name==null) {
			resp.put("adderror", "add_fail");
		} else {
		
			MemberVO memAdd = new MemberVO(id, pass, name, regidate);
			list.add(memAdd);
			
			resp.put("list", list);
			resp.put("add", memAdd);
			resp.put("addquery", "add_success");
			System.out.println("멤버추가완료");
		}
		return resp;
		
	}

	@Override
	public Map<String, Object> updateMember(MemberVO m) {
		
		List<MemberVO> list = (List<MemberVO>) getMembers().get("list");
		
		id = m.getId();
		pass = m.getPass();
		name = m.getName();
		
		for(MemberVO o : list) {
			
			if(id.equals(o.getId())) {
				
				if(pass!=null && name!=null) {
					o.setPass(pass);
					o.setName(name);
				} else if (pass!=null) {
					o.setPass(pass);
				}
				
				MemberVO memUp = (MemberVO) getMember(id).get("get");
				
				resp.put("list", list);
				resp.put("update", memUp);
				resp.put("upquery", "update_success");
				System.out.println("멤버수정완료");
				
			} else 
				resp.put("puterror", "put_fail");
		}

		return resp;
	}

	@Override
	public Map<String, Object> deleteMember(String id) {
		
		List<MemberVO> list = (List<MemberVO>) getMembers().get("list");
		MemberVO temp = null;
		
		for(MemberVO o : list) {
			if(o.getId().equals(id)) {
				temp = o;
				list.remove(id);
				resp.put("list", list);
				resp.put("delete", temp);
				resp.put("delquery", "delete_success");

				System.out.println("멤버삭제완료");
				
			} else 
				resp.put("delerror", "del_fail");
		}
		
		

		return resp;
	}
}
