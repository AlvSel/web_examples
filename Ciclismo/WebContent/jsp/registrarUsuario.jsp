<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>RegistroForm</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Registro</h1>
			<h2>Introduzca los datos</h1>
		</header>
		<%
			String err = (String)request.getAttribute("error");
			if(err=="datos"){
				String errMes = "<section id='error'> <font> ERROR: </font>Necesarios rellenar m&iacutenimo usuario y password. </section>";
				%><%=errMes%><%
			}else if(err=="existe"){
				String errMes = "<section id='error'> <font> ERROR: </font>El usuario ya existe. </section>";
				%><%=errMes%><%
			}
		%>
		<section>
			<form method="POST" action="/Ciclismo/servlet/Registro">
				<table>
					<tr>
	   					<td>Usuario:</td>
	   					<td><input name="usuario"/></td>
	   				</tr>
	   				<tr>
	   					<td>Password:</td>
	   					<td><input type="password" name="password"/></td>
	   				</tr>
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
	 			<br>
				<button>Registrarse</button>
			</form>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>