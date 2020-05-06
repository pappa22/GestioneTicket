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
<meta charset="UTF-8">
<title>Aggiunta Applicazione</title>
</head>
<body>

<% String path = request.getContextPath(); 
	Controller gestione = new Controller();
	Admin admin = (Admin) session.getAttribute("admin");
	List<Applicazione> listaApplicazioni = (List<Applicazione>) request.getAttribute("listaApplicazioni");
%>
<form action="<%=path%>/Admin/AggiuntaApplicazione" method="post">
		<input type="text" name="nome" placeholder="Nome"> <br> 
		
		<input type="text" name="descrizione" placeholder="Descrizione">
		<br>
		<button type="submit" class="pulsante">Aggiungi</button>
		<br>
	</form>
	<form action="/Admin/SceltaAdmin" method="post">
		<input type="submit" name="Home">
	</form>
	<hr>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
			</tr>
		</thead>
		<% for(Applicazione app : listaApplicazioni){ %>
<%-- 		<c:forEach items="${gestione.getListaApplicazioni(admin)}" var="lista"> --%>
			<tbody>
				<tr>
				<td><%=app.getNome()%></td>
				<td><%=app.getDescrizione() %></td>
<%-- 					<td><c:out value="${lista.getNome()}" /></td> --%>
<%-- 					<td><c:out value="${lista.getDescrizione()}" /></td> --%>
				</tr>
				<%} %>
				
<%-- 		</c:forEach> --%>
		</tbody>
	</table>
	<hr>
</body>
</html>