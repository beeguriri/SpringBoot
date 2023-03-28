package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	MemberService service = new MemberService();
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	
	public MemberController() {
		System.out.println("===> MemberController 생성");
		log.info("===> MemberController 생성");
		log.error("Error Message");
		log.warn("warn Message");
		log.info("info Message");
		log.debug("debug Message");
		log.trace("trace Message");
		
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return service.getMember(id);
	}
	
	//브라우저의 요청 맵핑 : dispatcher servlet
	@PostMapping("/member")
	public MemberVO addMember(MemberVO memberVO) {
		
		System.out.println("controller" + memberVO.toString());
		return service.addMember(memberVO);
		
				
	}
	
	@PutMapping("/member")
	public MemberVO updateMembers(MemberVO memberVO) {
		
		System.out.println(memberVO);
		return service.updateMembers(memberVO);
				
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO removeMember(@PathVariable String id) {
		
		return service.removeMember(id);
	}

	
}
