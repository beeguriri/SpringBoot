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
	
	public List<Board> getBoardList() {
		
		List<Board> list = (List<Board>) boardRepo.findAll();
		
		return list;
		
	}
	
	public Board getBoard(Board board) {
		
		return boardRepo.findById(board.getSeq()).get();
		
	}
	
	public void addBoard(Board board) {
		
		boardRepo.save(board);

	}
	
	public void updateBoard(Board board) {
		
		Board upBoard = boardRepo.findById(board.getSeq()).get();
		
		upBoard.setTitle(board.getTitle());
		upBoard.setContent(board.getContent());
		
		boardRepo.save(upBoard);
		
	}

	public void deleteBoard(Board board) {

		boardRepo.deleteById(board.getSeq());
	}
	
	
	
}
