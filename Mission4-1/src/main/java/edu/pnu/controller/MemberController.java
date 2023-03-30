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
	
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	MemberService service = new MemberService();

	public MemberController() {
		log.info("====> MemberController생성");	
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable String id) {
		return service.getMember(id);
	}
	
	@PostMapping("/member")
	public MemberVO addMember(MemberVO m) {
		return service.addMember(m);
	}
	
	@PutMapping("/member")
	public MemberVO updateMember(MemberVO m) {
		return service.updateMember(m);
	}
	
	@DeleteMapping("/member/{id}")
	public MemberVO deleteMember(@PathVariable String id) {
		return service.deleteMember(id);
	}
	

}
