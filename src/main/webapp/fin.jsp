<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado</title>
</head>
<body>
<h1>Dueños</h1>
<c:forEach items="${nombres}" var="nombre">
	<div>${nombre}</div>
</c:forEach>
</body> 
</html>