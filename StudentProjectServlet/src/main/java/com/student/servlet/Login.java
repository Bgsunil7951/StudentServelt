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

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImp();

		PrintWriter out=resp.getWriter();
		
		String mail=req.getParameter("mail");
		String pass=req.getParameter("password");
		
		
		Student s=sdao.getStudent(mail, pass);
		
		HttpSession session=req.getSession();
		
		
		if(s!=null) {
			session.setAttribute("student", s);
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
			
			
//			out.println("<h1>login successfull, Welcome "+s.getName()+"</h1>"
//					+ "<br>"
//					+ "<a href=\"index.html\">Back</a>");
		
		}
		else {
			
			req.setAttribute("failure", "Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp); 
			
			
//			out.println("<h1>Invalid Password or mailID</h1>"
//					+ "<br>"
//					+ "<a href=\"index.html\">Back</a>");
		}
		
		
		
	}
}
