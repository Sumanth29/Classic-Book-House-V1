<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<body bgcolor="lavender">
<h1><center>Classic Book House</center></h1>
<center>
<table>
<tr>
<th>ISBN</th>
<th>Book Name</th>
<th>Book Category</th>
<th>Quantity</th>
<th>Price</th>
</tr>
<c:forEach var="book" items="${bookList }">
<tr>
<td>${book.getIsbn() }</td>
<td>${book.getBookName() }</td>
<td>${book.getCategory() }</td>
<td>${book.getQuantity() }</td>
<td>${book.getPrice() }</td>
</tr>
</c:forEach>
</table>
</center>
<a href="index">Back to Home</a>
</body>
</html> 