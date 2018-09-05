<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>ActualizarPassword</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Actualizar Password de Usuario</h1>
			<h2>Introduzca los datos.</h2>
		</header>
		<%
			String err = (String)request.getAttribute("error");
			if(err=="ERROR"){
				String errMes = "<section id='error'> <font> ERROR: </font>Necesario que sea correcta password actual y sean iguales las nuevas. </section>";
				%><%=errMes%><%
			}
		%>
		<section>
			<form method="POST" action="/Ciclismo/servlet/UpdatePassword">
				<table>
	   				<tr>
	   					<td>Password Actual:</td>
	   					<td><input name="actual"/></td>
	   				</tr>
	   				<tr>
	   					<td>Password Nueva:</td>
	   					<td><input name="nueva1"/></td>
	   				</tr>
	   				<tr>
	   					<td>Repetir Password Nueva:</td>
	   					<td><input name="nueva2"/></td>
	   				</tr>
	 			</table>
				<button>Actualizar Password</button>
			</form>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>