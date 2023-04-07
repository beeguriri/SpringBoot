package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.domain.Board;
import edu.pnu.domain.Member;
import edu.pnu.persistence.BoardRepository;
import edu.pnu.persistence.MemberRepository;

@SpringBootTest
public class RelationMappingTest {

	@Autowired
	private BoardRepository boardRepo;
	
	@Autowired
	private MemberRepository memberRepo;
	
//	@Test
	public void testManyToOneInsert() {
		
		Member member1 = new Member();
		member1.setId("member1");
		member1.setPassword("member111");
		member1.setName("둘리");
		member1.setRole("User");
		memberRepo.save(member1);
		
		Member member2 = new Member();
		member2.setId("member2");
		member2.setPassword("member222");
		member2.setName("도우너");
		member2.setRole("Admin");
		memberRepo.save(member2);
		
		Member member3 = new Member();
		member3.setId("member3");
		member3.setPassword("member333");
		member3.setName("길동이");
		member3.setRole("User");
		memberRepo.save(member3);
		
		for(int i=1; i<=3; i++) {
			
			Board board = new Board();
			board.setMember(member1);
			board.setTitle("둘리가 등록한 게시글 " + i);
			board.setContent("둘리가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);	
		}
		
		for(int i=1; i<=3; i++) {
			
			Board board = new Board();
			board.setMember(member2);
			board.setTitle("도우너가 등록한 게시글 " + i);
			board.setContent("도우너가 등록한 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);	
		}
		
		for(int i=1; i<=3; i++) {
			
			Board board = new Board();
			board.setTitle("조인테스트 " + i);
			board.setContent("조인테스트 게시글 내용 " + i);
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardRepo.save(board);	
		}
		
	}
	
//	@Test
	public void testFindbyID() {
		Board board = boardRepo.findById(5L).get();
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ " + board.getSeq() + "번 게시글 정보 ]\n");
		sb.append("제목 ").append(board.getTitle()).append("\n");
		sb.append("내용 : ").append(board.getContent()).append("\n");
		if(board.getMember()!=null) {
			sb.append("작성자: ").append(board.getMember().getName()).append("\n");
			sb.append("작성자 권한: ").append(board.getMember().getRole());
		} else {
			sb.append("작성자: ").append("null").append("\n");
			sb.append("작성자 권한: ").append("null");
		}
		
		System.out.println(sb);
	}
	
//	@Test
	public void testJoin() {
		
		Iterable<Board> bList = boardRepo.findAll();
		for(Board board : bList) {
			StringBuilder sb = new StringBuilder();
			
			sb.append("[ " + board.getSeq() + "번 게시글 정보 ]\n");
			sb.append("제목 ").append(board.getTitle()).append("\n");
			sb.append("내용 : ").append(board.getContent()).append("\n");
			if(board.getMember()!=null) {
				sb.append("작성자: ").append(board.getMember().getName()).append("\n");
				sb.append("작성자 권한: ").append(board.getMember().getRole());
			} else {
				sb.append("작성자: ").append("null").append("\n");
				sb.append("작성자 권한: ").append("null");
			}
			
			System.out.println(sb);
			
		}
	}
	
	@Test
	public void testTwoWayMapping() {
		
		Member member = memberRepo.findById("member1").get();
		//Member.java:	@OneToMany(mappedBy="member", fetch=FetchType.EAGER) 
		//member객체에 boardList 저장되어있는 상태로 반환
		
		System.out.println("=".repeat(30));
		System.out.println(member.getName() + "가 저장한 게시글 목록");
		System.out.println("=".repeat(30));
		
		List<Board> list = member.getBoardList();
		
		for(Board board : list) 
			System.out.println(board.toString());
		
		System.out.println("=".repeat(30));

	}
	
}
