<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Inicio</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Federación Vizcaina de Ciclismo</h1>
			<h2>Pagina Inicio</h2>
		</header>
		<section>
			<a href="/Ciclismo/jsp/registrarUsuario.jsp">
				<font>Registrarse</font><br>
			</a>
			<a href="/Ciclismo/jsp/identificarUsuario.jsp">
				<font>Identificarse</font><br>
			</a>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>