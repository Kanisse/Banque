<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,Model.*"%>

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<% 	ArrayList <Agence> liste=(ArrayList<Agence>)request.getAttribute("liste");%>
<meta charset="ISO-8859-1">
<title>Liste des Agences</title>
</head>
<body>



<a class="btn btn-primary" href="TraitementAgence?lien=add&libelle=0">Nouvelle Agence</a>
<a class="btn btn-info" href="/Banque/">Revenir à la page acceuil</a>


<h1>Liste des Agences</h1>


<table class="table table-striped">
<tr><th>ID</th><th>Nom</th><th>Adresse</th></tr>
<%
Agence a= null;
for (int i=0;i<liste.size();i++)
{
  	a=liste.get(i);
%>
<tr>
<td><%=a.getLibelleAg()%></td>
<td><%=a.getNomAg()%></td>
<td><%=a.getAdresseAg()%></td>
<td><a class="btn btn-primary" href="TraitementClients?id=<%=a.getLibelleAg()%>">Afficher les clients</a></td>
<td><a class="btn btn-success" href="TraitementAgence?lien=supp&libelle=<%=a.getLibelleAg()%>">Supprimer</a></td>
<td><a class="btn btn-warning" href="TraitementAgence?lien=modif&libelle=<%=a.getLibelleAg()%>">Modifier</a></td>
</tr>
<%} %>

</table>

<%@ include file="footer.jsp" %>
</body>
</html>