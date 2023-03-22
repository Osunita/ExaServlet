<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index page</title>
</head>
<body>
	<form action="/welcome" method="post">
		<span>nombre del dueño:</span> <input type="text" name="nombreDueño"> <br /> <br /> 
		<span>dni:</span> <input type="text" name="dni"> <br /> <br />
		<span>nombre de la mascota:</span> <input type="text" name="nombreMascota"> <br /> <br />
		<span>chip:</span> <input type="text" name="identificadorChip"> <br /> <br />
		<input type="submit">
	</form>
	<a href="listado.jsp">Listado de dueños</a>
</body>
</html>