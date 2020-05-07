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
<br>
	<%
		String messaggio = (String) request.getAttribute("mess");
	if (messaggio != null) {
	%>
	<p class="text-md-center text-danger"><%=messaggio%></p>
	<%
		}
	%>
	<br>
<br>
	<div class="container">
		<div class="row">
			<div class="col-xl align-self-center ">
				<table class="table table-striped">

					<tr>
						<th><h5>
								<p class="text-md text-danger">Nome</p>
							</h5></th>
						<th><h5>
								<p class="text-md text-danger">Descrizione</p>
							</h5></th>
						<th><h5>
								<p class="text-md text-danger">Stato Ticket</p>
							</h5></th>
						<th><h5>
								<p class="text-md text-danger">Data</p>
							</h5></th>
							
							<th><h5>
								<p class="text-md text-danger">Nome App</p>
							</h5></th>
							
							<th><h5>
								<p class="text-md text-danger">Gestione Ticket</p>
							</h5></th>
					</tr>

					<c:forEach items="${ticket}" var="ticket">

						<tr>
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${ticket.getNome()}" />
									</p>
								</h5></td>
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${ticket.getDescrizione()}" />
									</p>
								</h5></td>
							<td><h5>
							<c:if test="${ ticket.getStato() eq true}">  
   
									<p class="text-md text-black">
										<c:out value="Attivo" />
									</p>
										
									</c:if> 
									<c:if test="${ ticket.getStato() eq false}">  
   
									<p class="text-md text-black">
										<c:out value="Chiuso" />
									</p>
										
									</c:if> 
									
								</h5></td>
                             
                             <td><h5>
									<p class="text-md text-black">
										<c:out value="${ticket.getData()}" />
									</p>
								</h5></td>
							<td>
							
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${ticket.getApplicazione().getNome()}" />
									</p>
								</h5></td>
							<td>

								<% String path = request.getContextPath(); %>
	                           <form action="<%=path%>/Utente/GestioneTicket" method="post">
									
									 
   
									<input type="submit" class="btn btn-info" name="azione"
										value="Modifica Ticket">
										
							
								
									
									
									<input type="submit" class="btn btn-info" name="azione"
										value="Elimina Ticket"> 
										
								
									
									<input type="hidden"
										id="idTicket" name="idTicket"
										value="<c:out value='${ticket.getId()}'></c:out>" />
								</form>

							</td>
						</tr>

					</c:forEach>
				</table>
<br>
<form action="tornaIndietro" method="post">

		<input type="submit" class="btn btn-primary btn-block"
			style="width: 125px; height: 45px; margin: auto" name="azione"
			value="Torna Indietro">
	</form>
	
			</div>
		</div>
	</div>


</body>
</html>