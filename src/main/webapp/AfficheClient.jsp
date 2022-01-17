<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,Model.*"%>
<!DOCTYPE html>
<html>
<%@ include file="header.jsp" %>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<% 	ArrayList <Clients> liste=(ArrayList<Clients>)request.getAttribute("liste");%>
<meta charset="ISO-8859-1">
<title>Liste des clients</title>
</head>
<body>



<a class="btn btn-primary" href="TraitementAgence?lien=add&libelle=0">Nouvelle Agence</a>
<a class="btn btn-info" href="/Banque/">Revenir à la page acceuil</a>


<h1>Liste des Clients</h1>


<table class="table table-striped">
<tr><th>ID</th><th>Nom</th><th>Prénom</th><th>Adresse</th></tr>
<%
Clients c= null;
for (int i=0;i<liste.size();i++)
{
  	c=liste.get(i);
%>
<tr>
<td><%=c.getId_Client() %></td>
<td><%=c.getNom_Client()%></td>
<td><%=c.getPrenom_Client()%></td>
<td><%=c.getAdresse() %></td>
<td><a class="btn btn-primary" href="TraitementClients?id=<%=c.getId_Client()%>">Afficher Comptes & opérations</a></td>
<td><a class="btn btn-success" href="TraitementAgence?lien=supp&libelle=<%=c.getId_Client()%>">Supprimer</a></td>
<td><a class="btn btn-warning" href="TraitementAgence?lien=modif&libelle=<%=c.getId_Client()%>">Modifier</a></td>

</tr>
<%} %>

</table>

<%@ include file="footer.jsp" %>
</body>
</html>