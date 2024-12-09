<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login page</title>
    <!-- <link rel="stylesheet" href="main.css"> -->
    
    <script src="https://cdn.tailwindcss.com"></script>

  
    
</head>
<body>
<%String success=(String) request.getAttribute("success");
  	   if(success!=null){%>
  	  <h1 class=" text-2xl text-center font-bold text-green-600"> <%=success%></h1>
	<%}%>
	<%String failure=(String) request.getAttribute("failure");
  	   if(failure!=null){%>
  	  <h1 class=" text-2xl text-center font-bold text-red-600"> <%=failure%></h1>
	<%}%>
	<%String forgot=(String) request.getAttribute("forgot");
  	   if(forgot!=null){%>
  	  <h1 class=" text-2xl text-center font-bold text-red-600"> <%=forgot%></h1>
	<%}%>
	<%String update=(String) request.getAttribute("update");
  	   if(update!=null){%>
  	  <h1 class=" text-2xl text-center font-bold text-red-600"> <%=update%></h1>
	<%}%>
	<%String dashboard=(String) request.getAttribute("dashboard");
  	   if(dashboard!=null){%>
  	  <h1 class=" text-2xl text-center font-bold text-red-600"> <%=dashboard%></h1>
	<%}%>
<div class="w-full h-[100vh] lg:flex lg:flex-col lg:justify-center lg:items-center  ">
    <p class="text-black mt-10 lg:mt-0 xl:mt-0 lg:text-3xl font-bold mb-2  md:text-2xl text-center sm:text-xl">Student <span class="text-blue-500 italic">Login</span> </p>
    <div class=" mx-auto h-auto max-w-[80%] lg:max-w-[30%] md:max-w-[60%]  xl:max-w-[29%] border shadow-lg border-slate-200 container-main rounded-md ">
      
        <form  action="login" method="post" class="m-5  grid  grid-cols-3 lg:grid-cols-4 xl:grid-cols-4 gap-2 xl:gap-4" id="registrationForm" >
          <!--   <label for="" class="lg:text-[1.1rem] mr-4" >UserId:</label> 
            <input type="text" placeholder="Enter User Id" class="hover:border-blue-500 col-span-3 lg:col-span-3  xl:col-span-3 w-full xl:w-auto border h-8  shadow-md rounded-md hover:scale-105 hover:shadow-lg focus:outline-0 p-1" pattern="[0-9]{14}" required>
           -->
           <label for="" class="lg:text-[1.1rem] mr-4 -mt-1" >Emailid:</label> 
            <input id="email"  name="mail" type="email" placeholder="Enter email Id" class="-mt-1 hover:border-blue-500 col-span-3 lg:col-span-3  xl:col-span-3 w-full xl:w-auto border h-8  shadow-md rounded-md hover:scale-105 hover:shadow-lg focus:outline-0 p-1"  >
            <span id="emailError" class="text-red-600 xl:-mt-2 col-span-3 lg:col-span-4  xl:col-span-4  error
            w-full xl:w-auto "></span> 
           
            <label for="" class="lg:text-[1.1rem] ">password:</label>
            <input id="password" name="password" type="password" placeholder="Enter password" class="hover:border-blue-500 xl:col-span-3 col-span-3 w-full lg:col-span-3 xl:w-auto border h-8 shadow-md rounded-md hover:scale-105  hover:shadow-lg focus:outline-0 p-1" >
    		<span id="passwordError" class="text-red-600 xl:-mt-2 col-span-3 lg:col-span-4  xl:col-span-4  error
            w-full xl:w-auto "></span>
    		
            <p class="mt-2 xl:col-span-4 lg:col-span-4 col-span-3 lg:text-[1.1rem]">Forgot <a href="#" class="decoration-blue-700 underline text-blue-700 italic">password ?</a></p>
            
 
            <button id="login" type="submit" class="bg-blue-500 xl:col-span-4 lg:col-span-4 hover:scale-105 hover:shadow-md col-span-3 rounded-md h-10 w-full lg:text-[1rem] xl:text-[1rem] mt-2 font-bold text-cyan-50 ">Login</button>
        </form>
        <p class="text-center mb-4 lg:text-[1.1rem]">Don't have an account? <a class="decoration-blue-700 underline text-blue-700 italic" href="Singup.jsp">Register</a></p>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script>
$(document).ready(function () {
    $("#").on("submit", function (e) {
        e.preventDefault(); // Prevent form submission

        let isValid = true;
        $(".error").text(""); // Clear previous error messages
        $("#formMessage").text(""); // Clear previous success message

        // Validate Name
        // const name = $("#name").val().trim();
        // const nameRegex = /^[a-zA-Z\s]+$/;
        // if (name === "") {
        //     $("#nameError").text("**Please enter the name.");
        //     isValid = false;
        // }
        // else if(!nameRegex.test(name)){
        //     $("#nameError").text("**Name can only contain letters and spaces.");
        // }
        // else if(name.length<3){
        //     $("#nameError").text("**Name must be at least 3 characters long.");
        //     isValid = false;
        // }
        

        // Validate Email
        const email = $("#email").val().trim();
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (email === "") {
            $("#emailError").text("**Email is required.");
            isValid = false;
        } else if (!emailRegex.test(email)) {
            $("#emailError").text("**Invalid email format.");
            isValid = false;
        }

        // Validate Password
        const password = $("#password").val();
        if (password === "") {
            $("#passwordError").text("**Password is required.");
            isValid = false;
        } else if (password.length < 4) {
            $("#passwordError").text("**Password must be at least 4 characters long.");
            isValid = false;
        }

        // Validate Terms Checkbox
        // if (!$("#terms").is(":checked")) {
        //     $("#termsError").text("You must agree to the terms.");
        //     isValid = false;
        // }

        // Final Check
        // if (isValid) {
        //     $("#formMessage").text("Form submitted successfully!");
        //     // Here you can send the form data to the server using AJAX
        //     // $.post('/submit', $(this).serialize());
        // }
        
        return true;
    });
});

</script>


</body>
</html>