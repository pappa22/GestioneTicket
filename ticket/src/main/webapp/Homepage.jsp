<%@page import="it.dstech.modelli.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">

<head>
<meta charset="ISO-8859-1">
<title>Gestione Ticket</title>
</head>

	<body>
	<div class="center" >
	
	<% String messaggio = (String) request.getAttribute("mess"); 
		if (messaggio != null ){  %>
			<h1 style="color:red;"><%=messaggio%></h1>
		
		<% } %>

				<h1>Benvenuto in Gestione Ticket!</h1>

				<i>Da qui puoi effettuare i ticket di lamentela per le tue applicazioni</i>
				
				<br><h3>Effettua l'accesso o registrati se ancora non hai un account utente:</h3>


				<form action= "Accesso" method="post">

					<label for="username">Username:</label><br>
		  			<input type="text" required="required" name="mail"  placeholder="E-mail"><br>
		  			<label for="password">Password:</label><br>
		  			<input type="password" required="required" name="password" placeholder="Password"><br>
					<input type="submit" class="button" name="scelta" value="Login" />
					</form>
					
					<br>
					<br>Non sei ancora registrato? <br>
					<br>
					<form action= "Accesso" method="post">
					<input type="submit" class="button" name="scelta" value="Registrazione" />
					</form>
			</div>
		</body>
</html>