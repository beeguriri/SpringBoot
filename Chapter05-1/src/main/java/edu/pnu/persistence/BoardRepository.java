package edu.pnu.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {
		
}
