<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
	%>

	<p class="text-md-center text-light"><%=messaggio%></p>

	<%
		}
	%>
	<br>
	<br>
	<br><br><br>
	<form action="Registrazione" method="post" enctype = "multipart/form-data">
		
		
		
			<h4><p class="text-xl-center text-warning">Nome</p></h4>
			<input type="text" class="form-control" id="nome"
				name="nome" style="width: 250px; height: 50px; margin: auto"
				placeholder="Rating iniziale">
		<br>
		
		
			<h4><p class="text-xl-center text-warning">Cognome</p></h4>
			<input type="text" class="form-control" id="cognome"
				name="cognome" style="width: 250px; height: 50px; margin: auto"
				placeholder="Rating iniziale">
		<br>

			<h4><p class="text-xl-center text-warning">Mail</p></h4>
			<input type="text" class="form-control" id="mail" name="mail"
				style="width: 250px; height: 50px; margin: auto" placeholder="Mail">
	
		<br>
		
			<h4><p class="text-xl-center text-warning">Password</p></h4>
			<input type="password" class="form-control" id="password"
				name="password" style="width: 250px; height: 50px; margin: auto"
				placeholder="Password">
		<br>
		<p class="text-xl-center"> 
 <input type="file"  id="image" name="image" placeholder="Inserisci immagine profilo">
 </p><br> 
 
 <h4><p class="text-xl-center text-warning">Scegli il tipo di account</p></h4>
 <br>
 	<input type="radio" name= "tipo" value="admin">Admin
 	<br>
 	<input type="radio" name= "tipo" value="utente"/>Utente
		
		<input type="submit" class="btn btn-warning btn-block"
			style="width: 150px; height: 45px; margin: auto" name="azione"
			value="Registrati">
	</form>
	
	<br>
	<br>
		<% String path = request.getContextPath(); %>
<form action="<%=path%>/" method="post">
  <input type="submit"  class="btn btn-primary btn-block" style="width:150px; height:50px;margin:auto" value="Torna Indietro">
</form>
</body>
</html>