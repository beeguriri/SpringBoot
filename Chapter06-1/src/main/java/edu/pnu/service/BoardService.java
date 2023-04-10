package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.DBoard;
import edu.pnu.persistence.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	BoardRepository boardRepo;

	public List<DBoard> getBoardList() {
		
		return (List<DBoard>) boardRepo.findAll();
	}

	public DBoard getBoard(Long seq) {
		
		return boardRepo.findById(seq).get();
	}
	
}
