package edu.pnu.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = "boardList")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

	@Id
	@Column(name="MEMBER_ID")
	private String id;
	
	private String password;
	private String name;
	private String role;
	
	@OneToMany(mappedBy="member", fetch=FetchType.EAGER) 
	//lazy: 필요할때만 데이터 가져옴(default)
	//eager : 연관관계에 있는 데이터 무조건 가져옴 
	private List<Board> boardList = new ArrayList<Board>(); 
	
}
