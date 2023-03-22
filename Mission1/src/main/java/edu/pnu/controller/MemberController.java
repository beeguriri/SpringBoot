package edu.pnu.controller;

import java.util.List;

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
//	private static final Logger log = LoggerFactory.getILoggerFactory();
	
	public MemberController() {
		System.out.println("===> MemberController 생성");
	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers() {
		
		return service.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable Integer id) {
		return service.getMember(id);
	}
	
	//폼 만들어서 제출하면 데이터 들어옴
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
	public MemberVO removeMember(@PathVariable Integer id) {
		
		return service.removeMember(id);
	}

	
}
