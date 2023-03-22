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
	<ul>
        <c:forEach items="${owners}" var="owner">
            <li>${owner.nombre} (${owner.dni})</li>
        </c:forEach>
    </ul>
</body> 
</html>