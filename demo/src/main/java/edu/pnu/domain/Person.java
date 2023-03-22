package edu.pnu.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//롬복 라이브러리 사용시 컴파일 과정에서 자동으로 삽입해줌
@Getter
@Setter
@ToString
@AllArgsConstructor	//모든필드가 들어있는 생성자 만들어줌
@NoArgsConstructor	//빈생성자 만들어줌
public class Person {

	private String name;
	private int year;
	private String job;
	private String hobby;
	
	public Person(String name, int year, String job, String hobby) {
		super();
		this.name = name;
		this.year = year;
		this.job = job;
		this.hobby = hobby;
	}
	
}
