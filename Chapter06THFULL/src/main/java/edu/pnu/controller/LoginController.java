package edu.pnu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.pnu.domain.Member;
import edu.pnu.service.MemberService;

@SessionAttributes("member")
@Controller
public class LoginController {

	@Autowired
	MemberService memberService;
	
	@GetMapping("/login")
	public void loginView() {
		
	}
	
	@ModelAttribute("member")
	public Member setMember(){
		//시작하자마자 세션에 멤버 객체 하나 넣어놓으려고 (초기화)
		return new Member();
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		
		Member findMember = memberService.getMember(member);
		
		if(findMember !=null && findMember.getPassword().equals(member.getPassword())) {
			model.addAttribute("member", findMember);
			return "redirect:boardList";
		}
		else
			return "redirect:login";
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		
		status.setComplete();
		
		return "redirect:";
	}
}
