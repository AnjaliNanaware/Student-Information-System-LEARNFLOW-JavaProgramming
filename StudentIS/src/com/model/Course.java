package com.model;

public class Course {
	
	int studID;
	String dept;
	int sem;
	int courseID;
	String courseName;
	double Tmarks;
	double obtmarks;
	
	public Course(int studID, String dept, int sem, int courseID, String courseName) {
		super();
		this.studID = studID;
		this.dept = dept;
		this.sem = sem;
		this.courseID = courseID;
		this.courseName = courseName;
	}

	public int getStudID() {
		return studID;
	}

	public void setStudID(int studID) {
		this.studID = studID;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getSem() {
		return sem;
	}

	public void setSem(int sem) {
		this.sem = sem;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public double getTmarks() {
		return Tmarks;
	}

	public void setTmarks(double tmarks) {
		Tmarks = tmarks;
	}

	public double getObtmarks() {
		return obtmarks;
	}

	public void setObtmarks(double obtmarks) {
		this.obtmarks = obtmarks;
	}
	
	
	
}
