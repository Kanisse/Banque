<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.*"%>
<!DOCTYPE html>
<html>
<head>
<% 	ArrayList <Users> liste=(ArrayList<Users>)session.getAttribute("liste");%>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Page acceuil</title>
</head>
<body>
<%
Users u=null;
u=liste.get(0);
%>

<h1>Bienvenue <%=u.getUtilisateurUsers() %></h1>


</body>
</html>
<%@ include file="footer.jsp"%>