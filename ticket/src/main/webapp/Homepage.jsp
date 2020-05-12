<%@page import="it.dstech.modelli.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">

<head>
<meta charset="ISO-8859-1">
<title>Gestione Ticket</title>
</head>

<body>
	<div class="center">

		<%
			String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
		%>
		<h1 style="color: red;"><%=messaggio%></h1>

		<%
			}
		%>

		<h1>Benvenuto in Gestione Ticket!</h1>

		<i>Da qui puoi effettuare i ticket di lamentela per le tue
			applicazioni</i> <br>
		<h3>Effettua l'accesso o registrati se ancora non hai un account
			utente:</h3>


		<form action="Accesso" method="post">
			
				<label for="username">Username:</label><br> <input type="email"
					required="required" name="mail" placeholder="E-mail"><br>
				<label for="password">Password:</label><br> <input
					type="password" required="required" name="password"
					placeholder="Password"><br>
				<br>

			<input type="submit" class="btn btn-danger" class="button"
				name="scelta" value="Login" />
		</form>

		<br> <br>Non sei ancora registrato? <br> <br>
		<form action="Accesso" method="post">
			<input type="submit" class="btn btn-primary" name="scelta"
				value="Registrazione" />
		</form>
	</div>
</body>
</html>