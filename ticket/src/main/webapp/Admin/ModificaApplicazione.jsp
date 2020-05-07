<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Applicazione"%>
<%@page import="it.dstech.gestione.Controller"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link href="css/Default.css" rel="stylesheet" type="text/css">
<link href="css/text.css" rel="stylesheet" type="text/css">
<link href="css/table.css" rel="stylesheet" type="text/css">
<head>
<meta charset="ISO-8859-1">
<title>Modifica Applicazione</title>
</head>
<body>
<div class="center">
<%Applicazione app = (Applicazione) request.getAttribute("applicazione");%>
<%Controller gestione = new Controller(); %>

 


<form action="indietro" method="post">
<input type="submit" name="azione" value="Torna indietro">	
</form>
</div>
</body>
</html>