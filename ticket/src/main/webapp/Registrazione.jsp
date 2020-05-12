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

<!-- 	<form action="Registrazione" method="post" -->
<!-- 		enctype="multipart/form-data"> -->
<!-- 		<h4> -->
<!-- 			<p class="text-xl-center text-black">Nome</p> -->
<!-- 		</h4> -->
<!-- 		<input type="text" required="required" class="form-control" id="nome" -->
<!-- 			name="nome" style="width: 250px; height: 50px; margin: auto" -->
<!-- 			placeholder="Nome"> <br> -->
<!-- 		<h4> -->
<!-- 			<p class="text-xl-center text-black">Cognome</p> -->
<!-- 		</h4> -->
<!-- 		<input type="text" required="required" class="form-control" -->
<!-- 			id="cognome" name="cognome" -->
<!-- 			style="width: 250px; height: 50px; margin: auto" -->
<!-- 			placeholder="Cognome"> <br> -->
<!-- 		<h4> -->
<!-- 			<p class="text-xl-center text-black">Mail</p> -->
<!-- 		</h4> -->
<!-- 		<input type="text" required="required" class="form-control" id="mail" -->
<!-- 			name="mail" style="width: 250px; height: 50px; margin: auto" -->
<!-- 			placeholder="Mail"> <br> -->
<!-- 		<h4> -->
<!-- 			<p class="text-xl-center text-black">Password</p> -->
<!-- 		</h4> -->
<!-- 		<input type="password" required="required" class="form-control" -->
<!-- 			id="password" name="password" -->
<!-- 			style="width: 250px; height: 50px; margin: auto" -->
<!-- 			placeholder="Password"> <br> -->
<!-- 		<h4> -->
<!-- 			<p class="text-xl-center text-black">Immagine</p> -->
<!-- 		</h4> -->
<!-- 		<p class="text-xl-center"> -->
<!-- 			<input type="file" required="required" id="image" name="image" -->
<!-- 				placeholder="Inserisci immagine profilo"> -->
<!-- 		</p> -->
<!-- 		<br> <input type="submit" class="btn btn-danger btn-block" -->
<!-- 			style="width: 150px; height: 45px; margin: auto" name="azione" -->
<!-- 			value="Registrati"> -->
<!-- 	</form> -->
	
	
	 <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Registrazione</h2>
                        <form action="Registrazione" method="POST" class="register-form" id="register-form" enctype="multipart/form-data">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="nome" id="name" required="required" placeholder="Nome"/>
                            </div>
                             <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="cognome" id="name" required="required" placeholder="Cognome"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="mail" id="email" required="required" placeholder="Email"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="pass" required="required" placeholder="Password"/>
                            </div>
                            <div class="form-group">
                                <label for="agree-term" class="label-agree-term">Immagine del profilo</label><br>
								<input type="file" required="required" id="image" name="image"
					 				placeholder="Inserisci immagine profilo"> 
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="azione" id="signup" class="form-submit" value="Registrati"/>
                            </div>
                        </form>
	<%
		String path = request.getContextPath();
	%>
	<form action="<%=path%>/" method="post">
	<div class="form-group form-button">
		<input type="submit" class="form-submit" id="signup" value="Torna Indietro">
	</div>
	</form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="static/images/signup-image.jpg" alt="sing up image"></figure>
                    </div>
                </div>
            </div>
        </section>
        </div>
	<br>
	<br>
</body>
</html>