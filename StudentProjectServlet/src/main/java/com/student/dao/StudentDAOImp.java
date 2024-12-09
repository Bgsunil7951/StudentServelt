package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.student.connecter.ConnectionFactory;
import com.student.dto.Student;

public class StudentDAOImp implements StudentDAO{

	private Connection con;
	
	public StudentDAOImp() {
		this.con = ConnectionFactory.requestConnection();
	}

	
	@Override
	public boolean insertStudent(Student s) {
		String query="insert into student values(0,?,?,?,?,?,?,sysdate())";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhone());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			res=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateStudent(Student s) {
		
		String query="update student set name=?, phone=?, mailid=?, branch=?, location=?, password=? where id=?";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2,  s.getPhone());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			ps.setInt(7, s.getId());
			res=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean deleteStudent(Student s) {
		String query="delete from student where id=?";
		PreparedStatement ps=null;
		int res=0;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, s.getId());
			res=ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(res>0) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public Student getStudent(String mailid, String password) {
		
		String query="select * from student where mailid=? and password=?";
		PreparedStatement ps=null;
		Student s=null;
		ResultSet rs=null;
		
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mailid);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}

	@Override
	public List<Student> getStudent() {
		
		ArrayList<Student> al=new ArrayList<Student>();
		Student s=null;
		
		String query="select * from student";
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
				al.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return al;
	}


	@Override
	public Student getStudent(int id, String password) {
		
		String query="select * from student where id=? and password=?";
		PreparedStatement ps=null;
		Student s=null;
		ResultSet rs=null;
		
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.setString(2, password);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}


	@Override
	public Student getStudent(String mailid, long phone) {
		String query="select * from student where MAILID=? and PHONE=?";
		PreparedStatement ps=null;
		Student s=null;
		ResultSet rs=null;
		
		
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mailid);
			ps.setLong(2, phone);
			
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("phone"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return s;
	}

	
}
