package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundoCabeceras extends HttpServlet{

	private static final long serialVersionUID = -4351721771239076641L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		out.println("Hola mundo");
		
		out.println("CABECERAS");
		Enumeration<String> headerNames = request.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String headerName = (String)headerNames.nextElement();
			out.println(headerName + ": "+request.getHeader(headerName));
		}
		response.setContentType("text/plain");
		response.addHeader("Pragma", "no-cache");
	}
}