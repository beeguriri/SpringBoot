package edu.pnu.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.service.MemberService;

@RestController
public class MemberController {

	MemberService service = new MemberService();
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);

	public MemberController() {
		log.info("====> MemberController생성");	
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		return service.getMembers();
	}
	
}
