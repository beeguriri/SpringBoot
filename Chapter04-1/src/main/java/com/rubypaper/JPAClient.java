package com.rubypaper;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.rubypaper.domain.Board;

public class JPAClient {
	
	public static EntityManagerFactory emf;
	public static EntityManager em;
	public static EntityTransaction tx;
	
 	public static void insertBoard(EntityManagerFactory emf) {
 		
		em = emf.createEntityManager();
 		tx = em.getTransaction();
 		
 		try {
 			
 			tx.begin();

			for(int i=1; i<=10; i++) {
				
				Board board = Board.builder()
						.title("title"+i)
						.content("content-"+i)
						.writer("writer")
						.createDate(new Date())
						.build();
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

		emf = Persistence.createEntityManagerFactory("Chapter04-1H2");
//		emf = Persistence.createEntityManagerFactory("Chapter04-1MySQL");
		
		insertBoard(emf);
		
//		findBoardOne(emf, 1L);
//		
//		findBoardManyJPAQuery(emf);
//		
//		findBoardManyNativeQuery(emf);
//		
//		updateBoard(emf, 1L);
//		
//		deleteBoard(emf, 2L);
		
	}
}
