<%@page import="it.dstech.modelli.Utente"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

    <!-- Font Icon -->
    <link rel="stylesheet" href="static/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="static/css/style.css">
<head>
<meta charset="ISO-8859-1">
<title>Gestione Ticket</title>
</head>

<body>
<!-- 	<div class="center"> -->

<%-- 		<% 
 			String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
<%-- 		%> --%>
<%-- 		<h1 style="color: red;"><%=messaggio%></h1> --%>

<%-- 		<% 
 			}
<%-- 		%> --%>

<!-- 		<h1>Benvenuto in Gestione Ticket!</h1> -->

<!-- 		<i>Da qui puoi effettuare i ticket di lamentela per le tue -->
<!-- 			applicazioni</i> <br> -->
<!-- 		<h3>Effettua l'accesso o registrati se ancora non hai un account -->
<!-- 			utente:</h3> -->


<!-- 		<form action="Accesso" method="post"> -->
			
<!-- 				<label for="username">Username:</label><br> <input type="email" -->
<!-- 					required="required" name="mail" placeholder="E-mail"><br> -->
<!-- 				<label for="password">Password:</label><br> <input -->
<!-- 					type="password" required="required" name="password" -->
<!-- 					placeholder="Password"><br> -->
<!-- 				<br> -->

<!-- 			<input type="submit" class="btn btn-danger" class="button" -->
<!-- 				name="scelta" value="Login" /> -->
<!-- 		</form> -->

<!-- 		<br> <br>Non sei ancora registrato? <br> <br> -->
<!-- 		<form action="Accesso" method="post"> -->
<!-- 			<input type="submit" class="btn btn-primary" name="scelta" -->
<!-- 				value="Registrazione" /> -->
<!-- 		</form> -->
<!-- 	</div> -->
<!-- </body> -->

<body>
	<div class="main">
  <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="static/images/signup-image.jpg" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Gestione Ticket</h2>
                        <br>
  		<% 
 			String messaggio = (String) request.getAttribute("mess");
		if (messaggio != null) {
 		%> 
 		<h5 style="color: red;"><%=messaggio%></h5> 

		<% 
 			}
 		%> 
                        
                        <form action="Accesso" method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="mail" required="required" id="your_name" placeholder="Email"/>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" required="required" name="password" id="your_pass" placeholder="Password"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="scelta" id="signin" class="form-submit" value="Login"/>
                            </div>
                        </form>
                            <div class="social-login">
                        		<form action="Accesso" method="post">
                           <button type="submit" style="background: none!important; border: none; padding: 0!important;color: #069; text-decoration: underline; cursor: pointer;" name="scelta" value="Registrazione">Non sei ancora Registrato? Registrati</button>
                           </form>
                        </div>
                        
                    </div>
                </div>
            </div>
        </section>
</div>
  <!-- JS -->
</body>
</html>