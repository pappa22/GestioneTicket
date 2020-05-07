<%@page import="it.dstech.modelli.Utente"%>
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
<title>Profilo Utente</title>
</head>

<div class="container">
			<div class="row">
				<div class="col-xl align-self-center ">


    <% String messaggio = (String) request.getAttribute("mess");
    	Utente u = (Utente) session.getAttribute("utente");
    
  if (messaggio != null ){
    %>
    <h1 style="color:Tomato;">ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>

      <h1>Benvenuto/a <%=u.getNome()%></h1>
 <br>
<img alt="image" style="vertical-align: middle; width: 150px; height: 150px; border-radius: 50%;" src="data:image/jpg;base64, <%= u.getImage() %>"> <br>
      <br>Qui puoi recensire le nostre applicazioni.<br>

<br>

<% String path = request.getContextPath(); %>
    <form action="<%=path%>/Utente/SceltaUtente" method="post">
      <input type="submit"  class = "button" name ="azione" value="Lista Applicazioni" /> <br><br>
 
      <input type="submit"  class = "button" name ="azione" value="Log Out" /> <br><br>
      
    </form>
    <% } %>
    
  </div></div></div>
</body>
</html>