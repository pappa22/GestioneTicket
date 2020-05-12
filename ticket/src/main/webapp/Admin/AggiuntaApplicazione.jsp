<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="it.dstech.gestione.Controller"%>
 <%@page import="it.dstech.modelli.Applicazione"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Aggiunta Applicazione</title>
</head>
<body>

<% String path = request.getContextPath(); %>
<br><br>
<div class="container center_div">
<form action="<%=path%>/Admin/AggiuntaApplicazione" method="post">
 <div class="form-group">
  <div class="col-xs-2">
		<input type="text" name="nome" class="form-control" id="ex2" placeholder="Nome"> <br> 
		<input type="text" class="form-control" id="ex2"  name="descrizione" placeholder="Descrizione">
	</div>
		<br>
		<button type="submit" class="btn btn-primary btn-md">Aggiungi</button>
    </div>
		<br>
	</form>
	<form action="indietro" method="post">
		<input type="submit" class="btn btn-primary btn-md" name="Home" value="Torna Indietro">
	</form>
	</div>
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
				</tr>
		</c:forEach> 
		</tbody>
	</table>
	<hr>
</body>
</html>