package edu.pnu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
class Chapter06ThfullApplicationTests {

	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	MemberRepository memberRepo;
	
	@Test
	void contextLoads() {
	}

//	@Test
	void insertBoard() {
		
		for(int i=1; i<=15; i++) {
			Board board = new Board();
			
			board.setTitle("boardTest"+i);
			board.setContent("boardTest"+i);
			board.setWriter("tester");
			
			boardRepo.save(board);
		}
		
	}
	
	@Test
	void insertMember() {
		
		Member member1 = new Member();
		member1.setId("dully");
		member1.setName("둘리");
		member1.setPassword("aa1234");
		member1.setRole("ROLE_USER");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("doner");
		member2.setName("도우너");
		member2.setPassword("abc1111");
		member2.setRole("ROLE_ADMIN");
		memberRepo.save(member2);
		
		for(int i=1; i<=5; i++) {
			
			Board board = new Board();
			
			board.setWriter("둘리");
			board.setTitle("둘리가 작성한 글"+i);
			board.setContent("둘리가 작성한 글입니다."+i);
			
			boardRepo.save(board);
		}
		
		for(int i=1; i<=5; i++) {
			
			Board board = new Board();
			
			board.setWriter("도우너");
			board.setTitle("도우너가 작성한 글"+i);
			board.setContent("도우너가 작성한 글입니다."+i);
			
			boardRepo.save(board);
		}
		
	}
	
}
