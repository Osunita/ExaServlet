<%@ page import="java.util.List" %>
<%@ page import="model.duenos" %>
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
<%
    List<duenos> owners = new duenos().getOwners();
%>
<table>
    <thead>
        <tr>
            <th>Nombre</th>
            <th>DNI</th>
        </tr>
    </thead>
    <tbody>
        <% for (duenos owner : owners) { %>
            <tr>
                <td><%= owner.getNombreDueño() %></td>
                <td><%= owner.getDni() %></td>
            </tr>
        <% } %>
    </tbody>
</table>
</body> 
</html>