package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.service.BoardService;

@SessionAttributes("member")
@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
//	@GetMapping("/boardList")
//	public List<Board> getboardList() {
//		
//		return boardService.getBoardList();
//	}
	
	@ModelAttribute("member")
	public Member setMember() {
		return new Member();
	}
	
	@GetMapping("/boardList") 
	public String getBoardList(Model model) {
		
//		if(member.getId() == null) 
//			return "redirect:login";
		
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member") Member member, Model model, Board board) {
		
		if(member.getId() == null) 
			return "redirect:login";
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "getBoard";
	}
	
	@GetMapping("/insertBoard")
	public String addBoardView(@ModelAttribute("member") Member member) {
		
		if(member.getId() == null) 
			return "redirect:login";
		
		return "insertBoard";
		
	}
	
	@PostMapping("/insertBoard")
	public String addBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) 
			return "redirect:login";
		
		boardService.addBoard(board); 
		
		return "redirect:boardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) 
			return "redirect:login";
		
		boardService.updateBoard(board);
		
		return "redirect:boardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member") Member member, Board board) {
		
		if(member.getId() == null) 
			return "redirect:login";
		
		boardService.deleteBoard(board);
		
		return "redirect:boardList";
	}
	

}
