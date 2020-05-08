<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="java.util.List"%>
<%@page import="it.dstech.gestione.Controller"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ticket</title>
</head>
<body class="background">
  <div class="center">


    <% String messaggio = (String) request.getAttribute("messaggio"); 
    String messApp = (String) request.getAttribute("messApp"); 
  if (messaggio != null ){
    %>
    <h1>ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>
      <% 
  if (messApp != null ){
    %>
    <%=messApp%><%}%>
    
<% String path = request.getContextPath();
%>
<h4>Ticket Aperti</h4>
<hr>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Stato</th>
				<th>Data</th>
				<th>Applicazione</th>
				<th>Utente</th>
				<th>Chiudi Ticket</th>
			</tr>
		</thead>
		<c:forEach items="${listaTicketAttivo}" var="lista"> 
			<tbody>
				<tr>
					<td><c:out value="${lista.getNome()}" /></td> 
 					<td><c:out value="${lista.getDescrizione()}" /></td>
 						<td>Attivo</td> 
 					<td><c:out value="${lista.getData()}" /></td>
 						<td><c:out value="${lista.getApplicazione().getNome()}" /></td> 
 					<td><c:out value="${lista.getUtente().getUsername()}" /></td>
 					<td>
    					<form action="<%=path%>/Admin/GestioneApplicazione" method="post">
    					<input type="hidden" name ="email" value="${lista.getUtente().getUsername()}">
   					 	<input type="hidden" name ="id" value="${lista.getId()}"><br><br>
   					 	<input type="submit" name="azione" value="Chiudi Ticket">
						</form>
					</td> 
				</tr>
		</c:forEach> 
		</tbody>
	</table>
	<hr>
	
	<h4>Ticket Chiusi</h4>
	<hr>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Stato</th>
				<th>Data</th>
				<th>Applicazione</th>
				<th>Utente</th>
			</tr>
		</thead>
		<c:forEach items="${listaTicketChiuso}" var="lista"> 
			<tbody>
				<tr>
					<td><c:out value="${lista.getNome()}" /></td> 
 					<td><c:out value="${lista.getDescrizione()}" /></td>
 						<td>Chiuso</td> 
 					<td><c:out value="${lista.getData()}" /></td>
 						<td><c:out value="${lista.getApplicazione().getNome()}" /></td> 
 					<td><c:out value="${lista.getUtente().getUsername()}" /></td>
 					
				</tr>
		</c:forEach> 
		</tbody>
	</table>
	<hr>

	<form action="indietro" method="post">
		<input type="submit" name="Home" value="Torna Indietro">
	</form>
	
<%}%>
  </div>
</body>
</html>