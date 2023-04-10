package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.DBoard;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.service.BoardService;

@SpringBootTest
class Chapter061ApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	BoardService boardService;
	
//	@Test
	void contextLoads() {
	}
	
//	@Test
	void insertDataTest() {
		for(int i=1; i<=10; i++) {
			
			boardRepo.save(DBoard.builder()
					.title("title"+i)
					.content("content"+i)
					.createDate(new Date())
					.cnt(0L)
					.build()
			);
			
		}
	}
	
	@Test
	void getBoardListTest() {
		
		List<DBoard> list = boardService.getBoardList();
		
		for (DBoard db : list)
			System.out.println(db);
	}

}
