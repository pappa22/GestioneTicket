<%@page import="it.dstech.modelli.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Admin.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Profilo Utente</title>
</head>
<body class="Admin">
<div class="center">


    <% String messaggio = (String) request.getAttribute("mess");
    	Utente u = (Utente) session.getAttribute("utente");
    
  if (messaggio != null ){
    %>
    <h1 style="color:Tomato;">ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>

      <h1>Benvenuto Utente <%=u.getUsername()%></h1>

      <br>Qui puoi recensire le nostre applicazioni.<br>

<br>

<% String path = request.getContextPath(); %>
    <form action="<%=path%>/Utente/SceltaUtente" method="post">
      <input type="submit"  class = "button" name ="azione" value="Lista Applicazioni" /> <br><br>
      <input type="submit"  class = "button" name ="azione" value="Gestione Ticket" /> <br><br>
      <input type="submit"  class = "button" name ="azione" value="Log Out" /> <br><br>
      
    </form>
    <% } %>
    
  </div>
</body>
</html>