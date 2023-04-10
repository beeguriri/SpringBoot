package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepo;
	
	public List<Board> getBoards() {
		
//		List<Board> bList = (List<Board>) boardRepo.findAll();
		List<Board> bList = boardRepo.queryTest1();
		
		return bList;
	}
	
	public Board getBoard(Long seq) {
		
//		Board board = boardRepo.findById(seq).get();
		Board board = boardRepo.queryTest2(seq);
		System.out.println("====>" + board.toString());
		
		return board;
	}

}
