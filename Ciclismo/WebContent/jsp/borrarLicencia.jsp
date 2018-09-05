<%@page import="helper.db.MySQLdb"%>
<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>BorrarLicencia</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>Retirar licencias</h1>
			<h2>Selecciona el usuario</h2>
		</header>
		<section>
			<form method="POST" action="/Ciclismo/servlet/BorrarLicencia">
				<% ArrayList<String> lista=MySQLdb.getUsersConLicencia();%>
				<select name="nombreUsuario">
					<%for(int i=0;i<lista.size();i++){
						String nombre=lista.get(i);%>
						<option value="<%=nombre%>"><%=nombre %></option> 
					<%}%>
				</select>
				<button>Retirar Licencia</button>
			</form>
		</section>
		<footer> Federación Vizcaina de Ciclismo:
			<%=new Date().toString()%>
		</footer> 
	</body>
</html>