<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Titre du livre - Bookstore</title>
</head>
<body>
    <%
        String user = (String) request.getParameter("user"); 
        String pass = (String) request.getParameter("password");
        String email = (String) request.getParameter("email");
        String date = (String) request.getParameter("date");

        String image = (String) request.getAttribute("image");
        String title = (String) request.getAttribute("title");
    %>
    User: <%=user %> </br>
    Pass: <%=pass %> </br>
    email: <%=email %> </br>
    Birth Date: <%=date %> </br>
    <h1><%=title %></h1></br>
    <img src="data:image/jpeg;base64, <%= image %>"/>
    <!-- <img src="DisplayImage"/>  -->
</body>
</html>