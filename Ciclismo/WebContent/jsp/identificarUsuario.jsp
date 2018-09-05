<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>IdentificarForm</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Identificarse</h1>
			<h2>Sign in</h1>
		</header>
		<%
			String err = (String)request.getAttribute("error");
			if(err=="ERROR"){
				String errMes = "<section id='error'> <font> ERROR: </font>Necesarios usuario y password v&aacutelidos. </section>";
				%><%=errMes%><%
			}
		%>
		<section>
			<form method="POST" action="/Ciclismo/servlet/Identificar">
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
						<td><button>Identificarse</button></td>
	   				</tr>
	 			</table>
			</form>
		</section>
		<footer> Federación Vizca&iacutena de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>