package edu.pnu;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
public class BoardRepositoryTest {

	@Autowired
	BoardRepository boardRepo;
	
//	@Test
	public void testInsertBoard() {
		
		for(int i=1; i<=100; i++) {
			
			Board b = new Board();

			b.setTitle("title"+i);
			b.setContent("content"+i);
			b.setWriter("writer"+i);
			b.setCreateDate(new Date());
			b.setCnt((long)(Math.random()*100));
			boardRepo.save(b);			
		}
	}
	
//	@Test
	public void testGetBoard() {
		
		Board b = boardRepo.findById(1L).get();
		System.out.println(b.toString());
	}
	
//	@Test
	public void testGetBoardList() {
		
		Iterable<Board> bList = boardRepo.findAll();
		for(Board b : bList) 
			System.out.println("===> "+ b.toString());
	}
	
	//title에 1이 포함되는 데이터 출력
//	@Test
	public void testFindByContent() {
		
		List<Board> boardList = boardRepo.findByContentContaining("1");
		
		System.out.println("==== 검색결과");
		for(Board b : boardList) 
			System.out.println("===> "+ b.toString());
	}
	
	//cnt가 50보다 큰 데이터 출력
//	@Test
	public void testFindByCnt() {
		
		List<Board> boardList = boardRepo.findByCntGreaterThan(50L);
		
		System.out.println("==== 검색결과");
		for(Board b : boardList) 
			System.out.println("===> "+ b.toString());
	}
	
	//title에 1이 포함되면서 cnt가 50보다 큰 데이터 출력
//	@Test
	public void testFindByContentContainingAndCntGreaterThan() {
		
		List<Board> boardList = boardRepo.findByContentContainingAndCntGreaterThan("1", 50L);
		
		System.out.println("==== 검색결과");
		for(Board b : boardList) 
			System.out.println("===> "+ b.toString());
	}
	
	//cnt가 10~50사이인 데이터를 seq 오름차순으로 출력
//	@Test
	public void testFindByCntLessThanAndCntGreaterThan() {
		
		List<Board> boardList = boardRepo.findByCntLessThanAndCntGreaterThanOrderBySeqAsc(50L, 10L);
		
		System.out.println("==== 검색결과");
		for(Board b : boardList) 
			System.out.println("===> "+ b.toString());
	}
	
	//title에 10이 포함되거나 content에 2가 포함되는 데이터를 seq 내림차순으로 출력
//	@Test
	public void testFindByTitleContainingOrContentContaing() {
		
		List<Board> boardList = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
		
		System.out.println("==== 검색결과");
		for(Board b : boardList) 
			System.out.println("===> "+ b.toString());
	}
	
//	@Test
	public void testUpdateBoard() {
		
		System.out.println("=== 1번 게시글 조회 ===");
		Board b = boardRepo.findById(1L).get();
		
		System.out.println("=== 1번 게시글 수정 ===");
		b.setTitle("title 수정");
		boardRepo.save(b);
	}
	
//	@Test
	public void testDeleteBoard() {
		
		boardRepo.deleteById(2L);
	}
	
	//query annotation test
	@Test
	public void testQueryTest() {
		
		Pageable paging = PageRequest.of(0, 10); 
		List<Board> bList = boardRepo.queryTest(paging);
		
		for(Board b : bList)
			System.out.println("===> "+ b.toString());
		
	}
	
}
