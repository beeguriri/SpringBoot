package com.rubypaper;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.rubypaper.domain.Board;

public class JPAClient1 {
	
	//EntityManager 생성
	public static EntityManagerFactory emf;
	public static EntityManager em;
	
	public static void insertBoard(EntityManagerFactory emf) throws Exception {
		
		for(int i=1; i<=10; i++) {
			
			Board board = new Board();

			if(i<=9) {
				board.setTitle("JPA 제목" + i);
				board.setWriter("Test");
				board.setContent("JPA 글 등록 잘 되네요.");
				board.setCreateDate(new Date());
				board.setCnt(0L);
			
				//글 등록
				em.persist(board);
			}

//			롤백 테스트 (에러 강제 발생)
//			else {
//				throw new Exception("에러");
//			}
		}
	}
	
	public static void main(String[] args) {
		
		emf = Persistence.createEntityManagerFactory("Chapter04");
		em = emf.createEntityManager();
		
		//Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		try {
			//Transaction 시작
			tx.begin();
			
			insertBoard(emf);
			
			//Transaction 커밋 => 데이터베이스에 반영
			tx.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
			//에러 발생 시 Transaction 롤백
			tx.rollback();
			
		} finally {
			em.close();
			emf.close();
		}
	}
}
