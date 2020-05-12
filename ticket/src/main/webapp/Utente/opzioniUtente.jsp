<%@page import="it.dstech.modelli.Utente"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/profilo.css">
<meta charset="ISO-8859-1">
<title>Profilo Utente</title>
</head>
<body>
  
  
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">Gestione Ticket</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
      </div>
    </div>
  </nav>
  
  <% String messaggio = (String) request.getAttribute("mess");
    	Utente u = (Utente) session.getAttribute("utente");
    
  if (messaggio != null ){
    %>
    <h5 style="color:Tomato;">ERRORE</h5>
    <%=messaggio%>
    <% } else {
%>

  <header class="bg-primary text-white">
    <div class="container text-center">
      <img alt="immagine" class="avatar" style="vertical-align: middle; width: 150px; height: 150px; border-radius: 50%;" src="data:image/jpg;base64,<%=u.getImage()%>"> <br>
      <h1>Benvenuto/a <%=u.getNome() %></h1>
      <p class="lead"></p>
    </div>
  </header>

  <section id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Gestione Ticket</h2>
          <p class="lead"></p>
	 <% String path = request.getContextPath(); %> 
    <form action="<%=path%>/Utente/SceltaUtente" method="post">
      <input type="submit"  class = "button" name ="azione" value="Lista Applicazioni" /> <br><br>
      <input type="submit"  class = "button" name ="azione" value="Log Out" /> <br><br>
    </form>        
        </div>
      </div>
    </div>
  </section>
  <% } %>
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright © </p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="js/scrolling-nav.js"></script>
  
  
  
</body>
</html>
<!-- <div class="container"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-xl align-self-center "> -->
<%--     <% String messaggio = (String) request.getAttribute("mess"); 
//     	Utente u = (Utente) session.getAttribute("utente");
    
//   if (messaggio != null ){
<%--     %> --%>
<!--     <h1 style="color:Tomato;">ERRORE</h1> -->
<%--     <%=messaggio%> --%>
<%--     <% } 
//   else {
<%-- %> --%>
<%--       <h1>Benvenuto/a <%=u.getNome()%></h1> --%>
<!--  <br> -->
<%-- <img alt="image" style="vertical-align: middle; width: 150px; height: 150px; border-radius: 50%;" src="data:image/jpg;base64, <%= u.getImage() %>"> <br> --%>
<!--       <br>Qui puoi recensire le nostre applicazioni.<br> -->
<!-- <br> -->
<%-- <% String path = request.getContextPath(); %> --%>
<%--     <form action="<%=path%>/Utente/SceltaUtente" method="post"> --%>
<!--       <input type="submit"  class = "button" name ="azione" value="Lista Applicazioni" /> <br><br> -->
<!--       <input type="submit"  class = "button" name ="azione" value="Log Out" /> <br><br> -->
<!--     </form> -->
<%-- <%--     <% } %> --%> 
<!--   </div></div></div> -->