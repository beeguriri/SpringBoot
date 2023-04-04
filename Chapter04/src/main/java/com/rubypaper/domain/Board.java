package com.rubypaper.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity //데이터베이스의 테이블과 매핑되는 클래스
@Table(name="boardTest")
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	//키를 자동으로 생성(AutoIncrement), Auto로 설정하면 H2 내부 sequence로 테이블 만들어서 설정함(??)
	private Long seq;	//key(id)
	
	private String title;
	private String writer;
	private String content;
	
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(length = 50)  //해당 필드에 속성을 줄 수 있음(기본값이 nullable : false, unique,...)
	private Long cnt;
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + "]";
	}

}
