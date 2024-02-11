package com.dao;

import java.sql.*;
import java.util.*;

import com.model.Course;
import com.model.Login;

public class StudentOpDAO {
	
	Scanner sc=new Scanner(System.in);
	MyConnection m=new MyConnection();
	PreparedStatement pstate=null;
	
	
	public void  CourseReg(int studId,String dept,int sem,int[] csid,String[] coursename,int tnos)
	{
		Connection con=m.getConnection();
		int i=0;
		try {
			
			for(int j=0;j<tnos;j++)
			{
				pstate=con.prepareStatement("insert into course values(?,?,?,?,?,0,0)");
				pstate.setInt(1,studId);
				pstate.setString(2,dept);
				pstate.setInt(3,sem);
				pstate.setInt(4,csid[j]);
				pstate.setString(5,coursename[j]);
				
				i=pstate.executeUpdate();
			}
			
			if(i>0) {
				System.out.println("Course registered successfully");
			}
			else {
				System.out.println("Failed to registered course");
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
	
	public void updatePro(List<Login> ls) throws SQLException
	{
		Connection con=m.getConnection();
		Login l=ls.get(0);
		int i;
		System.out.println("What you want to update 1.Password 2.Personal Info 3. Academic Info");
		System.out.println("Enter your choice: ");
		int ch=sc.nextInt();
		if(ch==1)
		{
			System.out.println("Enter New Password: ");
			String pass=sc.next();
				pstate=con.prepareStatement("Update student set password=? where studID=?");
				pstate.setString(1, pass);
				pstate.setInt(2, l.getuserID());
				
				i=pstate.executeUpdate();
				if(i>0) {
					System.out.println("Password updated successfully!!!!");
				}
				else
				{
					System.out.println("Failed to change password");
				}			
		}
		else if(ch==2)
		{
			
			System.out.println("Enter new email : ");
			String email=sc.next();
			System.out.println("Enter new Contact no.: ");
			String contact=sc.next();
			pstate=con.prepareStatement("Update student set email=? ,contact=? where studID=?");
			pstate.setString(1,email);
			pstate.setString(2,contact);
			pstate.setInt(3, l.getuserID());
			
			i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("Profile updated successfully!!!!");
			}
			else
			{
				System.out.println("Failed to update");
			}	
			
		}
		else if(ch==3)
		{
			System.out.println("Enter year : ");
			String year=sc.next();
			pstate=con.prepareStatement("Update student set password=? where studID=?");
			pstate.setString(1, year);
			pstate.setInt(2, l.getuserID());
			
			i=pstate.executeUpdate();
			if(i>0) {
				System.out.println("Profile updated successfully!!!!");
			}
			else
			{
				System.out.println("Failed to Profile");
			}	
			
		}
		else {
			System.out.println("Invalid Choice");
		}
		con.close();
		
	}
	
	public void showResult(List<Login> ls,int sem)
	{
			Connection con=m.getConnection();
			Login lg=ls.get(0);
			double total=0;
			double tobt=0;
			double per=0;
			try {
				pstate=con.prepareStatement("Select dept,sem,courseID,courseName,Tmarks,obtMarks from course where studID=? and sem=?");
				pstate.setInt(1, lg.getuserID());
				pstate.setInt(2,sem);
				ResultSet rs=pstate.executeQuery();
				System.out.println("Department \t Semester \t Course Code \t Course Name \tTotal Marks \t Obtained Marks");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getInt(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getDouble(5)+"\t\t"+rs.getDouble(6));
					total=total+rs.getDouble(5);
					tobt=tobt+rs.getDouble(6);
				}
				System.out.println("-----------------------------------------------------------------------------------------");
				System.out.println("\tTotal Percentage: "+ tobt/total*100);
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
	
}
