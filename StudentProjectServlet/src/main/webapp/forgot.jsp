<%@page import="com.student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot password</title>
    <script src="https://cdn.tailwindcss.com"></script>
    <!-- <link rel="stylesheet" href="main.css">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
</head>
<body>
<%Student s=(Student)session.getAttribute("student"); %>
<%String success=(String) request.getAttribute("success");
     if(success!=null){%>
     
     <h1 class="text-2xl text-center font-bold text-green-600"> <%=success%></h1>
     <%}%>
     <%String fail=(String) request.getAttribute("failure");
     if(fail!=null){%>
 
    <h1 class=" text-2xl text-center font-bold text-red-600"> <%=fail%></h1>
  
     <%}%>
     <%String fail1=(String) request.getAttribute("fail");
     if(fail1!=null){%>
 
    <h1 class=" text-2xl text-center font-bold text-red-600"> <%=fail1%></h1>
  
     <%}%>
    <%if(s!=null) {%>
    <div class="w-full h-[100vh] lg:flex lg:flex-col lg:justify-center lg:items-center  ">
        <p class="text-black mt-10 lg:mt-0 xl:mt-0 lg:text-3xl font-bold mb-2  md:text-2xl text-center sm:text-xl">Forget <span class="text-blue-600 italic">Password</span> </p>
        <div class="relative mx-auto h-auto max-w-[80%] lg:max-w-[30%] md:max-w-[60%]  xl:max-w-[29%] border shadow-lg border-slate-200 container-main rounded-md ">
          
            <form action="forgot" method="post" class="m-5  grid  grid-cols-3 lg:grid-cols-4 xl:grid-cols-4 gap-2 xl:gap-3" >
                
                <label for="" class="lg:text-[1.1rem] mr-6">Email:</label>
                <input name="mail" type="email" value=<%=s.getMailid() %> class=" col-span-3 xl:col-span-3 hover:border-blue-500 lg:col-span-3 w-full xl:w-auto border h-8 shadow-md rounded-md hover:scale-105  hover:shadow-lg focus:outline-0 p-1"  required >
               

                <label for="" class="lg:text-[1.1rem] mr-4">Phone:</label>
                <input name="phone" type="tel" value=<%=s.getPhone() %> class="col-span-3 xl:col-span-3 lg:col-span-3 hover:border-blue-500   w-full xl:w-auto border h-8 shadow-md rounded-md hover:scale-105  hover:shadow-lg focus:outline-0 p-1" pattern="[0-9]{10}" required >
                
                
                
                <label for="" class="lg:text-[1.1rem]">password:</label>
                <input name="password" type="password" id="myInput" placeholder="Enter new password" class=" xl:col-span-3 col-span-3 w-full hover:border-blue-500  lg:col-span-3 xl:w-auto border h-8 shadow-md rounded-md hover:scale-105  hover:shadow-lg focus:outline-0 p-1" pattern="[0-9]{4,}"  required  >
                
                
                <label for="" class="lg:text-[1.1rem]">Confirm:</label>
                <input name="confirm" type="password"  placeholder="Confirm password" class="xl:col-span-3 hover:border-blue-500  col-span-3 w-full lg:col-span-3 xl:w-auto border h-8 shadow-md rounded-md hover:scale-105  hover:shadow-lg focus:outline-0 p-1"  pattern="[0-9]{4,}" required >
              
                <button id="login" type="submit" class="bg-blue-500 xl:col-span-4 lg:col-span-4 hover:scale-105 hover:shadow-md col-span-3 rounded-md h-10 w-full lg:text-[1rem] xl:text-[1rem] mt-2 font-bold text-cyan-50" >Change Password</button>
            </form>
            <p class="text-center mb-4 lg:text-[1.1rem]"> Click here <a class="decoration-blue-700 underline text-blue-700 italic " href="index.jsp">Login</a></p>
      <!--   <button class="bg-blue-500 hover:scale-105
       hover:shadow-md rounded-md h-8 m-4 w-28 lg:text-[1rem]
        xl:text-[1rem] mt-2 font-bold text-cyan-50" ><a href="Dashboard.jsp">Back</a></button> -->
        </div>
    </div>
<%} %>
   <%if(s==null){ 
  			request.setAttribute("forgot", "Please login again");
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
   } %>
</body>
</html>