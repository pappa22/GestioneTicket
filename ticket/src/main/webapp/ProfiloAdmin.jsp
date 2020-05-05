<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Admin.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Profilo Admin</title>
</head>
<body class="Admin">
<div class="center">


    <% String messaggio = (String) request.getAttribute("messaggio"); 
  if (messaggio != null ){
    %>
    <h1 style="color:Tomato;">ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>
      <h1>Benvenuto Amministratore</h1>

      <br>Qui puoi inserire o rimuovere gli eroi che gli utenti potranno aggiungere nel tracker.<br>

<br>


    <form action="SceltaAdmin" method="post">
      <input type="submit"  class = "button" name ="azione" value="Aggiungi Applicazione" /> <br><br>
      <input type="submit"  class = "button" name ="azione" value="Gestione Applicazione" /> <br><br>
      <input type="submit"  class = "button" name ="azione" value="Gestione Ticket" /> <br><br>
    </form>
    <% } %>
    
  </div>
</body>
</html>