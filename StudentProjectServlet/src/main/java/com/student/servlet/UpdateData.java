package com.student.servlet;

import java.io.IOException;

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

@WebServlet("/updateData")
public class UpdateData extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String phonenum=req.getParameter("phone");
		String mail=req.getParameter("mail");
		String branch=req.getParameter("branch");
		String loc=req.getParameter("loc");
		
		long phone=Long.parseLong(phonenum);
		
		StudentDAO sdeo=new StudentDAOImp();
		
		HttpSession session=req.getSession(false);
		
		Student s=(Student)session.getAttribute("student");
		
		if(s!=null) {
			s.setName(name);
			s.setPhone(phone);
			s.setMailid(mail);
			s.setBranch(branch);
			s.setLocation(loc);
			boolean res=sdeo.updateStudent(s);
			
			if(res) {
				req.setAttribute("success", "Update successful");
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp);
			}
			else {
				req.setAttribute("failure", "Update failed");
				RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
				rd.forward(req, resp); 
			}
		}
		
		
	}
}
