package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
class Chapter06JspApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
//	@Test
//	void contextLoads() {
//	}

	@Test
	void insertDataTest() {
		for(int i=1; i<=10; i++) {
			
			boardRepo.save(Board.builder()
					.title("입력테스트2-"+i)
					.writer("관리자")
					.content("입력테스트중"+i)
					.build()
			);
			
		}
	}
		
}
