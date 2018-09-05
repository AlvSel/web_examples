<%@ page import = "java.util.*"%>
<!DOCTYPE html>
<html>
	<head>
		<title>LoginForm</title>
		<link href="/ShareInfo/css/styleSheet.css" rel="stylesheet" />
	</head>
	<body>
		<header>
			<h1>A webapp to share short messages</h1>
			<h2>Log in form</h2>
		</header>
		<%
			String err = (String)request.getAttribute("error");
			if(err=="ERROR"){
				String errMes = "<section> <font> ERROR: </font>Ha ocurrido un error a la hora de realizar el login. </section>";
				%><%=errMes%><%
			}
		%>
		<section>
			<form method="POST" action="/ShareInfo/servlet/LoginServlet">
				<table>
	   				<tr>
	   					<td>Email:</td>
	   					<td><input name="email"/></td>
	   				</tr>
	   				<tr>
	   					<td>Password:</td>
	   					<td><input type="password" name="password"/></td>
	   				</tr>
	 			</table>
				<button>Send</button>
			</form>
		</section>
		<section>
			<a href="/ShareInfo/html/signupForm.html">
				<font>Sign Up</font>
			</a>
		</section>
		<footer> Web Systems - EUITI Bilbao -- Server Date:
			<%=new Date().toString()%>
			<script language="javascript">
				var fecha = new Date();
				document.write("-- Client Date: ");
				document.write(fecha);
			</script>
		</footer> 
	</body>
</html>