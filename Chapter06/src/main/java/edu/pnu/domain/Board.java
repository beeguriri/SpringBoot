package edu.pnu.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//(exclude = "member")
@ToString(exclude = "member")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
	private String title;
//	private String writer;
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	private Long cnt;
	private String member_id;
	
//	@ManyToOne
//	@JoinColumn(name="MEMBER_ID", nullable=true)
//	private Member member;
//
//	public void setMember(Member member) {
//		this.member = member;
//		member.getBoardList().add(this);
//	}
	
}
