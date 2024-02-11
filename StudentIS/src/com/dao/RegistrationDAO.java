package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.FacultyReg;
import com.model.Login;
import com.model.StudentReg;

public class RegistrationDAO {
	
	MyConnection m=new MyConnection();

	
	public int  save(List<StudentReg> lst)
	{
		int i = 0;
		
		Connection con=m.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			StudentReg sr=lst.get(0);
			pstate.setInt(1, sr.getStudID());
			pstate.setString(2,sr.getName());
			pstate.setString(3, sr.getEmail());
			pstate.setString(4, sr.getContactno());
			pstate.setString(5,sr.getDept());
			pstate.setString(6,sr.getYear());
			pstate.setString(7,sr.getPassword());
			
			i=pstate.executeUpdate();
			
			
			
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
		return i;
		
	}
	
	public void Fsave(List<FacultyReg> lst)
	{
		int i = 0;
		
		Connection con=m.getConnection();
		
		try {
			PreparedStatement pstate=con.prepareStatement("insert into faculty values(?,?,?,?)");
			FacultyReg fr=lst.get(0);
			pstate.setInt(1, fr.getFid());
			pstate.setString(2,fr.getFname());
			pstate.setString(3,fr.getDept());
			pstate.setString(4, fr.getPassword());
			
			i=pstate.executeUpdate();
			
			if(i>0) {
				System.out.println("You have registered successfully");
			}
			else {
				System.out.println("Failed to registered");
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
	
	
	public boolean validate(List<Login> lst) {
		Connection con=m.getConnection();
		Login lobj=lst.get(0);
		boolean b=true;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from student where studID=? and password=?");
			pstate.setInt(1,lobj.getuserID());
			pstate.setString(2,lobj.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				b=true;
			}
			else {
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return b;
	}


	public boolean Fvalidate(List<Login> lst) {
		Connection con=m.getConnection();
		Login lobj=lst.get(0);
		boolean b=true;
		try {
			PreparedStatement pstate=con.prepareStatement("select * from faculty where fID=? and password=?");
			pstate.setInt(1,lobj.getuserID());
			pstate.setString(2,lobj.getPassword());
			ResultSet rs=pstate.executeQuery();
			if(rs.next()) {
				b=true;
			}
			else {
				b=false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return b;
	}

}
