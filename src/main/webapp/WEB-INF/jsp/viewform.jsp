<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>List of Students</h1>
<table>
<c:forEach var="stu" items="list">
<tr><td>Name</td><td>Address</td><td>Phone</td><td>Delete</td></tr>
<tr>
<td>${stu.name}</td>
<td>${stu.address}</td>
<td>${stu.phone}</td>
<td><a href="delete/${stu.id}">Delete</a> </td>
</tr>
</c:forEach>
</table>
</body>
</html>