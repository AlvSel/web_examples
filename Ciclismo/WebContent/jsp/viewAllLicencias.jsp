<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,helper.info.*,helper.db.*" %>
<%ArrayList<MessageInfo> licenciasList = MySQLdb.getAllLicencias();%>
<html>
	<head>
		<title>View Licencias</title>
		<link href="/Ciclismo/css/styleSheet.css" rel="stylesheet" />
		<script type="text/javascript">
			function GetLicencias() { 
				var request = new XMLHttpRequest();
				request.onreadystatechange = function(){
					if (request.readyState == 4){
						if (request.status == 200){
							if (request.responseText != null){
								var jsonObj = JSON.parse(request.responseText);
								var	table = "<tr><th>Username</th> <th>Licencia</th> <th>Fecha</th></tr>";
								for (i = 0; i < jsonObj.length; i++){
									table += "<tr><td>" + jsonObj[i].username + "</td>";
									table += "<td>" + jsonObj[i].licencia + "</td>";
									table += "<td>" + jsonObj[i].fechaTiempo + "</td></tr>";
								}
								document.getElementsByName("licenciastable")[0].innerHTML = table;
							}
						}
					}
				};
				request.open("GET", "/Ciclismo/servlet/LicenciasAllAjax", true);
				request.send(null);
				setTimeout("GetLicencias()", 1000);
 			};
		</script>
	</head>
	<body onload="GetLicencias()">
		<header>
			<h1>Federación Vizcaina Ciclismo</h1>
			<h2>View Licencias</h2>
		</header>
		<section>
			<table name="licenciastable" class="tablaLicencias">
				<tr>
					<th>Username</th>
					<th>Licencia</th>
					<th>Fecha</th>
				</tr>
				<%
					for (int i = 0; i < licenciasList.size(); i++) {
						MessageInfo messageInfo = licenciasList.get(i);
				%>
				<tr>
					<td><%=messageInfo.getUsername()%></td>
					<td><%=messageInfo.getLicencia()%></td>
					<td><%=messageInfo.getFechaTiempo()%></td>
				</tr>
				<%
					}
				%>
			</table>
		</section>
		<footer>Federación Vizcaina Ciclismo: <%=new Date().toString()%></footer>
	</body>
</html>