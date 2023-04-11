package edu.pnu.controller;

//import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController //mapping : get/post/put/delete 다 사용 가능
@Controller //mapping : get/post만 있음 (숨겨야할정보인지 아닌지만 구분)
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	//get, put, post, delete 다 받을 수 있음
	//url 형태로 구분 또는 value,method 형태로 구분
	@RequestMapping(value="/getBoardList", method=RequestMethod.GET)
	public String getBoardList(Model model) {
		
		List<Board> boardList = boardService.getBoardList();
		
//		for(long i=1; i<=10; i++) {
//			
//			Board board = new Board();
//			board.setSeq(i);
//			board.setTitle("게시판 프로그램 테스트"+i);
//			board.setWriter("도우너");
//			board.setContent("게시판 프로그램 테스트 입니다...");
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardList.add(board);
//		}
		
		model.addAttribute("boardList", boardList);
		
//		return "/WEB-INF/board/getBoardList.jsp";
		//application.properties에서 설정해 주면 줄여서 사용 가능
		return "board/getBoardList"; 
		
	}
	
	//새글 등록 화면
	@GetMapping("/insertBoard")
	public String insertBoardView() {
		
		return "board/insertBoard";
	}
	
	//새글 등록하면 getBoardList로 리다이렉트
	@PostMapping("/insertBoard")
	public String insertBoard(Board board) {
		
		boardService.insertBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("/getBoard")
	public String getBoard(Model model, Board board) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
		return "board/getBoard";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(Board board) {
		
		boardService.updateBoard(board);
		
		return "redirect:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(Board board) {
	
		boardService.deleteBoard(board);
		
		return "redirect:getBoardList";
	}
	
}
