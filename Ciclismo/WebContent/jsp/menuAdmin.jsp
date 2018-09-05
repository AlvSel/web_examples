<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>MenuAdmin</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="styleSheet" />
	</head>
	<body>
		<header>
			<h1>Federación Vizcaina de Ciclismo</h1>
			<h2>Menu Admin</h2>
		</header>
		<section id="menu">
			<a href="/Ciclismo/jsp/updatePassword.jsp">
				<font>Cambiar password</font><br>
			</a>
			<a href="/Ciclismo/jsp/updateDatos.jsp">
				<font>Modificar datos</font><br>
			</a>
			<a href="/Ciclismo/jsp/borrarLicencia.jsp">
				<font>Retirar Licencia</font><br>
			</a>
			<a href="/Ciclismo/jsp/viewAllLicencias.jsp">
				<font>Mostrar todas las Licencias</font><br>
			</a>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>