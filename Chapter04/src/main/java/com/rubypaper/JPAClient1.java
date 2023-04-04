package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board;

public class JPAClient1 {
	
	//EntityManager 생성
	public static EntityManagerFactory emf;
	public static EntityManager em;
	
	//transaction 생성
	public static EntityTransaction tx;
		
 	public static void insertBoard(EntityManagerFactory emf) {
 		
		em = emf.createEntityManager();
 		tx = em.getTransaction();
 		
 		try {
 			
 			tx.begin();

			for(int i=1; i<=10; i++) {
				
				Board board = new Board();
	
				board.setTitle("JPA 제목" + i);
				board.setWriter("Test");
				board.setContent("JPA 글 등록 잘 되네요.");
				board.setCreateDate(new Date());
				board.setCnt(0L);
				
				//글 등록
				em.persist(board);
				
			}	
			
			tx.commit();

 		} catch(Exception e) {
 			e.printStackTrace();
 			tx.rollback();
 		} finally {
			em.close();
		}
	}
	
	public static void findBoardOne(EntityManagerFactory emf, Long seq) {
					
		em = emf.createEntityManager();

		Board searchBoard = em.find(Board.class, seq);
		System.out.println("---> " + searchBoard.toString());
		
		em.close();
	}
	
	public static void findBoardManyJPAQuery(EntityManagerFactory emf) {
		
		em = emf.createEntityManager();
		
		String sql = "select b from Board b order by b.seq desc";
		
//		List<Board> boardList = em.createQuery(sql, Board.class).getResultList();
		TypedQuery<Board> result = em.createQuery(sql, Board.class);
		List<Board> boardList = result.getResultList();
		
		for(Board brd : boardList)
			System.out.println("---> " + brd.toString());
				
		em.close();
	}
	
	public static void findBoardManyNativeQuery(EntityManagerFactory emf) {
		
		em = emf.createEntityManager();
		
		String sql = "select * from Board order by seq desc";
		List<?> boardList = em.createNativeQuery(sql, Board.class).getResultList();
		
		for(Object brd : boardList)
			System.out.println("---> " + brd.toString());

		em.close();
	}
	
	public static void updateBoard(EntityManagerFactory emf, Long seq) {
		
		em = emf.createEntityManager();
 		tx = em.getTransaction();

 		try {
 			
 			tx.begin();

			//수정 할 게시글 조회 => persistence context에 저장
			Board board = em.find(Board.class, seq);
			board.setTitle("수정테스트");
			
			tx.commit();
 		
 		} catch(Exception e) {
 			e.printStackTrace();
 			tx.rollback();
 		}  finally {
			em.close();
		}
	}
	
	public static void deleteBoard(EntityManagerFactory emf, Long seq) {
		
		em = emf.createEntityManager();
 		tx = em.getTransaction();

 		try {
 			
 			tx.begin();
 			
	 		//삭제 할 게시글 조회 => persistence context에 저장
			Board board = em.find(Board.class, seq);
			em.remove(board);
			
			tx.commit();
			
 		} catch (Exception e) {
 			e.printStackTrace();
 			tx.rollback();
 		}  finally {
			em.close();
		}
	}
	
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("Chapter04MySQL");
		
		try {
			
			//데이터를 입력
			insertBoard(emf);
			
			//id가 1인 데이터를 출력
//			findBoardOne(emf, 1L);
			
			//입력된 전체 데이터 출력 (JPA Query)
//			findBoardManyJPAQuery(emf);
			
			//입력된 전체 데이터 출력 (Native Query)
//			findBoardManyNativeQuery(emf);
			
			//id가 1인 데이터를 수정
//			updateBoard(emf, 1L);
			
			//수정된 정보 확인
//			findBoardOne(emf, 1L);
			
			//id가 2인 데이터를 삭제
//			deleteBoard(emf, 2L);
			
			//삭제 결과 확인
//			findBoardManyJPAQuery(emf);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} finally {
			emf.close();
		}
	}
}
