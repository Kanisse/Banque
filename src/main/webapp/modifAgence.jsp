<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,Model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Formulaire de modification</title>
</head>
<body>

<% Agence a=(Agence)request.getAttribute("a"); %>

<form class="form-group" action="TraitementAgence" method="post">

<input type="hidden" value="<%=a.getLibelleAg()%>" name="id" placeholder="Entrer le nom">
<input type="text" value="<%=a.getNomAg()%>" name="NomAgence" placeholder="Entrer le nom">
<input type= "text"  value="<%=a.getAdresseAg()%>" name="AdresseAgence" placeholder="Entrer l'adresse">
<input type ="submit" name="boutton" value="Modifier">

</form>

</body>
</html>