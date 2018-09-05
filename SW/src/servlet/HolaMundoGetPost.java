package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundoGetPost extends HttpServlet{

	private static final long serialVersionUID = -4351721771239076641L;

	/*
	 * para que funcione en web.xml
	 * <url-pattern>/servlet/HolaMundoGetPost</url-pattern>(non-Javadoc)
	 */
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("--> Entering HolaMundoGetPost servlet GET");
		String nombre = request.getParameter("nombre");
		PrintWriter out = response.getWriter();
		try{
			out.println("Hola, "+ nombre);
			out.println("Has pasado tu nombre con GET en la URI.");
		} finally{
			out.close();
		}
		System.out.println("<-- Exiting HolaMundoGetPost servlet GET");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("--> Entering HolaMundoGetPost servlet POST");
		String nombre = request.getParameter("nombre");
		PrintWriter out = response.getWriter();
		try{
			out.println("Hola, "+ nombre);
			out.println("Has pasado tu nombre con POST en la peticion.");
		} finally{
			out.close();
		}
		System.out.println("<-- Exiting HolaMundoGetPost servlet POST");
	}
}