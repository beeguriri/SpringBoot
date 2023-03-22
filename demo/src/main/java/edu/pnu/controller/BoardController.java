package edu.pnu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Person;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

//DemoApplication 파일이 있는 하부 패키지의 클래스를 인스턴스로 생성 (자동)
@RestController
@Service
@Slf4j
public class BoardController {	 
	
	public BoardController() {
		System.out.println("===> BoardController 생성");
	}
	
	//get 방식 호출
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
	//post 방식 호출 -> HTML로 form 만들어서 값을 받아와야함
	@PostMapping("/hello")
	public String hello1(String name) {
		return "Hello Post : " + name;
	}
	
	//클래스를 리턴할수 있음
	//객체를 자동으로 json object로 변경해서 클라이언트로 보내줌
	//기본적으로 부트에서는 Json사용
	@GetMapping("/getPerson")
	public Person getPerson() {
		return new Person("홍길동", 2000, "백수", "선플");
	}
	
	//리스트 리턴
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("홍길동", 2000, "백수", "선플"));
		list.add(new Person("홍이동", 1995, "백수", "악플"));
		list.add(new Person("홍삼동", 2005, "백수", "없음"));
		
		return list;
	}

}
