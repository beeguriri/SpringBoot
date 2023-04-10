package edu.pnu.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.DBoard;
import edu.pnu.service.BoardService;

@RestController
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board")
	//public List<DBoard> getBoardList(Model model) {
	public void getBoardList(Model model) {
		
		List<DBoard> list = boardService.getBoardList();
		model.addAttribute("boardlist", list);
		
	}
	
//	@GetMapping("/board")
//	public List<DBoard> getBoardList(Long seq) {
//		if (seq == null) {
//			System.out.println("getBoard:All");
//			return boardService.getBoardList();
//		}
//		
//		List<DBoard> list = new ArrayList<>();
//		list.add(boardService.getBoard(seq));
//		System.out.println("getBoard: "+ seq);
//		return list;
//		
//	}
	
	@GetMapping("/board/{seq}")
	public DBoard getBoard(@PathVariable Long seq) {
		
		System.out.println("getboard + pathValue: " + seq);
		return boardService.getBoard(seq);
		
	}
	
	
}
