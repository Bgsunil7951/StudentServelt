package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/singup")
public class Signup extends HttpServlet {

	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phonenum=req.getParameter("phone");
		String mail=req.getParameter("mail");
		String branch=req.getParameter("branch");
		String loc=req.getParameter("loc");
		String password=req.getParameter("password");
		String confirm=req.getParameter("confirm");
		
		long phone=Long.parseLong(phonenum);
		
		PrintWriter out=resp.getWriter();
		
		Student s=new Student();
		StudentDAO sdeo=new StudentDAOImp();
		
		if(password.equals(confirm)) {
			s.setName(name);
			s.setPhone(phone);
			s.setMailid(mail);
			s.setBranch(branch);
			s.setLocation(loc);
			s.setPassword(password);
			
			boolean result=sdeo.insertStudent(s);
			if(result) {
				Student s1=sdeo.getStudent(mail, password);
				
				req.setAttribute("success", "Singup successful");
				RequestDispatcher rd=req.getRequestDispatcher("Singup.jsp");
				rd.forward(req, resp); 
//				  out.println("<h1>Added data</h1>"); 
//				  resp.sendRedirect("index.html");
				 }
			else {
				req.setAttribute("failure", "Singup failed");
				RequestDispatcher rd=req.getRequestDispatcher("Singup.jsp");
				rd.forward(req, resp); 
				
//				out.println("<h1>Failed</h1>");
			}
		}
	}
}
