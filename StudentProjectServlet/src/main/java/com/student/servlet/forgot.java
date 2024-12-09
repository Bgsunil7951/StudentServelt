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
import jakarta.servlet.http.HttpSession;

@WebServlet("/forgot")
public class forgot  extends HttpServlet{

@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	String mail=req.getParameter("mail");
	String phonenum=req.getParameter("phone");
	
	String password=req.getParameter("password");
	String confirm=req.getParameter("confirm");
	
	
	
	
	long phone=Long.parseLong(phonenum);
	
//	PrintWriter out=resp.getWriter();
	StudentDAO sdeo=new StudentDAOImp();
	HttpSession session=req.getSession(false);
	Student s=(Student)session.getAttribute("student");
	
	
	
	if(s!=null && phone==s.getPhone() && mail.equals(s.getMailid()) ) {
		if(password.equals(confirm)) {
		s.setPassword(confirm);
		boolean	result=sdeo.updateStudent(s);
		
		if(result) {
			
			
			req.setAttribute("success", "Password changed successfully");
			RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
			rd.forward(req, resp);
//			out.println("<h1>Password changed successfully, New password : "+s.getPassword()+"</h1>"
//					+ "<br>"
//					+ "<a href=\"index.html\">Back</a>");
//			resp.sendRedirect("index.jsp");
		}
		else {
			req.setAttribute("fail", "Failed to change password");
			RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
			rd.forward(req, resp);
			
		}
	
	}
	else {
		req.setAttribute("failure", "Password missmatch");
		RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
		rd.forward(req, resp);
	}
		
	
		
	}
	else {
		req.setAttribute("failure", "Invalid data");
		RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
		rd.forward(req, resp);
	}
}
}
