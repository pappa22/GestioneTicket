<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="it.dstech.gestione.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Modifica Applicazione</title>
</head>
<body>
<br>
<div class="center">
<%Applicazione app = (Applicazione) request.getAttribute("applicazione");%>
<%Controller gestione = new Controller(); %>

<% String path = request.getContextPath(); %>
<form action="ModificaApplicazione" class="col-lg-6 offset-lg-3"  method="post">
<div class="row justify-content-center">
  <h2>Inserisci le caratteristiche  da modificare</h2>
       <div class="form-group">
  <div class="col-xs-2"> 
    <label for="nome">Nome:</label><br>
    <input type="text" required="required" class="form-control" name="nome" value="<%=app.getNome()%>" /><br><br>
     <label for="descrizione">Descrizione:</label><br>
     <input type="text" required="required" class="form-control" name="descrizione" value="<%=app.getDescrizione()%>" />
     <div class="container">
  <div class="row">
    <div class="col text-center"> 
  <br><input type="submit" class ="btn btn-primary btn-md"  value="Modifica">
  </div></div></div>
  <input type="hidden" value="<%=app.getId()%>" name="idApp">
  </div></div>
</div>
</form>
<form action="indietro" class="col-lg-6 offset-lg-3" method="post">
<div class="row justify-content-center">
<div class="container">
  <div class="row">
    <div class="col text-center">
<input type="submit"  class ="btn btn-primary btn-md" name="azione" value="Torna indietro">  
</div></div></div>
</div>
</form>
</div>
</body>
</html>