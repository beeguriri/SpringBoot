package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
	
	@Query(value="SELECT b FROM Board b, Member m") // Where m.member_id=b.member_id 
	List<Board> queryTest1();
	
	@Query("SELECT b FROM Board b, Member m Where b.seq=:seq") //and m.member_id=b.member_id
	Board queryTest2(@Param("seq") Long seq);

}
