<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="static/style.css">
<meta charset="UTF-8">
<title>Aggiunta Applicazione</title>
</head>
<body>
	<%
		String path = request.getContextPath();
	%>

	<form action="<%=path%>/admin/..." method="post">
		<input type="text" name="nome" placeholder="Nome"> <br> 
		
		<input type="text" name="descrizione" placeholder="Descrizione">
		<br>
		<button type="submit" class="pulsante">Aggiungi</button>
		<br>
	</form>
	<form action="<%=path%>/admin/tornaAlProfiloAdmin" method="post">
		<button type="submit" class="pulsante">Torna indietro</button>
	</form>
	<hr>
	<table>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
			</tr>
		</thead>
		<c:forEach items="${lista}" var="lista">
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