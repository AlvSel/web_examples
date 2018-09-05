<%@page import="servlet.UpdateLicencia"%>
<%@page import="helper.db.MySQLdb"%>
<%@page import="servlet.Identificar"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>UpdateLicencia</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Federación Vizcaina de Ciclismo</h1>
			<h2>Actualizar Licencia</h2>
		</header>
		<section>
			<form method="POST" action="/Ciclismo/servlet/UpdateLicencia">
				<input type="radio" name="licencia" value="E"> Elite<br>
				<input type="radio" name="licencia" value="M"> Master<br>
				<input type="radio" name="licencia" value="C"> Cicloturista<br>
				<input type="radio" name="licencia" value="N"> Ninguna<br>
				<button>Actualizar</button>
			</form>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>