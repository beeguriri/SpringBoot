package edu.pnu;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class InsertTest {

	@Autowired
	BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
//	public void testInsertBoard() {
//		
//		for(int i=1; i<=30; i++) {
//			
//			Board b = new Board();
//
//			b.setTitle("title"+i);
//			b.setContent("content"+i);
//			b.setWriter("writer"+i);
//			b.setCreateDate(new Date());
//			b.setCnt((long)(Math.random()*100));
//			boardRepo.save(b);			
//			
//		}
//	}	
	
	
//	@Test
//	public void testInsertBoardMember() {
//		
//		Member member1 = new Member();
//		member1.setId("member1");
//		member1.setPassword("member111");
//		member1.setName("둘리");
//		member1.setRole("User");
//		memberRepo.save(member1);
//		
//		Member member2 = new Member();
//		member2.setId("member2");
//		member2.setPassword("member222");
//		member2.setName("도우너");
//		member2.setRole("Admin");
//		memberRepo.save(member2);
//		
//		Member member3 = new Member();
//		member3.setId("member3");
//		member3.setPassword("member333");
//		member3.setName("길동이");
//		member3.setRole("User");
//		memberRepo.save(member3);
//		
//		for(int i=1; i<=5; i++) {
//			
//			Board board = new Board();
//			board.setMember(member1);
//			board.setTitle("둘리가 등록한 게시글 " + i);
//			board.setContent("둘리가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);	
//		}
//		
//		for(int i=1; i<=5; i++) {
//			
//			Board board = new Board();
//			board.setMember(member2);
//			board.setTitle("도우너가 등록한 게시글 " + i);
//			board.setContent("도우너가 등록한 게시글 내용 " + i);
//			board.setCreateDate(new Date());
//			board.setCnt(0L);
//			boardRepo.save(board);	
//		}
//		
//	}
	
	
}
