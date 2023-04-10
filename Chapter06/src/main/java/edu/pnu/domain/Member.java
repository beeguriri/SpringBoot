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
//	@Column(name="MEMBER_ID")
//	private String id;
	private String member_id;

	private String password;
	private String name;
	private String role;
	
//	@OneToMany(mappedBy="member", fetch=FetchType.EAGER) 
//	private List<Board> boardList = new ArrayList<Board>(); 
}
