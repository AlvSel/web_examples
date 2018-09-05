<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ActualizarForm</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Actualizar Perfil de Usuario</h1>
			<h2>Introduzca los datos</h2>
		</header>
		<section>
			<form method="POST" action="/Ciclismo/servlet/UpdateDatos">
				<table>
	   				<tr>
	   					<td>Nombre:</td>
	   					<td><input name="nombre"/></td>
	   				</tr>
	   				<tr>
	   					<td>Apellidos:</td>
	   					<td><input name="apellidos"/></td>
	   				</tr>
	   				<tr>
	   					<td>Calle:</td>
	   					<td><input name="calle"/></td>
	   				</tr>
	   				<tr>
	   					<td>CP:</td>
	   					<td><input name="cp"/></td>
	   				</tr>
	   				<tr>
	   					<td>Ciudad:</td>
	   					<td><input name="ciudad"/></td>
	   				</tr>
	   				<tr>
	   					<td>Email:</td>
	   					<td><input name="email"/></td>
	   				</tr>
	   				<tr>
	   					<td>Tlf:</td>
	   					<td><input name="tlf"/></td>
	   				</tr>
	 			</table>
				<button>Actualizar</button>
			</form>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>