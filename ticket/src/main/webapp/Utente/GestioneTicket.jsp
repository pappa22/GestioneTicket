<%@page
	import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="java.util.List"%>
<%@page import="it.dstech.modelli.Ticket"%>
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
		List<Ticket> listaTicket = (List<Ticket>) request.getAttribute("ticket");
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
								<p class="text-md text-danger">Priorità</p>
							</h5></th>

						<th><h5>
								<p class="text-md text-danger">Gestione Ticket</p>
							</h5></th>
						<th><h5></h5></th>
					</tr>

					<%
						for (Ticket ticket : listaTicket) {
					%>
					<tr>
						<td><h5>
								<p class="text-md text-black">
									<%=ticket.getNome()%>
								</p>
							</h5></td>
						<td><h5>
								<p class="text-md text-black">
									<%=ticket.getDescrizione()%>
								</p>
							</h5></td>
						<td><h5>
								<%
									if (ticket.isStato()) {
								%>
								<p class="text-md text-black">
								<p>Attivo</p>
								</p>

								<%
									}
								%>
								<%
									if (!ticket.isStato()) {
								%>

								<p class="text-md text-black">
								<p>Chiuso</p>
								</p>

								<%
									}
								%>

							</h5></td>

						<td><h5>
								<p class="text-md text-black">
									<%=ticket.getData()%>
								</p>
							</h5></td>

						<td><h5>
								<p class="text-md text-black">
									<%=ticket.getApplicazione().getNome()%>
								</p>
							</h5></td>

						<td><h5>
								<p class="text-md text-black">
									<%if(ticket.getPriorita().equals("1")){ %>
									Bassa
									<%}%>
									<%if(ticket.getPriorita().equals("2")){ %>
									Media
									<%}%>
									<%if(ticket.getPriorita().equals("3")){ %>
									Alta
									<%}%>
								</p>
							</h5></td>
						<td>
							<%
								String path = request.getContextPath();
							%>
							<form action="<%=path%>/Utente/GestioneTicket" method="post">

								<%
									if (ticket.isStato()) {
								%>

								<input type="submit" class="btn btn-info" name="azione"
									value="Modifica Ticket"> <input type="submit"
									class="btn btn-info" name="azione" value="Elimina Ticket">

								<%
									}
								%>

								<input type="hidden" id="idTicket" name="idTicket"
									value="<%=ticket.getId()%>" />
							</form>

						</td>
					</tr>
					<%
						}
					%>

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