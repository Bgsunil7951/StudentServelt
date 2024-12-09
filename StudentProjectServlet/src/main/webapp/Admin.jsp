<%@page import="com.student.dao.StudentDAOImp"%>
<%@page import="com.student.dao.StudentDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>StudentApp</title>
    <style>
    *{
    margin: 0%;
    padding: 0%;
    box-sizing: border-box;
}
.contain{
    width: 100%;
    height: auto;
}
header{
    background-color: #333;
    height: 50px;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
}
.main-header a{

    color: white;
    text-decoration: none;
    font-size: 1.8rem;
    font-weight: bold;

}
.navbar a{
    color: white;
    text-decoration: none;
    font-size: 1rem;
    font-weight: bold;
    
}
.navbar{
    width: 30%;
    display: flex;
    justify-content: space-evenly;
}
.dash{
    width: 100%;
    height: 100vh;
   
}
.main-user h1{
    color: #333;
    text-align: center;
    padding-top: 10px;
    font-size: 3rem;
    font-weight: bold;

}
.userdata h2{
    color: #333;

    margin-top: 10px;
    margin-left: 20px;
    font-size: 1.2rem;
    font-weight: bold;
}
.studentdata{
    width: 100%;
   
}

.table-data{
    width: 100%;
    display: flex;
    justify-content:space-between;
    align-items: center;
   
    
}
.table-containt td{
    width: 100%;
    text-align: center;
    
    padding: 10px;
}
.table-data th{
    width: 100%;
   
    text-align: center;
    padding: 10px;
    

}
.table-containt{
    width: 100%;
    display: flex;
    justify-content:space-between;
    align-items: center;
    background-color: white;
    
    margin-top: 1px;
}
#btn1{
 width: 70px;
 height:25px;
 color: white;
    font-size: 1rem;
    font-weight: bold;
    background-color: blue;
    border-radius: 5px;
    
}
#btn2{
 width: 70px;
 height:25px;
 color: white;
    font-size: 1rem;
    font-weight: bold;
    background-color: red;
    border-radius: 5px;
    
}
    </style>
</head>
 <script src="https://cdn.tailwindcss.com"></script>
<body>

<%Student s=(Student)session.getAttribute("student"); 
StudentDAO sdao=new StudentDAOImp();
List<Student> list=sdao.getStudent();%>
<%Iterator<Student> ir=list.iterator(); %>


<%if(s!=null) {%>
    <div class="contain">
        <header>
            <div class="main-header">
                <a href="#">Welcome <%=s.getName()%></a>
            </div>
            <nav class="navbar">
            	<a href="#" >View Accounts</a>
                <a href="forgot.jsp">Reset password</a>
                <a href="Update.jsp">Upadte data</a>
               	<form action="logout" method="post">
               	<input id="btn1" type="submit" value="Logout" name="Logout"> 
               	</form>
            </nav>
        </header>
       <%String success=(String) request.getAttribute("success");
     if(success!=null){%>
     
     <h1 class="text-2xl text-center font-bold text-green-600"> <%=success%></h1>
     <%}%>
     <%String fail=(String) request.getAttribute("failure");
     if(fail!=null){%>
 
    <h1 class=" text-2xl text-center font-bold text-red-600"> <%=fail%></h1>
  
     <%}%>

        <section  class="dash">
            <div class="main-user">
                <h1>Dashboard</h1>
            </div>
            <div class="userdata">
                <h2>View your data</h2>
                <table class="studentdata">
                    <tr class="table-data">
                        <th>ID</th>
                        <th>Name</th>
                        <th>Phone</th>
                        <th>Mail id</th>
                        <th>Branch</th>
                        <th>Location</th>
                        <th>Remove</th>
                    </tr>
                   <%while(ir.hasNext()){ %>
                    <tr class="table-containt">
                    <%Student s1=(Student)ir.next(); %>
                       	<td><%=s1.getId()%> </td>
                        <td><%=s1.getName()%> </td>
                        <td><%=s1.getPhone()%> </td>
                        <td><%=s1.getMailid()%> </td>
                        <td><%=s1.getBranch() %> </td>
                        <td><%=s1.getLocation()%> </td>
                        <td>
                        <form action="delete" method="post">
                         	<input  type="hidden" value="<%=s1.getId()%>" name="delete">
                         	<input id="btn2" type="submit" value="Delete" >
                        </form>
                        </td>
                    </tr>
				<%} %>
                </table>
            </div>
        </section>

    </div>
    <%} %>
    <%if(s==null){
   			request.setAttribute("admin", "Please login again");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
    } %>
    
</body>
</html>