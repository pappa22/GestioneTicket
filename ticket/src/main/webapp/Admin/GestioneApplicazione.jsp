<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="java.util.List"%>
<%@page import="it.dstech.gestione.Controller"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Gestione Applicazione</title>
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
    
<% String path = request.getContextPath(); %>
<hr>
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
			</tr>
		</thead>
		<c:forEach items="${listaApplicazioni}" var="lista"> 
			<tbody>
				<tr>
					<td><c:out value="${lista.getNome()}" /></td> 
 					<td><c:out value="${lista.getDescrizione()}" /></td>
 					<td>
    					<form action="GestioneApplicazione" method="post">
   					 	<input type="submit" class="btn btn-primary btn-sm" name="azione" value="Modifica">
    					<input type="submit" class="btn btn-primary btn-sm" name="azione" value="Rimuovi">
   					 	<input type="hidden" name ="id" value="${lista.getId()}"><br><br>
						</form>
					</td> 
				</tr>
		</c:forEach> 
		</tbody>
	</table>
	<hr>

	<form action="indietro" method="post">
		<input type="submit" class="btn btn-primary btn-md" name="Home" value="Torna Indietro">
	</form>
	
<%}%>
  </div>
</body>
</html>
