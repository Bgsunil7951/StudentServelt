package com.student.dao;

import java.util.List;
import com.student.dto.Student;


public interface StudentDAO {

	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mailid,String password);
	public Student getStudent(String mailid,long phone);
	public List<Student> getStudent();
	public Student getStudent(int id, String password);
}
