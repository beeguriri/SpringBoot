package edu.pnu.domain;

import java.util.Date;

public class MemberVO {

	private String id;
	private String pass;
	private String name;
	private Date regidate;	
	
	public MemberVO() {
	}
	
	public MemberVO(String id, String pass, String name, Date regidate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.regidate = regidate;
	}
	
	public MemberVO(String pass, String name) {
		super();
		this.pass = pass;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegidate() {
		return regidate;
	}

	public void setRegidate(Date regidate) {
		this.regidate = regidate;
	}


	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pass=" + pass + ", name=" + name + ", regidate=" + regidate + "]";
	}	
	
}
