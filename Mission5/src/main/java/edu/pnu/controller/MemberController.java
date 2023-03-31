package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	MemberService service;
	
	public MemberController() {
		System.out.println("===> MemberController 생성자 호출");
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return service.getMembers();
	}
	
	
	
}
