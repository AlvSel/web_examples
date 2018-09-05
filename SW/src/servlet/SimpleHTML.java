package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHTML extends HttpServlet{

	private static final long serialVersionUID = -4351721771239076641L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//le decimos que vamos a devolver HTML
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		//construimos la pagina HTML
		out.println("<HTML>");
		out.println("<HEAD><TITLE>Servlet simple que genera un HTML</TITLE></HEAD>");
		out.println("<BODY>");
		out.println("<H2>Servlet que genera un HTML</H2>");
		out.println("<P>Este Servlet devuelve el código de una página HTML que el ");
		out.println("navegador interpreta y muestra como tal.");
		out.println("</BODY>");
		out.println("</HTML>");
		
		out.flush(); //fuerza la escritura de los datos
		out.close(); //cierra el flujo
	}
}