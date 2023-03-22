package edu.pnu.service;

import java.util.ArrayList;
import java.util.List;

import edu.pnu.domain.Person;

public class BoardService {
	
	private List<Person> list = new ArrayList<>();
	
	public BoardService() {
		System.out.println("===> BoardService 생성");
		
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍이동", 1995, "백수", "악플"));
		list.add(new Person("홍삼동", 2005, "백수", "없음"));
		
	}
	
	public List<Person> getPerson() {
		return list;
	}

}
