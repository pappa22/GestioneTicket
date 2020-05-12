<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<head>
<meta charset="ISO-8859-1">
<title>Registrazione</title>
</head>
<body>
<br>
<%
		String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
	%>

	<p class="text-md-center text-light"><%=messaggio%></p>

	<%
		}
	%>
	<br>

	<form action="Registrazione" method="post" enctype = "multipart/form-data">
		
		
		
			<h4><p class="text-xl-center text-black">Nome</p></h4>
<input type="text" required="required" class="form-control" id="nome" name="nome" style="width: 250px; height: 50px; margin: auto"
				placeholder="Nome">
		<br>
		
		
			<h4><p class="text-xl-center text-black">Cognome</p></h4>
			<input type="text" required="required" class="form-control" id="cognome"
				name="cognome" style="width: 250px; height: 50px; margin: auto"
				placeholder="Cognome">
		<br>

			<h4><p class="text-xl-center text-black">Mail</p></h4>
			<input type="text" required="required" class="form-control" id="mail" name="mail"
				style="width: 250px; height: 50px; margin: auto" placeholder="Mail">
	
		<br>
		
			<h4><p class="text-xl-center text-black">Password</p></h4>
			<input type="password" required="required" class="form-control" id="password"
				name="password" style="width: 250px; height: 50px; margin: auto"
				placeholder="Password">
		<br>
		<h4><p class="text-xl-center text-black">Immagine</p></h4>
		<p class="text-xl-center"> 
		<input type="file" required="required"  id="image" name="image" placeholder="Inserisci immagine profilo">
        </p><br> 
 
		<input type="submit" class="btn btn-danger btn-block"
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