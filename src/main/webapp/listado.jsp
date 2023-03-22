<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado dueños</title>
</head>
<body>

<table border="1">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>Curso</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="user1" items="${listAllUsers}">
			<tr>
				<td><c:out value="${user1.nombreDueño}"/> </td>
				<td><c:out value="${user1.nombreMascota}"/> </td>
				
	    	</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>