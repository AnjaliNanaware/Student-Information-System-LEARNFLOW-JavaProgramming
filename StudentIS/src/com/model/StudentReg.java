package com.model;

public class StudentReg {
	int studID;
	String name;
	String email;
	String contactno;
	String dept;
	String year;
	String password;
	public StudentReg(int studID, String name, String email, String contactno, String dept, String year,String password) {
		super();
		this.studID = studID;
		this.name = name;
		this.email = email;
		this.contactno = contactno;
		this.dept = dept;
		this.year = year;
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStudID() {
		return studID;
	}
	public void setStudID(int studID) {
		this.studID = studID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	
}
