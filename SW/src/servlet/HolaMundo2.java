package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HolaMundo2 extends HttpServlet{

	private static final long serialVersionUID = -4351721771239076641L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("--->Entering HolaMundo servlet");
		PrintWriter out = response.getWriter();
		out.println("Hola mundo");
		System.out.println("<---Exiting HolaMundo servlet");
	}
}