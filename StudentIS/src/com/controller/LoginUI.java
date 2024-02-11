package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dao.AdminOpDAO;
import com.dao.StudentOpDAO;
import com.model.Course;
import com.model.Login;

public class LoginUI {
		Scanner sc=new Scanner(System.in);
		int[] csid=new int[7];
		String[] csname=new String[7];
		public void StudLoginUI(List<Login> ls) throws SQLException
		{
			
			Login lg=ls.get(0);
			int ch;
			
			do {
				System.out.println("--------------------------------------------------------");
				System.out.println("\t\tWelcome Student ");
				System.out.println("--------------------------------------------------------");
				System.out.println("\n1.Course Registration \n2.Profile Updation \n3.See Result \n4 Log out");
				System.out.println("Enter your choice: ");
				ch=sc.nextInt();
				
				switch(ch)
				{
					case 1: System.out.println("Enter department :" );
							String dep=sc.next();
							System.out.println("Enter semester: ");
							int sem=sc.nextInt();
							
							System.out.println("Enter total no. of courses (max=6): ");
							int n=sc.nextInt();
							for(int i=0;i<n;i++) {
								System.out.println("Enter course code: ");
								csid[i]=sc.nextInt();
					
								System.out.println("Enter course name: ");
								csname[i]=sc.next();
							}
							
							
//							Course c=new Course(lg.getuserID(), dep,sem,csid,csname);
							
//							List<Course> lc=new ArrayList<Course>();
//							lc.add(c);
							 
							StudentOpDAO sd=new  StudentOpDAO();
							sd.CourseReg(lg.getuserID(), dep,sem,csid,csname,n);
							break;
							 
					case 2: 
							StudentOpDAO s=new StudentOpDAO();
							s.updatePro(ls);
							break;
							
					case 3: StudentOpDAO s1=new StudentOpDAO();
							System.out.println("Enter semester: ");
							int rsem=sc.nextInt();
							s1.showResult(ls,rsem);
							break;
						 
					case 4:System.out.println("Log out successfully");
				}
			}while(ch!=4);
		}
		
		public void FacultyLoginUI(List<Login> ls)
		{
			int ch=0;
			
			do {
				System.out.println("\n1. Enter result \n2.See students data \n3. Log out ");
				System.out.println("Enter your choice: ");
				ch=sc.nextInt();
				
				switch(ch) {
				case 1: 
						System.out.println("Enter course code: ");
						int cscode=sc.nextInt();
						System.out.println("Enter total marks of course: ");
						double tmarks=sc.nextDouble();
						
						AdminOpDAO ad=new AdminOpDAO();
						ad.addResult(cscode,tmarks);
						break;
						
				case 2: System.out.println("Enter department: ");
						String dept=sc.next();
						System.out.println("Enter year(eg 2nd , 3rd) :");
						String year=sc.next();
						
						AdminOpDAO ad1=new AdminOpDAO();
						ad1.displayStud(dept,year);
						break;
						
				case 3: System.out.println("Logout successfully");
				}
			}while(ch!=3);
		}
}
