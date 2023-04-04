//package com.rubypaper.domain;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import org.hibernate.annotations.ColumnDefault;
//import org.hibernate.annotations.CreationTimestamp;
//
//public class Board1 {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)	
//	private Long seq;	//key(id)
//	
//	@Column(nullable = false)
//	private String title;
//	
//	@Column(nullable = false)
//	private String writer;
//	
//	@Column(nullable = false)
//	private String content;
//	
//	@Temporal(TemporalType.DATE)
//	@Column(nullable = false, updatable = false)
//	@CreationTimestamp
//	private Date createDate;
//	
//	@ColumnDefault("0")
//	private Long cnt;
//
//	private Board1(Builder builder) {
//		this.seq = builder.seq;
//		this.title = builder.title;
//		this.writer = builder.writer;
//		this.content = builder.content;
//		this.createDate = builder.createDate;
//		this.cnt = builder.cnt;
//	}
//	
//}
//
//public static class Builder {
//	
//	public Long cnt;
//	public Date createDate;
//	public String writer;
//	public String content;
//	public String title;
//	public Long seq;
//
//	public Builder() {
//		this.seq = builder.seq;
//		this.title = builder.title;
//		this.writer = builder.writer;
//		this.content = builder.content;
//		this.createDate = builder.createDate;
//		this.cnt = builder.cnt;
//	}
//
//	public Board1 build() {
//		return new Board1();
//	}
//}
