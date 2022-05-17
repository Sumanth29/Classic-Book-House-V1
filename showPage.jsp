<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
* {
box-sizing: border-box;
}
.row {
margin-left: -5px;
margin-right: -5px;
}
.column {
float: left;
width: 60%;
padding: 3px;
}
.column1 {
float: left;
width: 25%;
padding: 3px;
}
/* Clearfix (clear floats) */
.row::after {
content: "";
clear: both;
display: table;
}
table {
border-collapse: collapse;
border-spacing: 0;
width: 100%;
}
th, td {
text-align: left;
padding: 5px;
}
#message {
color: red;
}
</style>
</head>
<body style="background-color: lavender">
<!-- Do not change the below line -->
<a href="/showPage?language=en">English</a>|
<a href="/showPage?language=de">German</a>|
<a href="/showPage?language=fr">French</a>
</align>
<!-- Design the page as per the requirements-->
<h1>
<center>Classic Book House</center>
</h1>
<form:form method="GET" action="/addBook" modelAttribute="book">
<div class="row">
<div class="column1">
<table>
<tr>
<td><a href="index">Home</a><br></td>
<tr>
<td><a href="viewList">View All Books</a></td>
</tr>
</table>
</div>
<div class="column">
<table
style="margin: 0px auto; margin-left: auto; margin-right: auto">
<tr>
<td><spring:message code="label.isbn" /></td>
<td><form:input path="isbn" id="isbn" /></td>
<td><form:errors path="isbn" /></td>
</tr>
<tr>
<td><spring:message code="label.bookName" /></td>
<td><form:input path="bookName" id="bookName"
/></td>
<td><form:errors path="bookName" /></td>
</tr>
<tr>
<td><spring:message code="label.quantity" /></td>
<td><form:input path="quantity" id="quantity" /></td>
<td><form:errors path="quantity" /></td>
</tr>
<tr>
<td><spring:message code="label.category" /></td>
<td><form:select path="category" id="category"
items="${bookCategory}"></form:select></td>
</tr>
<tr>
<td><spring:message code="label.price" /></td>
<td><form:input path="price" id="price" /></td>
<td><form:errors path="price" /></td>
</tr>
<tr>
<td><input type="submit" value="Submit"
id="submit"/></td>
</tr>
</table>
</div>
</div>
<div id="message">${message}</div>
</center>
</form:form>
</body>
</html>