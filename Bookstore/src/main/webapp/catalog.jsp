<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html>
<html>
   <head>
      <title>JSTL x:parse Tags</title>
   </head>

   <body>
      <h3>Books Info:</h3>
      <c:import var = "catalog" url="http://localhost:8080/Bookstore/catalog.xml"/>
 
      <x:parse xml = "${catalog}" var = "catalog"/>
      
<%--       <b>The title of the first book is</b>: 
      <x:out select = "$output/catalog/book[1]/title" />
      <br>
      
      <b>The price of the second book</b>: 
      <x:out select = "$output/catalog/book[2]/price" /> --%>
      
      <%-- <c:forEach items="${ books }" var="book" varStatus="status">
      	<ul>
      		<li><c:out value="${ status.author }"></c:out></li>
      		<li><c:out value="${ status.title }"></c:out></li>
      		<li><c:out value="${ status.genre }"></c:out></li>
      		<li><c:out value="${ status.price }"></c:out></li>
      		<li><c:out value="${ status.publish_date }"></c:out></li>
      		<li><c:out value="${ status.description }"></c:out></li>
      	</ul>
      </c:forEach>  --%>
      
      
      
      <div id="books">
	      <x:forEach select="$catalog/books/book" var="book">
	      	<div class="book">
		      	<ul>
		      		<li><x:out select="$book/author"/></li>
		      		<li><x:out select="$book/title"/></li>
		      		<li><x:out select="$book/genre"/></li>
		      		<li><x:out select="$book/price"/></li>
		      		<li><x:out select="$book/publish_date"/></li>
		      		<li><x:out select="$book/description"/></li>
		   		</ul>
	   		</div>
	      </x:forEach>
      </div>
   </body>
</html>