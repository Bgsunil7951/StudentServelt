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

@WebServlet("/delete")
public class Delete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id1= req.getParameter("delete");
		int id=Integer.parseInt(id1);
		
		HttpSession session=req.getSession();
		Student s=(Student) session.getAttribute("student");
		int admin=s.getId();
		StudentDAO sdao=new StudentDAOImp();
		Student s1=new Student();
		
		
		if(admin!=id) {
			s1.setId(id);
			boolean res=sdao.deleteStudent(s1);
			if(res) {
				req.setAttribute("success", "Student deleted successfully");
				RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
				rd.forward(req, resp); 
			}
			else {
				req.setAttribute("failure", "Failed to delete data");
				RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
				rd.forward(req, resp); 
			}
		}
		else {
			req.setAttribute("failure", "Admin account can't be deleted");
			RequestDispatcher rd=req.getRequestDispatcher("Admin.jsp");
			rd.forward(req, resp); 
		}
		
	}
}
