package com.student.main;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

public class Test {
	
	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp();
		
		
		System.out.println("=====Student Application=====");
		
		while(true) {
			
		System.out.println("\nPress 1: For insert the Student data ");
		System.out.println("Press 2: For Delete Student data");
		System.out.println("Press 3: For Update Student data");
		System.out.println("Press 4: To get Student  data");
		System.out.println("Press 5: To get all Student data");
		System.out.println("Press 6: To exit \n");
		System.out.println("Enter the number:");
		int key=sc.nextInt();
		
		switch (key) {
		case 1: {
//			collecting the data from the user.
			System.out.println("Enter the Student name: ");
			//to set the value collected from the user to the pojo class object using setters.
			s.setName(sc.next());
			
			
			
			System.out.println("Enter the Student Phone number: ");
			s.setPhone(sc.nextLong());
			
			System.out.println("Enter the mail Id: ");
			s.setMailid(sc.next());
			
			System.out.println("Enter the Branch: ");
			s.setBranch(sc.next());
			
			System.out.println("Enter the Location: ");
			s.setLocation(sc.next());
			
			System.out.println("Enter the password: ");
			String pass=sc.next();
			
			System.out.println("Confirm the password: ");
			String confirmPass=sc.next();
			
			if(pass.equals(confirmPass)) {
				s.setPassword(pass);
				boolean result=sdao.insertStudent(s);
				if(result) {
					System.out.println("Data added successfully");
				}
				else {
					System.out.println("Failed to add data");
				}
			}
			else {
				System.out.println("Password missmatch");
				
			}
			break;
			
		}
		case 2:{
			System.out.println("Enter Student id");
			s.setId(sc.nextInt());
			
			boolean result=sdao.deleteStudent(s);
			if(result) {
				System.out.println("data deleted succssfully");
			}
			else {
				System.out.println("Failed to delete OR Id does not exit");
			}
			break;
		}
		
		case 3:{
			System.out.println("===Updated student Data===");
			
			System.out.println("Enter Student id");
			s.setId(sc.nextInt());
			
			System.out.println("Enter phone number");
			s.setPhone(sc.nextLong());
			
			boolean result=sdao.updateStudent(s);
			if(result) {
				System.out.println("data updated succssfully");
			}
			else {
				System.out.println("Id does not exit");
			}
			break;
		}
		
		
		case 4:{
			System.out.println("Enter mail id");
			String mail=sc.next();
			
			System.out.println("Enter password");
			String pass=sc.next();
			
		    s=sdao.getStudent(mail,pass);
		    
		    if(s!=null) {
		    	System.out.println(s);
		    }
		    else {
		    	System.out.println("Invalid password or invalid mailid");
		    }
		    break;
		}
		case 5:{
			
			
			List<Student> students=sdao.getStudent();
			Iterator<Student> it=students.iterator();
			while(it.hasNext()) {
				 s=it.next();
				System.out.println(s);
			}
			break;
		}
		case 6:{
			System.out.println("Thank you visit again");
			System.exit(0);
		}
		default:
			System.err.println("Invalid choice");
			break;
		}
			

	}
	}
}
