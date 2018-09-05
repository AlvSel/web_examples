<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,helper.info.*" %>
<% ArrayList<MessageInfo> messageList = (ArrayList) request.getAttribute("messageList");
   String username = (String) session.getAttribute("username");
   ServletContext context = request.getServletContext();
   HashMap<String, String> loggedinUsers = (HashMap) context.getAttribute("loggedin_users"); 
	 HttpSession sesion = request.getSession();%>
<html>
<head>
<title>View Messages</title>
<link href="/ShareInfo/css/styleSheet.css" rel="stylesheet" />

<script type="text/javascript">
	function GetMsg() {
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				if (request.status == 200) {
					if (request.responseText != null) {
						var jsonObj = JSON.parse(request.responseText);
						var	table = "<tr><th>Username</th> <th>Message</th></tr>";
						for (i = 0; i < jsonObj.length; i++) {
							table += "<tr><td>" + jsonObj[i].username + "</td>";
							table += "<td>" + jsonObj[i].message + "</td></tr>";
						}
						document.getElementsByName("msgtable")[0].innerHTML = table;
					}
				}
			}
		};
		request.open("GET", "/ShareInfo/servlet/MsgAjax", true);
		request.send(null);
		setTimeout("GetMsg()", 1000);
	};
</script>
</head>

<body onload="GetMsg()">
	<header>
	table
	<h1>A webapp to share short messages</h1>
	<h3>View Messages</h3>
	</header>
	<section> <a href="/ShareInfo/servlet/MainServlet"> <font>Refresh</font></a> </section>
	<section> <font>Active users: </font> <%
 	for (Map.Entry<String, String> entry : loggedinUsers.entrySet()) {
 %>
	<%=entry.getKey()%> <%
 	}
 %> </section>
	<section> <font>You are logged in as: </font> <%=sesion.getAttribute("username")%></section>
	<section>
	<form method="POST" action="/ShareInfo/servlet/MainServlet">
		<table>
			<tr>
				<td>Message:</td>
				<td><textarea name="message" id="message"></textarea></td>
			</tr>
		</table>
		<button>Send</button>
	</form>
	</section>
	<section>
	<table name="msgtable">
		<tr>
			<th>Username</th>
			<th>Message</th>
		</tr>
		<%
			for (int i = 0; i < messageList.size(); i++) {
				MessageInfo messageInfo = messageList.get(i);
		%>
		<tr>
			<td><%=messageInfo.getUsername()%></td>
			<td><%=messageInfo.getMessage()%></td>
		</tr>
		<%
			}
		%>
	</table>
	</section>
	<footer> Web Systems - EUITI Bilbao -- Server Date: <%=new Date().toString()%>
	<script language="javascript">
		var f = new Date();
		document.write(" -- Client Date: ");
		document.write(f);
	</script> </footer>
</body>
</html>