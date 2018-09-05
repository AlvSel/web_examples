package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHTMLDispatched extends HttpServlet{

	private static final long serialVersionUID = -4351721771239076641L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("--> Entering SimpleHTMLDispatched servlet GET");		
		response.setContentType("text/html");
		RequestDispatcher rd = request.getRequestDispatcher("holamundo/html/pagina.html");
		rd.forward(request, response);
		System.out.println("Redirecting to HTML document.");	
		System.out.println("<-- Exiting SimpleHTMLDispatched servlet GET");
	}
}