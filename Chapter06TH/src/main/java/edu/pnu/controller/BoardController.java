package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;

//@RestController
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
//
//	@GetMapping("/hello")
//	public String thymeleafTest(Model model) {
//		
//		model.addAttribute("hello", "hello world");
//		return "/hello";
//		
//	}
	
//	@GetMapping("/getBoardList")
//  public String getBoardList(Model model) {
//	public List<Board> getBoardList(){

////	public @ResponseBody List<Board> getBoardList(){
//		
////		List<Board> boardList = boardService.getBoardList();
////		model.addAttribute("boardList", boardList);
//
////		return "/getBoardList";
//		return boardService.getBoardList();
//	}
	
	@GetMapping("/getBoardList")
	public void getBoardList(Model model) {
//	Restcontroller(리턴 데이터) 안쓰고 controller(리턴 뷰) 어노테이션 쓸때
//	리턴 데이터를 json으로 넘기겠다
//	public @ResponseBody List<Board> getBoardList(){
		
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);

//		return "/getBoardList";
		
	}
	     
//	@GetMapping("/getBoard") 
//	public Board getBoard(Model model, Board board) {
//		
//		model.addAttribute("board", boardService.getBoard(board));
//		
//		return boardService.getBoard(board);
//	}
	
	@GetMapping("/getBoard")
//	브라우저 요청을 json형태로 데이터를 받을대
//	public String getBoard(@RequestBody Board board, Model model) {
	public void getBoard(Model model, Board board) {
		
		model.addAttribute("board", boardService.getBoard(board));
		
//		return "/getBoard";
	}
	
	@GetMapping("/insertBoard")
	public void addBoardView() {
		
	}
	
	@PostMapping("/insertBoard")
	public String addBoard(Board board) {
		
		System.out.println("진입여부 확인");
		boardService.addBoard(board); 
		
		return "redirect:getBoardList";
	}
	
//	@PostMapping("/insertBoard")
//	public void addBoard(Board board) {
//		
//		boardService.addBoard(board);
//	}
	
//	@PutMapping("/updateBoard")
//	public String updateBoard(Board board) {
//		
//		boardService.updateBoard(board);
//		
//		return "redirect:getBoardList";
//	}
	
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

