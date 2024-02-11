package com.model;

public class FacultyReg {
	
	int Fid;
	String Fname;
	String Dept;
	String password;
	
	public FacultyReg(int fid, String fname, String dept, String password) {
		super();
		Fid = fid;
		Fname = fname;
		Dept = dept;
		this.password = password;
	}



	public int getFid() {
		return Fid;
	}

	public void setFid(int fid) {
		Fid = fid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getDept() {
		return Dept;
	}

	public void setDept(String dept) {
		Dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
