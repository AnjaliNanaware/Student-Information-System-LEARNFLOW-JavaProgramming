package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminOpDAO {
	Scanner sc=new Scanner(System.in);
	MyConnection m=new MyConnection();
	PreparedStatement pstate=null;
	public void addResult(int coursecode,double tmarks)
	{
		Connection con=m.getConnection();
		int count=0;
		int i=0;
		double obtmarks;
		try {
			
			pstate=con.prepareStatement("select studid from course where courseid=?");
			pstate.setInt(1, coursecode);
			
			ResultSet rs=pstate.executeQuery();
			System.out.println("Following are the students that are enrolled for course code: "+coursecode);
			System.out.println("Enter their marks:");
	
			while(rs.next())
			{
				System.out.println("Enter marks of student id: "+rs.getInt(1)+": ");
				obtmarks=sc.nextDouble();
				pstate=con.prepareStatement("Update course set Tmarks=? , obtMarks=? where studID=? and courseid=?");
				pstate.setDouble(1, tmarks);
				pstate.setDouble(2, obtmarks);
				pstate.setInt(3,rs.getInt(1));
				pstate.setInt(4, coursecode);
				i=pstate.executeUpdate();
			}
			if(i >0)
			{
				System.out.println("Marks entered successfully");
			}
			else {
				System.out.println("Failed to entered marks");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void displayStud(String dept,String year)
	{
		Connection con=m.getConnection();
		try {
			pstate=con.prepareStatement("Select studid,studname,email,contact from student where dept=? and year=? ");
			pstate.setString(1, dept);
			pstate.setString(2,year);
			
			ResultSet rs=pstate.executeQuery();
			System.out.println("-----------------------------------------------------------------------------------");
			System.out.println("Stud ID\tStudent Name\t\tEmail\t\t\t\tContact");
			System.out.println("-----------------------------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t\t"+rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
