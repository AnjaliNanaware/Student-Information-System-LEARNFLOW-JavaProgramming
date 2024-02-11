package com.main;

import java.util.ArrayList;
import java.sql.SQLException;
import java.util.*;

import com.controller.LoginUI;
import com.dao.RegistrationDAO;
import com.dao.StudentOpDAO;
import com.model.Course;
import com.model.FacultyReg;
import com.model.Login;
import com.model.StudentReg;

public class StudInfoSys {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		RegistrationDAO rd=new RegistrationDAO();
		int ch;
		do {
			System.out.println("\n1.Student Registration  \n2.Student Login \n3.Faculty Registration \n4. Faculty Login ");
			System.out.println("Enter choice: ");
			ch=sc.nextInt();
			
			switch(ch) {
				
			case 1: System.out.println("Enter student ID: ");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter student name : ");
					String name=sc.nextLine();
					System.out.println("Enter email : ");
					String email=sc.next();
					System.out.println("Enter contact no. : ");
					String contact=sc.next();
					System.out.println("Enter department : ");
					String dept=sc.next();
					System.out.println("Enter year(e.g. 1st,2nd ,3rd,4th)  : ");
					String year=sc.next();
					System.out.println("Enter password : ");
					String password=sc.next();
					
					
					StudentReg sr=new StudentReg(id,name,email,contact,dept,year,password);
					List<StudentReg> ls=new ArrayList<StudentReg>();
					ls.add(sr);
					int i=rd.save(ls);
					if(i>0)
					{
						System.out.println("You have registered successfully ");
					}
					else 
						System.out.println("Failed to register");
					
					break;
					
			case 2: System.out.println("Enter User ID: ");
					int userID=sc.nextInt();
					System.out.println("enter password");
					String pass=sc.next();
					
					Login lg=new Login(userID,pass);
					List<Login> l=new ArrayList<Login>();
					l.add(lg);
					RegistrationDAO r=new RegistrationDAO();
					boolean result=r.validate(l);
					if(result) {
						System.out.println("You have login Successfully !!!!");
						LoginUI loginObj=new LoginUI();
						loginObj.StudLoginUI(l);
						
					}
					else
					{
						System.out.println("Failed to login");
					}
						
					break;
					
			case 3: System.out.println("Enter Faculty ID: ");
					int fid=sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Name : ");
					String fname=sc.nextLine();
					System.out.println("Enter Department: ");
					String fdept=sc.next();
					System.out.println("Enter password: ");
					String fpassword=sc.next();
					
					FacultyReg fr=new FacultyReg(fid,fname,fdept,fpassword);
					List<FacultyReg> lf=new ArrayList<FacultyReg>();
					lf.add(fr);
					RegistrationDAO rf=new RegistrationDAO();
					rf.Fsave(lf);
					break;
					
			case 4: System.out.println("Enter User ID: ");
					int uID=sc.nextInt();
					System.out.println("enter password");
					String fpass=sc.next();
					
					Login flogin=new Login(uID,fpass);
					List<Login> lfa=new ArrayList<Login>();
					lfa.add(flogin);
					RegistrationDAO rf1=new RegistrationDAO();
					boolean resultf=rf1.Fvalidate(lfa);
					if(resultf) {
						LoginUI loginObj=new LoginUI();
						loginObj.FacultyLoginUI(lfa);
					}
					else
					{
						System.out.println("Failed to login");
					}
						
					break;
					
		
			}
		}while(ch!=5);
	}


}
