<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nouveau livre ajouté - Bookstore</title>
</head>
<body>
    <%
        String title = (String) request.getParameter("title"); 
        String author = (String) request.getParameter("author");
        String price= (String) request.getParameter("price");
        String genre = (String) request.getParameter("genre");
        String publish_date = (String) request.getAttribute("publish_date");
        String cover = (String) request.getAttribute("cover");
        String description = (String) request.getAttribute("description");
        
        
    %>
    <h2>Nouveau livre ajouté au catalogue</h2>
    <ul>
    	<li>Titre : <%=title %></li>
    	<li>Auteur : <%=author %></li>
    	<li>Prix : <%=price %></li>
    	<li>Genre : <%=genre %></li>
    	<li>Date de première publication : <%=publish_date %></li>
    	<li>Première de couverture : <img src="data:image/jpeg;base64, <%=cover %>"/></li>
    	<li>Description : <%=description %></li>
    </ul>
    
    
</body>
</html>