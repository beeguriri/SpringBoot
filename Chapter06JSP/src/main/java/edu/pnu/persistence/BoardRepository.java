package edu.pnu.persistence;

import org.springframework.data.repository.CrudRepository;

import edu.pnu.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}
