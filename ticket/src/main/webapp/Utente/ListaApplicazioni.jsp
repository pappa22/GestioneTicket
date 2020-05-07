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
<title>Ticket Utente</title>
</head>
<body>
	<br>
	<%
		String messaggio = (String) request.getAttribute("mess");
	if (messaggio != null) {
	%>

	<p class="text-md-center text-white"><%=messaggio%></p>

	<%
		}
	%>
	<br>

	<form action="tornaIndietro" method="post">

		<input type="submit" class="btn btn-primary btn-block"
			style="width: 125px; height: 45px; margin: auto" name="azione"
			value="Torna Indietro">
	</form>
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
								<p class="text-md text-danger">Creatore Applicazione</p>
							</h5></th>
						<th><h5>
								<p class="text-md text-danger">Ticket</p>
							</h5></th>
					</tr>

					<c:forEach items="${listaApplicazioni}" var="app">

						<tr>
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${app.getNome()}" />
									</p>
								</h5></td>
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${app.getDescrizione()}" />
									</p>
								</h5></td>
							<td><h5>
									<p class="text-md text-black">
										<c:out value="${app.getAdmin()}" />
									</p>
								</h5></td>

							<td>

								<form action="Utente/SceltaUtente" method="post">
									
									<c:if test="${empty app.getListaTicket()}">  
   
									<input type="submit" class="btn btn-info" name="azione"
										value="Crea Ticket">
										
									</c:if> 
								
									<c:if test="${not empty app.getListaTicket()}"> 
									
									<input type="submit" class="btn btn-info" name="azione"
										value="Gestione Ticket"> 
										
									</c:if> 
									
									<input type="hidden"
										id="idApp" name="idApp"
										value="<c:out value='${app.getId()}'></c:out>" />
								</form>

							</td>
						</tr>

					</c:forEach>
				</table>

			</div>
		</div>
	</div>

</body>
</html>