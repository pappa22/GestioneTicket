<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String messaggio = (String) request.getAttribute("mess");
	if (messaggio != null) {
	%>
	<p class="text-md-center text-danger"><%=messaggio%></p>

	<%
		}
	%>
	<br>
	<form action="tornaIndietro" method="post">

		<input type="submit" class="btn btn-primary btn-block"
			style="width: 125px; height: 45px; margin: auto" name="azione"
			value="Torna Indietro">
	</form>

	<%
		String path = request.getContextPath();
	%>
	<form action="<%=path%>/Utente/CreaTicket" method="post">
		<input type="hidden" id="idApp" name="idApp"
			value=<%=request.getAttribute("idApp")%> /> <input type="text"
			name="nome" placeholder="Nome"> <br> <input type="text"
			name="descrizione" placeholder="Descrizione"> <br> <br>
		<h5>
			<p class="text-xl text-black">Priorità</p>
		</h5>
		<select name="priorita">

			<option value="1">Bassa</option>
			<option value="2">Media</option>
			<option value="3">Alta</option>

		</select> <br><br>
		<button type="submit" class="pulsante">Aggiungi</button>
		<br>
	</form>

</body>
</html>