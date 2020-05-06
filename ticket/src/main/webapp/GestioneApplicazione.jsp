<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="java.util.List"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Gestione applicazione</title>
</head>
<body class="background">
  <div class="center">


    <% String messaggio = (String) request.getAttribute("messaggio"); 
  if (messaggio != null ){
    %>
    <h1>ERRORE</h1>
    <%=messaggio%>
    <% }
  else {
%>

    <%List<Applicazione> listaApplicazioni = (List<Applicazione>)request.getAttribute("lista");%>
<table class="table">
<tr>
  <th>Lista Eroi</th>
</tr>
<tr>
    <td>Nome</td> 
	<td>Potere</td> 
	<td>Costo</td> 
	<td>HP</td>    
	<td>Immagine eroe</td>    

  
<% for(Applicazione l : listaApplicazioni){
  String nomeEroe = l.getNome();
%>

<tr>

  <td><%=l.getNome()%> </td> 
  <td><%=l.getDescrizione()%></td>
  <td><%=l.getAdmin()%></td> 
  <td><%=l.getListaTicket()%></td> 

  <td>
    <form action="GestioneApplicazione" method="post">
    <input type="hidden" name ="eroeDaRimuovere" value="<%=nomeEroe%>"><br><br>
    <input type="submit" name="azione" value="Modifica">
    <input type="submit" name="azione" value="Rimuovi">
</form></td> 

<% } %>
</table>
    
    <% } %>
    <form action="SceltaAdmin" method="post">
    <input type="submit" name="azione" value="Torna indietro">
    
    </form>
  </div>
</body>
</html>
