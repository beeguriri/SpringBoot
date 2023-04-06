package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

//table로 사용할 클래스와, 그 태이블의 키를 지정
public interface BoardRepository extends CrudRepository<Board, Long> {
	
	//title에 1이 포함되는 데이터 출력
	List<Board> findByContentContaining(String searchKeyword);

	//cnt가 50보다 큰 데이터 출력
	List<Board> findByCntGreaterThan(Long cnt);
	
	//title에 1이 포함되면서 cnt가 50보다 큰 데이터 출력
	List<Board> findByContentContainingAndCntGreaterThan(String searchKeyword, Long cnt);

	//cnt가 10~50사이인 데이터를 seq 오름차순으로 출력
	List<Board> findByCntLessThanAndCntGreaterThanOrderBySeqAsc(Long lcnt, Long gcnt);
	
	//title에 10이 포함되거나 content에 2가 포함되는 데이터를 seq 내림차순으로 출력
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	//query annotation, page 테스트
	@Query("Select b From Board b Order by b.cnt DESC, seq ASC")
	List<Board> queryTest(Pageable paging);
	
}
