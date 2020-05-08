<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="it.dstech.gestione.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Modifica Applicazione</title>
</head>
<body>
<div class="center">
<%Applicazione app = (Applicazione) request.getAttribute("applicazione");%>
<%Controller gestione = new Controller(); %>

<% String path = request.getContextPath(); %>

<form action="ModificaApplicazione" method="post">
  <h1><%=app.getNome()%></h1>
  <h2>Inserisci le caratteristiche  da modificare</h2>
       
    <label for="nome">Nome:</label><br>
    <input type="text" required="required" name="nome" value="<%=app.getNome()%>" /><br><br>
     <label for="descrizione">Descrizione:</label><br>
     <input type="text" required="required" name="descrizione" value="<%=app.getDescrizione()%>" /><br><br> 
  <br><input type="submit" class = "button"  value="Modifica">
  <input type="hidden" value="<%=app.getId()%>" name="idApp">
</form>
<form action="<%=path%>/Admin/GestioneApplicazione" method="post">
<input type="submit" name="azione" value="Torna indietro">  
</form>
</div>
</body>
</html>