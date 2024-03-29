<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<head>
		<title>Banana GEST | Login</title>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
		<link rel="stylesheet" type="text/css" href="css/login.css">
	</head>
	<body>
		<header class="container-fluid">			
			<div class="row">
				<div class="register col-xs-4 col-sm-4 col-md-4 col-lg-4"><span><img src="images/bananas.png"> Welcome to BananaGEST!</span></div>
				<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4"><h1>Banana GEST</h1></div>
				<div class="register col-xs-4 col-sm-4 col-md-4 col-lg-4"><h4><a href="#">Registrarse</a></h4></div>
			</div>		
		</header>
		<main class="container-fluid">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<img id= "bananas" src="images/bananas_grande.png"/>
					<form action="login" method="post" id="formulario">
						<p class="error">${error}</p>
						<p class="disconnect">${disconnect}</p>
						<div class="intro_user">
							<img class="alinear" src="images/user.png"/>
							<input type="text" name="email" placeholder="Email" required="true" autofocus/>
						</div>
						<div class="intro_user">
							<img class="alinear" src="images/lock.png"/>
							<input type="password" name="password" placeholder="Password" maxlength="12" minlength="4" required="true"/>
						</div>
						<div class="intro_user">
						<a class="password" href="#">He olvidado mi contraseņa</a>
						</div>	
						<div class="intro_user">
							<button>Log In</button>
						</div>
					</form>										
					<div class="intro_user">
						<a href="https://twitter.com/?lang=es">
						<img src="images/twitter.png"/>
						</a>
						<a href="https://es-es.facebook.com/">
						<img src="images/facebook.png"/>
						</a>
						<a href="https://es.linkedin.com/">
						<img src="images/linkedin.png"/>	
						</a>
						<a href="https://www.instagram.com/?hl=es">
						<img src="images/instagram.png"/>
						</a>
						<img src="images/share.png"/>
					</div>
				</div>
			</div>
		</main>
		<footer class="container-fluid">
			<div class="row">
				<span class="col-xs-12 col-sm-12 col-md-12 col-lg-12">Banana GEST - Todos los derechos reservados</span>
			</div>
		</footer>
	</body>
</html>